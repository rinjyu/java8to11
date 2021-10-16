package com.study.java8to11;

public class ChickenAnnotation {

    public static void main(String[] args) {

    }

    static class FeelsLikeChicken<@Chicken T> {

        public static <@Chicken C> void print(C c) {

        }
    }
}
