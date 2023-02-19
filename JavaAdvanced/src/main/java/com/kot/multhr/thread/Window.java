package com.kot.multhr.thread;

import java.util.Random;

/**
 * @author yf
 * @create 2022-12-01 22:11
 */
public class Window implements Runnable{



    @Override
    public void run() {
        try {
            waitForQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (checkTicket()){
            try {
                doBussiness();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void waitForQueue() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(2000));
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "的排队时间为" + (end - start));
    }


    public boolean checkTicket(){
        return Bank.count > 0;
    }

    public void doBussiness() throws InterruptedException {
        System.out.println("到我了，我是" + Thread.currentThread().getName());
        Bank.ComeIn(new Random().nextInt(3));
        System.out.println("这次办完了");
        System.out.println("还有" + Bank.count + "张票");
        waitForQueue();
    }




}
