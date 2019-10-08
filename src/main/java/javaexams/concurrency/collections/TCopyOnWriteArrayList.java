package javaexams.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class TCopyOnWriteArrayList {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        IntStream.range(0, 1000)
                .forEach((x)->list.add(x));

        System.out.println(list);
    }
}
