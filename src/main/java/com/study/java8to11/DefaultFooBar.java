package com.study.java8to11;

public class DefaultFooBar implements Foo, FooBar {

    String name;

    public DefaultFooBar(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printNameUpperCase() {
        System.out.println("FooBar");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
