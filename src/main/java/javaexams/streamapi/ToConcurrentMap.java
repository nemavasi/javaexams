package javaexams.streamapi;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToConcurrentMap {
    public static void main(String[] args) {
        ConcurrentMap cm =
                IntStream.range(0, 10000)
                        .boxed()
                        .parallel()
                        .collect(Collectors.toConcurrentMap(Function.identity(), (x) -> x * x));
        System.out.println(cm);
        // {0=0, 8192=67108864, 1=1, 8193=67125249, 2=4, 8194=67141636, ...
    }
}
