package javaexams.collection;

import java.time.Instant;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public class RandomAccessAffects {

    private static final int SEARCH_NUMBER = 400_000_000;

    static class Elem {

        private final Integer age;

        Elem(Integer age) {
            this.age = age;
        }

        int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return age.toString();
        }
    }

    static class ListNotRandomAccess extends AbstractList<Elem> {

        private static final int LIMIT = 1_000_000_000;


        @Override
        public Elem get(int i) {
            if (i > LIMIT || i < -LIMIT) {
                throw new IndexOutOfBoundsException("wrong index " + i);
            }
            return new Elem(i * 2);
        }

        @Override
        public int size() {
            return 2 * LIMIT + 1;
        }
    }

    static class ListRandomAccess extends ListNotRandomAccess implements RandomAccess {   ///!!!!!

    }

    public static void main(String[] args) {
        List<Elem> list = new ListNotRandomAccess();
        long startTime = Instant.now().getEpochSecond();
        int index = Collections.binarySearch(list, new Elem(SEARCH_NUMBER), Comparator.comparing(Elem::getAge));
        long endTime = Instant.now().getEpochSecond();
        System.out.println(index);
        System.out.println("time in sec : " + (endTime - startTime));

//        200000000
//        time in sec : 7

        list = new ListRandomAccess();
        startTime = Instant.now().getEpochSecond();
        index = Collections.binarySearch(list, new Elem(SEARCH_NUMBER), Comparator.comparing(Elem::getAge));
        endTime = Instant.now().getEpochSecond();
        System.out.println(index);
        System.out.println("time in sec : " + (endTime - startTime));

//        200000000
//        time in sec : 0

        // Marker interface used by List implementations to indicate that they support fast (generally constant time) random access.
        // The primary purpose of this interface is to allow generic algorithms to alter their behavior to provide good performance
        // when applied to either random or sequential access lists.
    }
}
