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
        listIterator.remove();                         // "main" java.lang.IllegalStateException

//        An iterator for a list of length n has n+1 possible cursor positions (between elements)
//        Note that the remove() and set(Object) methods are not defined in terms of the cursor position;
//        they are defined to operate on the last element returned by a call to next() or previous().

//        This method can be called only once per call to next()
    }
}
