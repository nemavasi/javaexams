package javaexams.streamapi;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TFlatMap {
    public static void main(String[] args) {
        Stream.Builder<Stream<Stream<String>>> builder = Stream.builder();
        builder
                .add(Stream.of(Stream.of("a", "b")))
                .add(Stream.of(Stream.of("c", "d")))
                .add(Stream.of(Stream.of("e", "f")));


        Stream<Stream<Stream<String>>> stream = builder.build();

        System.out.println(
                stream
                        .skip(1)
                        .flatMap(Function.identity())
                        .flatMap(Function.identity())
                        .collect(Collectors.joining("-")));
        //c-d-e-f
    }
}
