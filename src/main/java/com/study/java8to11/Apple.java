package com.study.java8to11;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(value = AppleContainer.class)
public @interface Apple {

    String value();
}
