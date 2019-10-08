package javaexams.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class TLongAdder {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);

        //вместо того, чтобы складывать числа сразу, он просто хранит у себя набор слагаемых, чтобы уменьшить взаимодействие между потоками.
        LongAdder longAdder = new LongAdder();

        IntStream.range(0, 1000)
                .forEach(x->{
                    es.submit(()->longAdder.add(x));
                });
        es.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(longAdder.sumThenReset());  //499500
        System.out.println(longAdder.sum());           //0

    }
}
