package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTst {

    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator<Integer> listIterator = baseList.listIterator();
        System.out.println(listIterator.hasNext());       // true
        System.out.println(listIterator.hasPrevious());   // false
        while (listIterator.hasNext()){
            listIterator.next();
        }
        System.out.println(listIterator.hasNext());       // false
        System.out.println(listIterator.hasPrevious());   // true
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
//        5
//        4
//        3
//        2
//        1

        ListIterator<Integer> listIteratorCenter = baseList.listIterator(2);
        System.out.println(listIteratorCenter.hasNext());       // true
        System.out.println(listIteratorCenter.hasPrevious());   // true
        while (listIteratorCenter.hasNext()){
            System.out.println(listIteratorCenter.next());
        }
//        3
//        4
//        5
    }
}
