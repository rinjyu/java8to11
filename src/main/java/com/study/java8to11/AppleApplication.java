package com.study.java8to11;

import java.util.Arrays;

@Apple("아오리사과")
@Apple("홍옥사과")
public class AppleApplication {

    public static void main(String[] args) {

        Apple[] apples = AppleApplication.class.getAnnotationsByType(Apple.class);
        Arrays.stream(apples).forEach(c -> {
            System.out.println(c.value());
        });

        AppleContainer appleContainer = AppleApplication.class.getAnnotation(AppleContainer.class);
        Arrays.stream(appleContainer.value()).forEach(c ->  {
            System.out.println(c.value());
        });

    }
}
