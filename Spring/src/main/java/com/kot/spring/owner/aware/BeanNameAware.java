package com.kot.spring.owner.aware;

/**
 * @author yf
 * @create 2022-12-15 17:50
 */
public interface BeanNameAware extends Aware{
    public void setBeanName (String beanName);


}
