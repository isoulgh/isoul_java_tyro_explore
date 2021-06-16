package com.isoul.thread;

/**
 * @author isoul
 * @date 2021/6/16 14:56
 * @note Copyright (c) 2021 isoul. All rights reserved.
 */
public class MyThread implements Runnable{

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行，i = " + i);
        }
    }

    public static class RunnableDemo01 {
        public static void main(String[] args) {
            MyThread mt1 = new MyThread("线程A");
            MyThread mt2 = new MyThread("线程B");
            Thread t1 = new Thread(mt1);
            Thread t2 = new Thread(mt2);
            t1.start();
            t2.start();
        }
    }

}
