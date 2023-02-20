package com.kot.oop;

/**
 * @author yf
 * @create 2022-11-26 19:14
 */
public class Animal {

    //封装，将一个animal的实现细节隐藏起来，外界只需要实例化一个对象就可以使用它提供的功能，不需要知道底层细节
    private String name;
    private String sex;
    private int age;

    public Animal(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("eat");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
