package javaexams.streamapi;

import java.util.stream.IntStream;

public class TReduce1 {
    public static void main(String[] args) {
        IntStream
                .range(0, 100)
                .boxed()
                .reduce((x,y)->x>y?x:y)
                .ifPresent(System.out::println)
                //99
        ;


        System.out.println(
        IntStream
                .range(0, 100)
                .boxed()
                .reduce(442, (x,y)->x>y?x:y));

        //442
        ;
    }
}
