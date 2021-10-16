package com.study.java8to11;

public class Concurrent {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());

        Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("Thread : " + Thread.currentThread().getName());
           }
        });
        thread.start();

        Thread lambdaThread = new Thread(() -> System.out.println("Thread : " + Thread.currentThread().getName()));
        lambdaThread.start();

        Thread sleepThread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread : " + Thread.currentThread().getName());
        });
        sleepThread.start();

        Thread interruptThread = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit");
                    return;
                }
            }
        });
        interruptThread.start();

        System.out.println("Thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThread.interrupt();

        Thread joinThread = new Thread(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        joinThread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(joinThread + "is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
