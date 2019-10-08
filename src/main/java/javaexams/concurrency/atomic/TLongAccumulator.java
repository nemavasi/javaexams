package javaexams.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class TLongAccumulator {
    public static void main(String[] args) throws Exception {

        //не гарантируется порядок вычислений
        //поэтому функцию надо подбирать чтобы результат не зависел от порядка вычислений
        LongBinaryOperator op = (x, y) -> (x * y);
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(1, 10)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        executor.shutdown();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(accumulator.getThenReset());

        //362880
    }
}
