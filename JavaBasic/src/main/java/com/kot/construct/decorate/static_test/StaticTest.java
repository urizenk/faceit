package com.kot.construct.decorate.static_test;

/**
 * @author yf
 * @create 2022-11-28 18:20
 */
public class StaticTest {

    //对于属性的修饰
    int a = 0;

    static int b = 1;

    //构造函数不能被这个关键字修饰

//    public static StaticTest(int a) {
//
//    }


    //修饰在方法上
    public void test(){
        System.out.println("我是实例方法");
    }

    public static void testStatic(){
        System.out.println("我是类方法");

    }

    //对于代码块的修饰
    {
        System.out.println("对象的实例化.........");
    }

    static {
        System.out.println("类加载过程中...........");
    }


    //对于内部类的修饰
    class innerClass1{

    }

    static class innerClass2{
        static int c = 2;

        public static void ok(){
            System.out.println("ok");
        }


    }


    public static void main(String[] args) {
        StaticTest s1 = new StaticTest();
        StaticTest s2 = new StaticTest();
        s1.a = StaticTest.b;
        StaticTest.b = 45;
        s2.a = StaticTest.b;
        System.out.println(s1.a);
        System.out.println(s2.a);
        StaticTest.testStatic();
        System.out.println(innerClass2.c);
        s1.test();

        innerClass1 innerClass1 = new StaticTest().new innerClass1();
    }


}

class B{

}
