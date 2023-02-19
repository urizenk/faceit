package com.kot.spring.service;

import com.kot.spring.owner.config.MyConfig;
import com.kot.spring.owner.context.MyApplicationContext;
import com.kot.spring.proxy.UserInterface;

import java.lang.reflect.Field;

/**
 * @author yf
 * @create 2022-12-15 15:59
 */
public class Test {

//    @org.junit.Test
//    public void testFileds(){
//        Class<MyApplicationContext> aClass = MyApplicationContext.class;
//        Field[] fields = aClass.getFields();
//        System.out.println(fields.length);
//        for (Field field : fields) {
//            System.out.println(field.toString());
//        }
//    }
    public static void main(String[] args) throws Exception {
        MyApplicationContext myApplicationContext = new MyApplicationContext(MyConfig.class);
        myApplicationContext.getBean("orderService");
        UserInterface userService = (UserInterface) myApplicationContext.getBean("userService");
        userService.test();
    }
}
