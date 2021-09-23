package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEquals {

    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> newList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> newOrderList = new ArrayList<>(Arrays.asList(2, 1, 3));

        System.out.println(baseList.equals(newList));          //true
        System.out.println(baseList.equals(newOrderList));     //false
    }
}
