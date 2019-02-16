package javaexams.streamapi;

import java.util.stream.IntStream;

public class TForEachOrdered {
    public static void main(String[] args) {
        IntStream.range(0, 1000000)
                .parallel()
                .filter(x->x%17==0)
                .forEach(System.out::println);

        //625005
        //125001
        //...

        IntStream.range(0, 1000000)
                .parallel()
                .filter(x->x%17==0)
                .forEachOrdered(System.out::println);

        //0
        //17
        //34
        //...
    }
}
