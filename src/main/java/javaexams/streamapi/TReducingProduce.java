package javaexams.streamapi;

import java.util.stream.IntStream;

public class TReducingProduce {
    public static void main(String[] args) {
        Integer n =
            IntStream.range(1, 5)
                .peek( x-> System.out.println(x))
                .boxed().reduce(1, (x, y) -> x * y);
        System.out.println(n);


    }
}
