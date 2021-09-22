package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubListTst {

    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> subList = baseList.subList(2, 5);
        System.out.println(subList);                            // [3, 4, 5]
        subList.add(42);                                        // [3, 4, 5, 42]
        System.out.println(subList);
    }
}
