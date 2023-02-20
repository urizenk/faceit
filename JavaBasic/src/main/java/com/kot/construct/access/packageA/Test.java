package com.kot.construct.access.packageA;

/**
 * @author yf
 * @create 2022-11-25 22:57
 */
public class Test {
    public static void main(String[] args) {
        //在同一个包下，除了private都可以看到
        AccessA.innerClass1 innerClass1 = new AccessA(1).new innerClass1(1);
        AccessA.innerClass2 innerClass2 = new AccessA(1).new innerClass2(1);
        AccessA.innerClass4 innerClass4 = new AccessA(1).new innerClass4(1);
    }
}
