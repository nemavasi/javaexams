package javaexams.collection;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("sdfasdf");

        arrayList.removeIf(x -> true);
        arrayList.removeIf(x -> true);

        System.out.println(arrayList);
    }
}
