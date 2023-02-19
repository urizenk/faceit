package com.kot.spring.owner.bean;

/**
 * @author yf
 * @create 2022-12-15 18:06
 */
public interface BeanPostProcessor {
    public Object  postProcessBeforeInitialization(String beanName, Object bean);

    public Object  postProcessAfterInitialization(String beanName, Object bean);
}
