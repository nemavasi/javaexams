package javaexams.streamapi;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TCollectingAndThen {
    public static void main(String[] args) {
        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(list.getClass());
        //class java.util.Collections$UnmodifiableRandomAccessList
        //list.add(42); // java.lang.UnsupportedOperationException

    }
}
