package javaexams.streamapi;

import java.util.stream.IntStream;

/**
 * Created by dshalygin on 2/18/19.
 */
public class TMinMaxComparator {
    public static void main(String[] args) {

        int mid = 75;

        Integer i =
                IntStream
                        .of(0, 67, 88, 45, 34)
                        .boxed()
                        .min((o1, o2) -> Math.abs(o1 - mid) > Math.abs(o2 - mid) ? 1 : Math.abs(o1 - mid) < Math.abs(o2 - mid) ? -1 : 0)
                        .get();
        System.out.println(i);   //67

        i =
                IntStream
                        .of(0, 67, 88, 45, 34)
                        .boxed()
                        .max((o1, o2) -> Math.abs(o1 - mid) > Math.abs(o2 - mid) ? 1 : Math.abs(o1 - mid) < Math.abs(o2 - mid) ? -1 : 0)
                        .get();
        System.out.println(i);   //0
    }
}
