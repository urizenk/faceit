package com.kot.oop;

/**
 * @author yf
 * @create 2022-11-26 19:16
 */

//继承，虽然没有在文件中定义其他的属性和方法，但是能直接在类中使用
public class Cat extends Animal{

    public Cat(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("cat");
    }

    public void sleep(){
        System.out.println("sleep");
        System.out.println(toString());
    }


}
