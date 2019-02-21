package javaexams.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TMapping {
    public static void main(String[] args) {
        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .map((x) -> x * 10).collect(Collectors.toList());
                        //эквивалентно .collect(Collectors.mapping((x)-> x*10, Collectors.toList()));

        System.out.println(list);
        // 10
    }
}
