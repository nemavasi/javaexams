package javaexams.streamapi;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TSkip {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        builder
                .add("a").add("b").add("c");

     Stream<String> stream = builder.build();

        System.out.println(
                stream
                        .skip(1)
                        .collect(Collectors.joining("-")));
        //b-c
    }
}
