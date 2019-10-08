package javaexams.concurrency.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TConcurrentMap {
    public static void main(String[] args) {

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("**************************************");

        map.putIfAbsent("foo", "222");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("**************************************");

        System.out.println(map.getOrDefault("foo", "Ok"));
        System.out.println(map.getOrDefault("foo2", "Ok"));
        System.out.println("**************************************");

        map.replaceAll((k, v) -> "r2".equals(k) ? "hook" : v);     //отрабатывает для всех ключей
        map.compute("han", (k, v) -> v + v);                  //работает только для одного ключа
        map.compute("sdsdfsdf", (k, v) -> "newv");            //    если ключа нет добавляется новая запись
        map.computeIfAbsent("c3", (v) -> "zzz");
        map.computeIfPresent("foo", (k, v) -> "qqq");
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
