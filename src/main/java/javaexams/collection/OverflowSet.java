package javaexams.collection;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class OverflowSet {

    private static Set<Integer> rangeSet(int inclusiveStart, int exclusiveEnd) {
        return new AbstractSet<>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {

                    int current = inclusiveStart;

                    @Override
                    public boolean hasNext() {
                        return current != exclusiveEnd;
                    }

                    @Override
                    public Integer next() {
                        return current++;
                    }
                };
            }

            @Override
            public int size() {
                return exclusiveEnd - inclusiveStart;
            }
        };
    }

    public static void main(String[] args) {
        Set<Integer> set = rangeSet(0, 5);
        System.out.println(set); //[0, 1, 2, 3, 4]

        set = rangeSet(Integer.MIN_VALUE + 10, Integer.MAX_VALUE - 10);
        System.out.println(set.size());  //-21 !!!!

        System.out.println(rangeSet(0, Integer.MAX_VALUE).contains(-1)); // false slow!!!

        set = rangeSet(5, 0);
        System.out.println(set.size());  //-5
        System.out.println(set); //java.lang.OutOfMemoryError: Java heap space because bad "contains" method

        // 1) check inclusiveStart < exclusiveEnd
        // 2) size is integer without overflow
    }
}
