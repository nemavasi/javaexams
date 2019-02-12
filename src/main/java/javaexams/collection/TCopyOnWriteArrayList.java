package javaexams.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dshalygin on 2/12/19.
 */
public class TCopyOnWriteArrayList {
    private static void removeAndPrint(List<String> list) {
        for (String str : list) {
            if (str.equals("two")) {
                list.remove("three");
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>();

        list.add("one");  //методы add и remove у CopyOnWriteArrayList синхронизованы
        list.add("two");
        list.add("three");
        list.add("four");

        removeAndPrint(list);

        //[one, two, four]

    }
}
