package javaexams.streamapi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ToArray {
    public static void main(String[] args) {
        Object[] arr = IntStream
                .range(0, 10)
                .boxed()
                .toArray();
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = IntStream
                .range(0, 10)
                .boxed()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
