package com.kot.oop.packaging;

/**
 * @author yf
 * @create 2022-11-28 0:52
 */
public class BooleanTest {

    public void testConstruct(){

        System.out.println("---------------测试Boolean的构造函数------------");


        //通过布尔值传入
        Boolean aBoolean = new Boolean(true);
        System.out.println(aBoolean);

        //通过字符串传入
        Boolean aTrue = new Boolean("true");
        System.out.println(aTrue);


    }

    public void testApi(){

        System.out.println("---------------测试Boolean的api--------------");

        Boolean trues = true;
        Boolean falses = false;

        System.out.println( "这个是啥:" +  trues.toString());

        System.out.println("相等吗？" + falses.compareTo(trues));

        System.out.println( "hashcode值是？" + trues.hashCode());

        System.out.println("true的hashcode是?" + Boolean.hashCode(true));

        System.out.println( "逻辑与的结果是 " + Boolean.logicalAnd(trues, falses));

        System.out.println("逻辑或的结果是 " + Boolean.logicalOr(trues, falses));

        System.out.println("逻辑异或的结果是 " + Boolean.logicalXor(trues, falses));
    }




    public static void main(String[] args) {
        BooleanTest booleanTest = new BooleanTest();
        booleanTest.testConstruct();
        booleanTest.testApi();

    }
}
