package javaexams.collection;

import java.util.Collection;
import java.util.Iterator;

public class CheckIsEmpty {

    static private Collection<Integer> collection = new Collection<>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return true;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int start = -2;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    start += 2;
                    return start;
                }
            };
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(Integer integer) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    };

    public static void main(String[] args) {
        collection.stream().limit(5).forEach(System.out::println);
        System.out.println(collection.isEmpty()); //USE IT TI CHECK EMPTY COLLECTIONS!!!
        System.out.println(collection.size()==0);

//        0
//        2
//        4
//        6
//        8
//        false
//        true
    }
}
