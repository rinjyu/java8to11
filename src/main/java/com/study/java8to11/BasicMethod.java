package com.study.java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class BasicMethod {

    public static void main(String[] args) {

        Foo foo = new DefaultFoo("rinjyu");
        foo.printName();
        foo.printNameUpperCase();

        List<String> names = new ArrayList<>();
        names.add("rinjyu");
        names.add("rachel");
        names.add("injoo");
        names.add("java");
        names.add("spring");

        /**
         * Iterable의 기본 메소드
         */
        // forEach() 메소드
        names.forEach(System.out::println);

        // spliterator 메소드
        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("==============================");
        while (spliterator2.tryAdvance(System.out::println));

        /**
         * Collection의 기본 메소드
         */
        // stream() 메소드
        long count = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("r"))
                .count();
        System.out.println(count);

        names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("r"))
                .collect(Collectors.toSet());

        // removeIf() 메소드드
        names.removeIf(s -> s.startsWith("r"));
        names.forEach(System.out::println);

        /**
         * Comparator의 기본 메소드
         */
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase);
        names.sort(compareToIgnoreCase.reversed());

        names.forEach(System.out::println);

    }
}
