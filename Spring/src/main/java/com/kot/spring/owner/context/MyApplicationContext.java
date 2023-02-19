package com.kot.spring.owner.context;

import com.kot.spring.owner.anno.AutoWired;
import com.kot.spring.owner.anno.CompantScan;
import com.kot.spring.owner.anno.Component;
import com.kot.spring.owner.anno.Scope;
import com.kot.spring.owner.aware.BeanNameAware;
import com.kot.spring.owner.bean.BeanDefinition;
import com.kot.spring.owner.bean.BeanPostProcessor;
import com.kot.spring.owner.bean.InitializingBean;
import com.kot.spring.owner.config.MyConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yf
 * @create 2022-12-15 16:10
 */
public class MyApplicationContext {

    private Class configClass;
    private ArrayList<BeanPostProcessor> beanPostProcessorArrayList = new ArrayList<>();
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();

    public MyApplicationContext(Class configClass) throws Exception {
        this.configClass = configClass;
        if (configClass.isAnnotationPresent(CompantScan.class)) {
            CompantScan compantScan = (CompantScan) configClass.getAnnotation(CompantScan.class);
            String path = compantScan.value();
            path = path.replace(".","/");
            ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    System.out.println(fileName);
                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                        className =  className.replace("\\",".");
                        System.out.println(className);
                        Class<?> aClass = classLoader.loadClass(className);
                        if (aClass.isAnnotationPresent(Component.class)) {
                            if (BeanPostProcessor.class.isAssignableFrom(aClass)) {
                                BeanPostProcessor instance = (BeanPostProcessor) aClass.newInstance();
                                beanPostProcessorArrayList.add(instance);
                            }

                            Component component = aClass.getAnnotation(Component.class);
                            String beanName = component.value();
                            if (beanName.equals("")) {
                                beanName = Introspector.decapitalize(aClass.getSimpleName());
                            }
                            BeanDefinition beanDefinition = new BeanDefinition();
                            if (aClass.isAnnotationPresent(Scope.class)) {
                                Scope scope = aClass.getAnnotation(Scope.class);
                                String scopeName = scope.value();
                                beanDefinition.setScope(scopeName);
                            }else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinition.setType(aClass);
                            beanDefinitionMap.put(beanName,beanDefinition);
                        }
                    }
                    for (String beanName : beanDefinitionMap.keySet()) {
                        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
                        if (beanDefinition.getScope().equals("singleton")) {
                            Object bean = createBean(beanDefinition, beanName);
                            singletonObjects.put(beanName,bean);
                        }
                    }
                }
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition, String beanName) throws Exception{
        Class type = beanDefinition.getType();
        Object instance = type.getConstructor().newInstance();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoWired.class)) {
                field.setAccessible(true);
                field.set(instance,getBean(field.getName()));
            }
        }
        if(instance instanceof BeanNameAware){
            ((BeanNameAware) instance).setBeanName(beanName);
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessorArrayList) {
            instance = beanPostProcessor.postProcessBeforeInitialization(beanName, instance);
        }

        //初始化
        if(instance instanceof InitializingBean){
            ((InitializingBean) instance).afterPropertiesSet();
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessorArrayList) {
           instance = beanPostProcessor.postProcessAfterInitialization(beanName,instance);
        }

        return instance;
    }

    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null){
            throw new NullPointerException();
        }else {
            String scope = beanDefinition.getScope();
            if("singleton".equals(scope)){
                Object bean = singletonObjects.get(beanName);
                if(bean == null){
                    Object bean1 = createBean(beanDefinition, beanName);
                    singletonObjects.put(beanName,bean);
                }
                return bean;
            }else {
                return createBean(beanDefinition,beanName);
            }
        }

    }
}
