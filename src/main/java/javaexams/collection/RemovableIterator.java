package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class RemovableIterator {

    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator<Integer> listIterator = baseList.listIterator(2);
        System.out.println(listIterator.nextIndex());   // 2
        //listIterator.remove();                        // thread "main" java.lang.IllegalStateException
        listIterator.next();
        listIterator.remove();
        System.out.println(baseList);                  // [1, 2, 4, 5]
    }
}
