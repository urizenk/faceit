package com.kot.spring.service;

import com.kot.spring.owner.anno.AutoWired;
import com.kot.spring.owner.anno.Component;
import com.kot.spring.owner.anno.Scope;
import com.kot.spring.owner.aware.BeanNameAware;
import com.kot.spring.owner.bean.InitializingBean;
import com.kot.spring.proxy.UserInterface;

/**
 * @author yf
 * @create 2022-12-15 16:16
 */
@Component("userService")
@Scope
public class UserService implements BeanNameAware , InitializingBean, UserInterface {

    @AutoWired
    private OrderService orderService;

    @Override
    public void test(){
        System.out.println(orderService);
    }
    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("开始初始化");
    }
}
