package javaexams.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class TConcurrentHashMap {
    public static void main(String[] args) {

        System.out.println(ForkJoinPool.commonPool().getParallelism());

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n",
                        key, value, Thread.currentThread().getName()));


        String result = map.search(1, (k, v) -> "r2".equals(k) ? v : null);
        System.out.println("search1 :: " + result);

        result = map.search(1, (k, v) -> k.length() > 2 ? v : null);
        System.out.println("search2 :: " + result);

        result = map.reduce(1,
                (k, v) -> k + "=" + v,
                (x, y) -> x + ";" + y
        );
        System.out.println(result);
    }
}
