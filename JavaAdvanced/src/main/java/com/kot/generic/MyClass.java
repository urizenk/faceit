package com.kot.generic;

/**
 * @author yf
 * @create 2022-11-28 22:09
 */
public class MyClass<T> {

    //在类上面声明的参数可以传入类的内部
    T a ;

    public T getA(){
        return a;
    }

    public static void main(String[] args) {
        MyClass<String> stringMyClass = new MyClass<>();
        System.out.println(stringMyClass.getA());
    }

}


/**
 * 多元泛型
 * @param <K>
 * @param <V>
 */
class MultiClass<K,V>{

}
