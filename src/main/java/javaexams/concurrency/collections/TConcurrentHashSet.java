package javaexams.concurrency.collections;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TConcurrentHashSet {

    public static void main(String[] args)  throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();

        Set<String> set = Collections.newSetFromMap(map); //!!!!!!

        IntStream.range(0, 1000)
                .forEach(x->es.submit(()-> set.add(Integer.valueOf(x).toString().substring(0,2) + Thread.currentThread().getName()))); //
        TimeUnit.SECONDS.sleep(5);
        System.out.println(set);
        es.shutdown();
    }
}
