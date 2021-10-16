package com.study.java8to11;

import java.util.Arrays;
import java.util.List;

@Coke
public class CokeAnnotation {

    public static void main(@Coke String[] args) throws @Coke RuntimeException {

        List<@Coke String> names = Arrays.asList("Coke");
    }

    static class FeelsLikeCoke<@Coke T> {

        public static <@Coke C> void print(@Coke C c) {

        }
    }
}
