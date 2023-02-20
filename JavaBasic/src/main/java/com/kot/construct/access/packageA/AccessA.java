package com.kot.construct.access.packageA;

import com.kot.construct.file.B;
import com.kot.construct.file.Interface;

/**
 * @author yf
 * @create 2022-11-25 16:23
 */

public class AccessA {
    //对属性的访问权限的设置
    int a;
    public int b;
    private int c;
    protected int d;


    //对构造函数的访问权限的设置
    AccessA(int a) {
        this.a = a;

    }

    public AccessA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private AccessA(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    protected AccessA(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }


    //对方法的访问权限设置
     void a(){

     }

     public void b(){

     }

     private void c(){

     }

     protected void d(){

     }

     // 一个公共类的代码块不允许添加访问限制符
    {

    }



     class innerClass1{
         //对属性的访问权限的设置
         int a;
         public int b;
         private int c;
         protected int d;


         //对构造函数的访问权限的设置
         innerClass1(int a) {
             this.a = a;

         }

         public innerClass1(int a, int b) {
             this.a = a;
             this.b = b;
         }

         private innerClass1(int a, int b, int c) {
             this.a = a;
             this.b = b;
             this.c = c;
         }

         protected innerClass1(int a, int b, int c, int d) {
             this.a = a;
             this.b = b;
             this.c = c;
             this.d = d;
         }


         //对方法的访问权限设置
         void a(){

         }

         public void b(){

         }

         private void c(){

         }

         protected void d(){

         }

         // 一个公共类的代码块不允许添加访问限制符
         {

         }



         class innerClass11{

         }

         public class innerClass12{

         }

         private class innerClass13{

         }

         protected class innerClass14{

         }

     }

     public class innerClass2{
         //对属性的访问权限的设置
         int a;
         public int b;
         private int c;
         protected int d;


         //对构造函数的访问权限的设置
         innerClass2(int a) {
             this.a = a;

         }

         public innerClass2(int a, int b) {
             this.a = a;
             this.b = b;
         }

         private innerClass2(int a, int b, int c) {
             this.a = a;
             this.b = b;
             this.c = c;
         }

         protected innerClass2(int a, int b, int c, int d) {
             this.a = a;
             this.b = b;
             this.c = c;
             this.d = d;
         }


         //对方法的访问权限设置
         void a(){

         }

         public void b(){

         }

         private void c(){

         }

         protected void d(){

         }

         // 一个公共类的代码块不允许添加访问限制符
         {

         }



         class innerClass21{

         }

         public class innerClass22{

         }

         private class innerClass23{

         }

         protected class innerClass24{

         }

     }

     private class innerClass3{
         //对属性的访问权限的设置
         int a;
         public int b;
         private int c;
         protected int d;


         //对构造函数的访问权限的设置
         innerClass3(int a) {
             this.a = a;

         }

         public innerClass3(int a, int b) {
             this.a = a;
             this.b = b;
         }

         private innerClass3(int a, int b, int c) {
             this.a = a;
             this.b = b;
             this.c = c;
         }

         protected innerClass3(int a, int b, int c, int d) {
             this.a = a;
             this.b = b;
             this.c = c;
             this.d = d;
         }


         //对方法的访问权限设置
         void a(){

         }

         public void b(){

         }

         private void c(){

         }

         protected void d(){

         }

         // 一个公共类的代码块不允许添加访问限制符
         {

         }



         class innerClass31{

         }

         public class innerClass32{

         }

         private class innerClass33{

         }

         protected class innerClass34{

         }

     }

     protected class innerClass4{
         //对属性的访问权限的设置
         int a;
         public int b;
         private int c;
         protected int d;


         //对构造函数的访问权限的设置
         innerClass4(int a) {
             this.a = a;

         }

         public innerClass4(int a, int b) {
             this.a = a;
             this.b = b;
         }

         private innerClass4(int a, int b, int c) {
             this.a = a;
             this.b = b;
             this.c = c;
         }

         protected innerClass4(int a, int b, int c, int d) {
             this.a = a;
             this.b = b;
             this.c = c;
             this.d = d;
         }


         //对方法的访问权限设置
         void a(){

         }

         public void b(){

         }

         private void c(){

         }

         protected void d(){

         }

         // 一个公共类的代码块不允许添加访问限制符
         {

         }



         class innerClass41{

         }

         public class innerClass42{

         }

         private class innerClass43{

         }

         protected class innerClass44{

         }

     }

    public static void main(String[] args) {

        //在同一类中，所有的访问权限的内部类都可以访问到
        innerClass1 innerClass1 = new AccessA(1).new innerClass1(1);
        innerClass2 innerClass2 = new AccessA(1, 2).new innerClass2(1);
        innerClass3 innerClass3 = new AccessA(1, 2, 3).new innerClass3(1);
        innerClass4 innerClass4 = new AccessA(1, 2, 3, 4).new innerClass4(1);
    }

}
