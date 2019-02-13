package javaexams.streamapi;

import java.util.stream.IntStream;

/**
 * Created by dshalygin on 2/13/19.
 */
public class TConcatStream {
    public static void main(String[] args) {

        IntStream is1 =  IntStream.iterate(2, (x)-> x+1).filter((x)->x%7==0);
        IntStream is2 =  IntStream.iterate(2, (x)-> x+1).filter((x)->x%17==0);

        IntStream.concat(is1.limit(10), is2.limit(10)).forEach(System.out::println);

    }
}
