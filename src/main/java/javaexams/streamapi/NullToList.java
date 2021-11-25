package javaexams.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NullToList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "ghjgh",
            null,
            "asdasdsd"

        ).stream()
            .collect(Collectors.toList());

        System.out.println(list); //[ghjgh, null, asdasdsd]

    }
}
