package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ListIndexOperation {

    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        baseList.addAll(5, Arrays.asList(13, 14));
        System.out.println(baseList);   // [1, 2, 3, 4, 5, 13, 14, 6, 7, 8, 9]
        baseList.set(6, 42);
        System.out.println(baseList);   // [1, 2, 3, 4, 5, 13, 42, 6, 7, 8, 9]
        baseList.sort(Comparator.comparing(Function.identity()));
        System.out.println(baseList);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 42]
        System.out.println(baseList.get(baseList.size() - 1));  //42
        baseList.add(baseList.size() - 1, 13);
        System.out.println(baseList);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 13, 42]
        System.out.println(baseList.remove(9)); //13                                   !!!!
        System.out.println(baseList);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 42]            !!!!
        System.out.println(baseList.remove((Integer) 9));  //true                        !!!!
        System.out.println(baseList);  // [1, 2, 3, 4, 5, 6, 7, 8, 13, 42]               !!!!
        baseList.add(baseList.size(), 13);
        System.out.println(baseList); //[1, 2, 3, 4, 5, 6, 7, 8, 13, 42, 13]
        System.out.println(baseList.indexOf(13));               // 8
        System.out.println(baseList.lastIndexOf(13));        // 10
    }
}
