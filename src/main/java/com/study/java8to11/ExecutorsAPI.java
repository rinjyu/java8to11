package com.study.java8to11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsAPI {

    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService1.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(getRunnable("Hello"));
        executorService2.submit(getRunnable("Rinjyu"));
        executorService2.submit(getRunnable("The"));
        executorService2.submit(getRunnable("Java"));
        executorService2.submit(getRunnable("Thread"));
        executorService2.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService2.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
