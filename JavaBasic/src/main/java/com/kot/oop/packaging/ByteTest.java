package com.kot.oop.packaging;

/**
 * @author yf
 * @create 2022-11-28 1:04
 */
public class ByteTest {

    public void testConstruct(){

        System.out.println("----------开始测试构造函数--------------");

        byte b = 56;
        Byte aByte1 = new Byte(b);
        System.out.println("通过传入byte来构造 " + aByte1);

        Byte aByte = new Byte("25");
        System.out.println("通过一个字符串来构造 " + aByte);


    }

    public void testApi(){

        System.out.println("------------测试api--------------");
        Byte aByte = new Byte("48");
        Byte aByte1 = new Byte("56");

        byte b = 38;

        System.out.println("48的hashcode值是：" + aByte.hashCode());

        System.out.println("int值：" + aByte1.intValue());
        System.out.println("short值： " + aByte1.shortValue());
        System.out.println("10进制的值：" + aByte1.toString());

        //进制转换
        System.out.println( "124的16进制是： " +  Byte.parseByte("124", 8));


        System.out.println("将38转为无符号整形:" + Byte.toUnsignedInt(b));
    }



    public static void main(String[] args) {

        ByteTest byteTest = new ByteTest();
        byteTest.testConstruct();
        byteTest.testApi();

    }
}
