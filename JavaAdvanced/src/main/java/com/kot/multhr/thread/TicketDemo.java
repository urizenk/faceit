package com.kot.multhr.thread;

/**
 * @author yf
 * @create 2022-12-01 22:09
 */
public class TicketDemo {
    public static void main(String[] args) {
        Window window = new Window();
        Thread a = new Thread(window, "A");
        Thread b = new Thread(window, "B");
        Thread c = new Thread(window, "C");
        a.start();
        b.start();
        c.start();

    }
}
