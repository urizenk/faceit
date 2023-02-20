package com.kot.oop.overload;

/**
 * @author yf
 * @create 2022-11-26 21:16
 */
public class Test {
    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();
        overLoad.cxk("鸡");
        overLoad.cxk("鸡","你");
        overLoad.cxk("鸡","你","太");
        overLoad.cxk("鸡","你","太","美");
    }
}
