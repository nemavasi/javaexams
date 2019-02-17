package javaexams.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TCollect3 {
    public static void main(String[] args) {
        List<Integer> list = IntStream
                .range(0, 100)
                .boxed()
                .collect(
                        ArrayList::new,
                        (arr, x) -> arr.add(x),
                        (a, b) -> a.addAll(b)
                );
        System.out.println(list);
    }
}
