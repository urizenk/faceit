package com.kot.oop.string;

/**
 * @author yf
 * @create 2022-11-28 15:58
 */
public class StringBufferTest {

    public void testConstruct(){

        //默认传入的空字符串定义16的容量
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("stringbuffer的长度为" + stringBuffer.capacity());

        //自定义传入的字符串的容量值
        StringBuffer stringBuffer1 = new StringBuffer(20);
        System.out.println("自定义的长度为"+stringBuffer1.capacity());
    }

    public void testApi(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("c");

        System.out.println(stringBuffer);

        stringBuffer.delete(0,1);
        System.out.println(stringBuffer);

        stringBuffer.append("123466");
        stringBuffer.deleteCharAt(5);
        System.out.println(stringBuffer);

        stringBuffer.replace(3,7, "aax");
        System.out.println(stringBuffer);

    }



    public static void main(String[] args) {

        StringBufferTest stringBufferTest = new StringBufferTest();
        stringBufferTest.testConstruct();
        stringBufferTest.testApi();
    }
}
