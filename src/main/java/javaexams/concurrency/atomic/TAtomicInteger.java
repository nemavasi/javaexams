package javaexams.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TAtomicInteger {
    public static void main(String[] args) throws Exception {

        AtomicInteger atomicInt = new AtomicInteger(0);
        AtomicInteger atomicInt2 = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(newValue -> {
                    Runnable task = () ->
                            atomicInt.accumulateAndGet(newValue, Integer::sum);     //IntBinaryOperator
                            atomicInt2.updateAndGet((oldValue) -> oldValue + newValue);            //IntUnaryOperator
                    executor.submit(task);
                });

        TimeUnit.SECONDS.sleep(3);  //ждем когда все потоки отработают - иначе можно получить результат промежуточный
        executor.shutdown();
        System.out.println(atomicInt.get());    // => 499500
        System.out.println(atomicInt2.get());    // => 499500
    }
}
