package javaexams.collection;

import java.util.ArrayList;
import java.util.List;

public class VeryBigCollection {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>(Integer.MAX_VALUE);
        for (int i = 0; i< Integer.MAX_VALUE ;i++) {
            list.add((byte) 42);
        }
        System.out.println(list.size());
        list.add((byte) 42);
        System.out.println(list.size());  //If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.

    }
}
