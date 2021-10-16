package com.study.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuture2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future1 = hello.thenCompose(CompletableFuture2::getWorld);
        System.out.println(future1.get());

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World" + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future2 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future2.get());

        CompletableFuture<Void> future3 = CompletableFuture.allOf(hello, world)
                .thenAccept(System.out::println);
        System.out.println(future3.get());  //결과 : null

        List<CompletableFuture<String>> future4 = Arrays.asList(hello, world);
        CompletableFuture[] futures = future4.toArray(new CompletableFuture[future4.size()]);
        CompletableFuture<List<String>> future5 = CompletableFuture.allOf(futures)
                .thenApply(v -> {
                   return future4.stream()
                           .map(CompletableFuture::join)
                           .collect(Collectors.toList());
                });
        future5.get().forEach(System.out::println);

        CompletableFuture<Void> future6 = CompletableFuture.anyOf(hello, world)
                .thenAccept(System.out::println);
        future6.get();

        boolean throwError = true;
        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> {
           if (throwError) {
                throw new IllegalArgumentException();
           }
            System.out.println("Hello " + Thread.currentThread().getName());
           return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error";
        });

        System.out.println(future7.get());

        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "Error";
            }
            return result;
        });

        System.out.println(future8.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World" + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
