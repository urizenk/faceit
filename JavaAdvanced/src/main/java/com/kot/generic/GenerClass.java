package com.kot.generic;

/**
 * @author yf
 * @create 2022-11-28 22:41
 */
public class GenerClass {

    public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {

        T t = c.newInstance();
        return t;
    }
}
