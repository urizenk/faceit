package com.kot.oop.packaging;

/**
 * @author yf
 * @create 2022-11-28 1:24
 */
public class IntegerTest {

    public void testConstruct(){
        Integer integer = new Integer(12);
        System.out.println("通过整型数字传入" + integer);


        Integer integer1 = new Integer("563");
        System.out.println("通过字符串传入" + integer1);
    }

    public void testApi(){

        Integer integer = new Integer(-256);
        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(-126);
        Integer integer3 = new Integer(288);

        System.out.println("-256的值是：" + integer.toString());
        System.out.println("257的值是:" + Integer.parseInt("257"));
        System.out.println("21354121的值是:" + Integer.parseInt("AC5BE", 16));
        System.out.println("-21354的无符号数为：" + Integer.toUnsignedString(-21354, 2));
        System.out.println("333的16进制是" + Integer.toHexString(333));
        System.out.println("333的八进制是" + Integer.toOctalString(333));
        System.out.println("333的二进制是" + Integer.toBinaryString(333));

        System.out.println("235的解码值" + Integer.decode("235"));

    }

    public void testPool(){
        Integer integer = Integer.valueOf(123);
        Integer integer1 = Integer.valueOf(123);

        System.out.println(integer == integer1);
    }







    public static void main(String[] args) {
        IntegerTest integerTest = new IntegerTest();
        integerTest.testConstruct();
        integerTest.testApi();
        integerTest.testPool();
    }
}
