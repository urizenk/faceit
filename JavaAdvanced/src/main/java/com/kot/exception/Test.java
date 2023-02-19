package com.kot.exception;

/**
 * @author yf
 * @create 2022-11-28 20:19
 */
public class Test {

    public void test() throws MyException{
        MyException myException = new MyException();
        throw myException;

    }



    public static void main(String[] args) {
        Throwable throwable = new Throwable();
        Exception exception = new Exception();
        Error error = new Error();
        RuntimeException runtimeException = new RuntimeException();

        Test test = new Test();
        try {

            System.out.println("开始监视");
            test.test();
            return;

        } catch (MyException e) {
            System.out.println("捕获异常");
            e.printStackTrace();
        } finally {
            System.out.println("必须要执行的");
            return;
        }

    }
}
