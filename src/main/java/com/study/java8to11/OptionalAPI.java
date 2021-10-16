package com.study.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalAPI {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        // isPresent()
        boolean present = spring.isPresent();
        System.out.println(present);

        // isEmpty()
        boolean isEmpty = spring.isEmpty();
        System.out.println(isEmpty);

        // get()
        OnlineClass springClass = spring.get();
        System.out.println(springClass.getTitle());

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        if (jpa.isPresent()) {
            OnlineClass jpaClass = jpa.get();
            System.out.println(jpaClass.getTitle());
        }

        // ifPresent(Consumer)
        jpa.ifPresent(o -> System.out.println(o.getTitle()));

        // orElse(T)
        OnlineClass onlineClass = jpa.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        // orElseGet(Supplier)
        OnlineClass getOnlineClass = jpa.orElseGet(OptionalAPI::createNewClass);
        System.out.println(getOnlineClass.getTitle());

        // orElseThrow()
        OnlineClass throwOnlineClass = jpa.orElseThrow();
        System.out.println(throwOnlineClass.getTitle());

        OnlineClass customThrowOnlineClass = jpa.orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        System.out.println(customThrowOnlineClass.getTitle());

        OnlineClass lambdaThrowOnlineClass = jpa.orElseThrow((IllegalStateException::new));
        System.out.println(lambdaThrowOnlineClass.getTitle());

        // filter(Predicate)
        Optional<OnlineClass> classFilter1 = jpa.filter(o -> !o.isClosed());
        System.out.println(classFilter1.isEmpty());

        Optional<OnlineClass> classFilter2 = jpa.filter(OnlineClass::isClosed);
        System.out.println(classFilter2.isPresent());

        // map(Function)
        Optional<Integer> integer = jpa.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Optional<Progress>> progress = jpa.map(OnlineClass::getProgress);
        Optional<Progress> optionalProgress = progress.orElse(Optional.empty());
        Progress getProgress = optionalProgress.orElseThrow();

        // flatMap(Function)
        Optional<Progress> flatMap = jpa.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
