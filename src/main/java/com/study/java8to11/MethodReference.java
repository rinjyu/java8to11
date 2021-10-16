package com.study.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {

    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        // static 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("Java"));

        // 특정 객체의 인스턴스 메소드 참조
        UnaryOperator<String> hi1 = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi;

        // 입력값을 받지 않는 생성자
        Supplier<Greeting> newGreeting1 = Greeting::new;
        Greeting getNewGreeting1 = newGreeting1.get();

        // 입력값을 받는 생성자
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting getNewGreeting2 = newGreeting2.apply("Java");
        System.out.println(getNewGreeting2.getName());

        String[] names = {"rinjyu", "rachel", "injoo"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);

    }
}

