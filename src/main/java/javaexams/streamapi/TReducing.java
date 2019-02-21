package javaexams.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TReducing {
    public static void main(String[] args) {
        Integer n =
                IntStream.range(0, 10)
                        .boxed()
                        //эквивалентно .reduce(0, (x, y) -> x > y ? x : y);
                        .collect(Collectors.reducing(0, (x, y)-> x>y?x:y));

        System.out.println(n);
        // 9
    }
}
