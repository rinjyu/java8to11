package com.study.java8to11;

public interface FooBar {

    default void printNameUpperCase() {
        System.out.println("FooBar");
    }
}
