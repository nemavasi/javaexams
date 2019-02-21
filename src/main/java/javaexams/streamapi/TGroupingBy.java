package javaexams.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TGroupingBy {
    public static void main(String[] args) {

        // 1
        Map<Integer, List<Integer>> map =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.groupingBy((x) -> x % 3));
        System.out.println(map);
        // {0=[0, 3, 6, 9], 1=[1, 4, 7], 2=[2, 5, 8]}

        // 2
        Map<Integer, Set<Integer>> map2 =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.groupingBy((x) -> x % 3, HashMap::new, Collectors.toSet()));
        System.out.println(map2);
        // {0=[0, 3, 6, 9], 1=[1, 4, 7], 2=[2, 5, 8]}

        // 3
        Map<Integer, Set<Integer>> map3 =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.groupingBy((x) -> x % 3, Collectors.toSet()));
        System.out.println(map3);
        System.out.println(map3.getClass());
        // {0=[0, 3, 6, 9], 1=[1, 4, 7], 2=[2, 5, 8]}
        // class java.util.HashMap

        Map<Integer, Set<Integer>> map4 =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.groupingByConcurrent((x) -> x % 3, Collectors.toSet()));
        System.out.println(map4);
        System.out.println(map4.getClass());
        // {0=[0, 3, 6, 9], 1=[1, 4, 7], 2=[2, 5, 8]}
        // class java.util.concurrent.ConcurrentHashMap

    }
}
