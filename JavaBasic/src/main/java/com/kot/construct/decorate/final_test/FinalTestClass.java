package com.kot.construct.decorate.final_test;

import java.util.ArrayList;

/**
 * @author yf
 * @create 2022-11-28 19:28
 */
public class FinalTestClass {

    //final用来修饰属性
    final boolean a = true;
    final byte b = 63;
    final Double c = 28.32;
    final int[] d = {};
    final ArrayList e  = new ArrayList();

    //final用来修饰构造函数,不可以


//    public final   FinalTestClass() {
//    }

    //final用来修饰方法
    public void test(){

        //可以改变所引用的内存中的值
        e.add(32);

        //不可以改变引用
//        e = new ArrayList();
        System.out.println("test........");
    }

    public final void testFinal(){
        System.out.println("testFinal..........");
    }

    //final用来修饰代码块,不可以
//    final  {
//
//    }

    class innerClass1{
        final int a = 1;

    }

    final class innerClass2 extends innerClass1{

    }



}
class B extends FinalTestClass{

    @Override
    public void test() {
        super.test();
    }

    //无法被重写
//    public void testFinal(){
//
//    }
}


