package com.kot.oop.object;

/**
 * @author yf
 * @create 2022-11-26 20:15
 */
public class Test {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass());
        System.out.println(o.hashCode());

        System.out.println(o.toString());


    }
}
