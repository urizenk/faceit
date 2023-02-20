package com.kot.oop;

/**
 * @author yf
 * @create 2022-11-26 19:17
 */
public class Test {

    public static void main(String[] args) {

        //多态，同一个类的对象，可以有不同的行为特征
        Animal wufu = new Dog("wufu","male",3);
        Animal tom = new Cat("tom","male",2);
        wufu.eat();
        tom.eat();
//        Cat cat = new Cat("kimmy", "female", 1);
//        Dog dog = new Dog("rubby", "male", 2);
//        cat.sleep();
//        dog.bark();

    }
}
