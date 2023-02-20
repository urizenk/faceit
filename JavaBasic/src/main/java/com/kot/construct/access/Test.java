package com.kot.construct.access;

import com.kot.construct.access.packageA.AccessA;

/**
 * @author yf
 * @create 2022-11-25 22:43
 */
public class Test {
    public static void main(String[] args) {
        //内部类的实例化

        //在包外部只有public标识的才能实例化
        AccessA.innerClass2 innerClass2 = new AccessA(1, 2).new innerClass2(1, 2);

    }
}
