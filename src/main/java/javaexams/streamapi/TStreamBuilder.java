package javaexams.streamapi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TStreamBuilder {
    public static void main(String[] args) {

        Stream.Builder<String> builder = Stream.<String>builder();

        builder.add("a").add("b");

        builder.accept("c");
        builder.accept("d");

        System.out.println(builder.build().collect(Collectors.joining("-")));
        //a-b-c-d
        //builder.accept("e");     java.lang.IllegalStateException
    }
}
