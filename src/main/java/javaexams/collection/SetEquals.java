package javaexams.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEquals {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("foo");
        set1.add("boo");

        Set<String> set2 = new TreeSet<>();
        set2.add("foo");
        set2.add("boo");

        System.out.println(set1.equals(set2));  //true
    }
}
