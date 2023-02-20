package com.kot.construct.access.packageB;

import com.kot.construct.access.packageA.AccessA;

/**
 * @author yf
 * @create 2022-11-25 16:23
 */
public class AccessB extends AccessA {
    public AccessB(int a, int b) {
        super(a, b);
    }

    protected AccessB(int a, int b, int c, int d) {
        super(a, b, c, d);
    }

    public static void main(String[] args) {

        //在其子类中可以访问public和protected两种的

        innerClass2 innerClass2 = new AccessB(1, 2).new innerClass2(1, 2);
        innerClass4 innerClass4 = new AccessB(1, 2).new innerClass4(1, 2);
    }
}
