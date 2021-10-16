package com.study.java8to11;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Lambda {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        BiFunction<Integer, Integer, Integer> plus = (a, b) -> a + b;

        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        // Java 8 이전
//        final int baseNumber = 10;
        // Java 8
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 11
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
