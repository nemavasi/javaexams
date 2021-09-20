package javaexams.collection;

import java.util.HashSet;
import java.util.Set;

public class SetContract {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(set);
        set.add("foo");
        System.out.println(set); // [(this Collection), foo]
        //The behavior of a set is not specified if the value of an object is changed in a manner that affects equals
        // comparisons while the object is an element in the set.
        //Java doc:  A special case of this prohibition is that it is not permissible for a set to contain itself as an element
    }
}
