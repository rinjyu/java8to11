package com.study.java8to11;

import java.util.function.*;

public class FunctionalInterface {

    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        plus10.compose(multiply2);
        plus10.andThen(multiply2);

        Function<Integer, Integer> composeFunction = plus10.compose(multiply2);
        System.out.println(composeFunction.apply(2));

        Function<Integer, Integer> andThenFunction = plus10.andThen(multiply2);
        System.out.println(andThenFunction.apply(2));

        Consumer<Integer> printT = (number) -> System.out.println(number);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> predicate = (s) -> s.startsWith("java");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        UnaryOperator<Integer> multiply3 = (i) -> i * 3;
    }
}
