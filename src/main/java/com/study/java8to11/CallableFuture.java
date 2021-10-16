package com.study.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());

        System.out.println("Start");

        try {
            helloFuture.get();   //블로킹 콜
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());
        System.out.println("End");

        Callable<String> java1 = () -> {
            Thread.sleep(2000L);
            return "Java1";
        };

        Callable<String> java2 = () -> {
            Thread.sleep(3000L);
            return "Java2";
        };

        Callable<String> java3 = () -> {
            Thread.sleep(1000L);
            return "Java3";
        };

        List<Future<String>> futures = null;
        try {
            futures = executorService.invokeAll(Arrays.asList(java1, java2, java3));
            for (Future<String> f: futures) {
                System.out.println(f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String s = null;
        try {
            s = executorService.invokeAny(Arrays.asList(java1, java2, java3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);

        executorService.shutdown();
    }
}
