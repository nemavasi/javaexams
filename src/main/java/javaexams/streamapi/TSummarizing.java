package javaexams.streamapi;

import javaexams.BaseCheck;

import java.util.IntSummaryStatistics;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TSummarizing extends BaseCheck {
    public static void main(String[] args) {
        new TSummarizing().go();
    }

    @Override
    public void go() {

        IntSummaryStatistics st =
                IntStream.of(0, 6, 7)
                        .mapToObj(x -> x)
                        .collect(Collectors.summarizingInt(x->x));
        p(st);

    }
}
