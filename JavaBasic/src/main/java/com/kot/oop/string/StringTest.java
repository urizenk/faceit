package com.kot.oop.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author yf
 * @create 2022-11-27 20:22
 */
public class StringTest {

    private String str1 = "abcdefg";
    private String str2 = "2345123132";

    /**
     * 测试String类的构造函数
     */
    public void testConstruct(){
        // 空参构造函数，返回为空字符串
        String s1 = new String();
        System.out.println("s1:"+s1);

        //传入一个字符串，可以给这个字符串换个hash值,idea会显示冗余
        String abc = new String("abc");

        //传入一个char的数组，显示这个数组
        char[] chars = {'a','b','c','d'};
        String s = new String(chars);
        System.out.println(s);

        //传入一个char的数组，以这个数组的偏移和容量截取
        char[] chars1 = {'1','2','3','4','5'};
        String s2 = new String(chars1, 1, 3);
        System.out.println(s2);

        //传入一个int数组，截取Unicode的值
        int[] unicodes = {97,98,99,100,101,102,103};
        String s3 = new String(unicodes, 2, 4);
        System.out.println(s3);


        //传入byte数组，截取出ascii码值
        byte[] asciis = {97,98,99,100,101};
        String s4 = new String(asciis, 23, 1, 4);
        System.out.println(s4);


        //传入一个byte数组，按照编码格式来解码
        byte[] bytes = {58,26,86,15,45,124,89,32};
        try {
            String s5 = new String(bytes, 0, 6, "unicode");
            System.out.println(s5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void testApi(){
        String s1 = "abc";
        String s2 = "123";
        String s3 = "asdfasdgfasdgfasfdasdfasdfafefs";
        String s4 = "";

        System.out.println("s1是否为空:" + s1.isEmpty());
        System.out.println("s4是否为空:" + s4.isEmpty());

        System.out.println("s3的长度：" + s3.length());

        System.out.println("s2的第二个字符是:" + s2.charAt(1));
        System.out.println("s1 的第三个字符的Unicode值是：" + s1.codePointAt(2));
        System.out.println("s1的第二个字符为: " +s1.codePointBefore(2));


//        char[] dest = {28};
//        s1.getChars(0,s1.length(),dest,1);
//        for (int i = 0; i < dest.length; i++) {
//            System.out.println("这个复制的第"+i+"个为:"+ dest[i]);
//        }

        for (byte aByte : s2.getBytes(StandardCharsets.UTF_8)) {
            System.out.println("s2的byte"+aByte);
        }

        try {
            for (byte aByte : s1.getBytes("utf-16")) {
                System.out.println(aByte);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < s3.getBytes().length; i++) {
            System.out.println("这是s1的第"+i+"个byte"+ s3.getBytes()[i]);
        }

        System.out.println("s1和s2相等吗？："+ s1.equals(s2));

        System.out.println("s1和s1相等吗？" +  s1.equals(s1));

        //字符串替换
        String ax = "axaxaxaxaxax";
        System.out.println( "ax中的x替换为a的结果" + ax.replace("x", "a"));


        //字符串连接
        String a = "abc";
        String b = "123";
        System.out.println("a连接b的结果为： " + a.concat(b));

        //判断字符串前缀
        String ads = "ads";
        System.out.println("ads以a为开头吗" + ads.startsWith("a"));

        //判断字符串后缀
        System.out.println("ads以s结尾吗" + ads.endsWith("s"));


        //分片
        String text = "你好啊，这个世界，你会忧伤吗";
        for (String s : text.split("，")) {
            System.out.println(s);
        }

    }

    public void testRegx(){
        String regx = "/^[1-9][0-9]{4,10}$/";
        String num = "14563431354684313124685135";
        System.out.println("num按照正则替换的结果 " + num.replaceAll(regx, "ok"));
    }

    /**
     * 测试String中的字符串常量池
     */
    public void testPool(){
        String str1 = "hello";
        String str2 = "hello";

        System.out.println("通过常量池引用的两个相等吗？" + (str1 == str2));

        String hello1 = new String("你好");
        String hello2 = new String("你好");

        System.out.println( "通过新建string对象的两个地址是否相等" +  (hello1 == hello2));
        System.out.println("通过新建对象的两个内容是否相等" +  (hello1.equals(hello2)));
    }







    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.testApi();

    }


}
