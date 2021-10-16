package com.study.java8to11;

import java.util.concurrent.*;

public class CompletableFuture1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "hello");
        future.get();

        CompletableFuture<String> future1 = new CompletableFuture<>();
        future1.complete("rinjyu");
        System.out.println(future1.get());

        CompletableFuture<String> future2 = CompletableFuture.completedFuture("rinjyu");
        System.out.println(future2.get());

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future3.get();

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future4.get());

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future5.get());

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        System.out.println(future6.get());

        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(future7.get());

        CompletableFuture<Void> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(future8.get());

        CompletableFuture<Void> future9 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);
        System.out.println(future9.get());

        executorService.shutdown();
    }
}
