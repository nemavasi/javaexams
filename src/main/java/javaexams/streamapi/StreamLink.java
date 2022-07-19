package javaexams.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamLink {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Stream<String> stringStream = list.stream();
        list.add("d");

        stringStream.forEach(System.out::println);
    }

}

//    a
//    b
//    c
//    d