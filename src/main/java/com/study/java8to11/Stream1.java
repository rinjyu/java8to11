package com.study.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("rinjyu");
        names.add("rachel");
        names.add("injoo");
        names.add("java");

        // 스트림
        Stream stringStream = names.stream().map(String::toUpperCase);

        names.stream().map(s -> {
            System.out.println("++++++++++++++");
            System.out.println(s);
            return s.toUpperCase();
        });

        // 종료 오퍼레이션
        List<String> collect = names.stream().map((s) -> {
            System.out.println("----------------");
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("=================");

        names.forEach(System.out::println);

        // 병렬 처리
        List<String> parallelCollect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        parallelCollect.forEach(System.out::println);

        List<String> streamCollect = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        streamCollect.forEach(System.out::println);

    }
}
