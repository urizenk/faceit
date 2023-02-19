package com.kot.book.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author yf
 * @create 2022-12-17 21:22
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化回调");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("结束时的回调");
    }
}
