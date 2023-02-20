package com.kot.construct;

/**
 * @author yf
 * @create 2022-11-25 15:24
 */
public class Construct {
    //属性 也是全局变量
    int a;
    int b;
    int c = 21;

    //java中的基本数据类型

    //布尔值，默认为false，1位
    boolean bool ;

    //字节，默认为？，8位
    byte aByte;

    //字符，默认为？，16位
    char aChar;

    //短整型， 默认为0，16位
    short aShort ;

    //整形，默认为0，32位
    int anInt;

    // 浮点数，默认为0.0，32位
    float aFloat;

    // 长整型，默认为0， 64位
    long aLong;

    // 双精度浮点型，默认为？,64位
    double aDouble;
    //构造函数

    /**
     * 带参数的构造函数，用于初始对象时控制属性的初始化赋值
     * @param a 局部变量
     * @param b 局部变量
     * @param c 局部变量
     */
    public Construct(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * 无参的构造函数，初始化对象时，属性都为默认值
     */
    public Construct() {
    }

    //方法
    public void printValue(){


        //局部变量
        String word  = "你好";

        System.out.println("a is :"+a);
        System.out.println("b is :"+b);
        System.out.println("c is :"+c);
        System.out.println(word);
    }

    public void testWhile(){


        while (true){
            String w = "kk";
        }
    }

    protected void testPro(){
        System.out.println(this.getClass());
    }

    //块
    {
        System.out.println("开始了");
    }

    //内部类 可以访问外部类
    class innerClass{
        int a;
        int b;
        int c=20;
        public innerClass() {
        }

        public innerClass(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public void printValue(){

        }


    }

    //打印基础类型的默认值
    public void printDefault(){
        System.out.println("布尔值的默认值："+ bool);
        System.out.println("字节的默认值：" + aByte);
        System.out.println("短型的默认值：" + aShort);
        System.out.println("整形的默认值: " + anInt);
        System.out.println("长整型的默认值:" + aLong);
        System.out.println("浮点型的默认值：" + aFloat);
        System.out.println("双精度的默认值：" + aDouble);
        System.out.println("字符型的默认值:  " +aChar);
    }

    //自动类型转换测试
    public void castValue(){
        byte a = 25;
        short b = a;
//        char c = a;  byte 不能转换为char
        char c = 0x21cf;
        int d  =  b;
        int e = c;
        long f  = 1225346512311541L;
        long h = e;
        float j = f;
        double  i = j;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(f);
        System.out.println(e);
        System.out.println(h);
        System.out.println(j);
        System.out.println(i);

    }

    private void testPr(){
        System.out.println("test");
    }

    public void forceCastValue(){
        long a = Long.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        byte b = 0x7f;
        System.out.println(b);
        System.out.println(c);
        testPr();
        castValue();
    }
    
    





    public static void main(String[] args) {
        Construct construct = new Construct();

        construct.testPro();
    }

}
