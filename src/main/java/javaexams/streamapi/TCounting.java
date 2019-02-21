package javaexams.streamapi;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TCounting {

    public static void main(String[] args) {
       Long cnt =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.counting());
        System.out.println(cnt);
        // 10


    }
}
