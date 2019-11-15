package javaexams.collection;

import java.util.*;

public class TSet {
    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9));

        System.out.println("start");
        System.out.println(a);
        System.out.println(b);

        System.out.println("union");
        Set<Integer> c = new TreeSet<>(a);
        System.out.println(c.addAll(b));
        System.out.println(c);

        System.out.println("intersection");
        Set<Integer> d = new TreeSet<>(a);
        System.out.println(d.retainAll(b));
        System.out.println(d);

        //reverse
        System.out.println("reverse list");
        List<Integer> list = new ArrayList<>(a);
        Collections.reverse(list);
        System.out.println(list);
    }
}
