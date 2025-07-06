package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {

    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation subtraction = (a, b) -> a - b;

//        System.out.println("5 + 3 = " + addition.operation(5, 3));
//        System.out.println("5 * 3 = " + multiplication.operation(5, 3));
//        System.out.println("5 - 3 = " + subtraction.operation(5, 3));

//      Принимает Объект, возвращает boolean
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(0));
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("Hello"));

        Function<Integer,String> toStringFun = i -> "Число: " + i;
        System.out.println(toStringFun.apply(10));

        Consumer<String> printString = s -> System.out.println("Writing: " + s);
        printString.accept("Hello");

    }
}
