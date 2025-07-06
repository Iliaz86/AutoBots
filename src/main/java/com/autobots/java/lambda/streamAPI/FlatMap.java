package com.autobots.java.lambda.streamAPI;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E")
        );

        System.out.println(nestedList);

        List<String> NonNestedList = new ArrayList<>();
        for (List<String> list : nestedList) {
            NonNestedList.addAll(list);
        }
        System.out.println(NonNestedList);

        List<String> flatMapList = nestedList.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println(flatMapList);
    }
}
