package com.study.java8to11;

public class StaticMethod {

    public static void main(String[] args) {

        Foo foo = new DefaultFoo("rinjyu");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
