package javaexams.streamapi;



import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TMapToLong {
    public static void main(String[] args) {
        LongSummaryStatistics d =
        IntStream
                 .rangeClosed(1,5)
                 .mapToLong(x->x)
                 .boxed()
                 .collect(Collectors.summarizingLong(x->x));
        System.out.println(d);

    }
}
