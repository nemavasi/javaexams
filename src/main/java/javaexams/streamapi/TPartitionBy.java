package javaexams.streamapi;



import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TPartitionBy {
    public static void main(String[] args) {
        Map<Boolean, Set<Integer>> map =
        IntStream
                .range(0, 10)
                .boxed()
                .collect(Collectors.partitioningBy((x)->x%2==0, Collectors.toSet()));
        System.out.println(map);
        // {false=[1, 3, 5, 7, 9], true=[0, 2, 4, 6, 8]}

        Map<Boolean, List<Integer>> map2 =
                IntStream
                        .range(0, 10)
                        .boxed()
                        .collect(Collectors.partitioningBy((x)->x%2==0));  //по дефолту в List
        System.out.println(map2);
        // {false=[1, 3, 5, 7, 9], true=[0, 2, 4, 6, 8]}
    }
}
