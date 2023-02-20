package com.kot.oop;

/**
 * @author yf
 * @create 2022-11-26 19:17
 */
public class Dog extends Animal{


    public Dog(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("dog");
    }

    public void bark(){
        System.out.println("bark");
        System.out.println(toString());
    }


}
