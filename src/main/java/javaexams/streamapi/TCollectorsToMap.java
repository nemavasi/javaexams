package javaexams.streamapi;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dshalygin on 2/18/19.
 */
public class TCollectorsToMap {
    public static void main(String[] args) {


        Set<Integer> set =
                IntStream
                        .of(0, 67, 88, 45, 34, 88, 44, 67)
                        .boxed()
                        .collect(Collectors.toSet());

        System.out.println(set);  //[0, 34, 67, 88, 44, 45]


    }
}
