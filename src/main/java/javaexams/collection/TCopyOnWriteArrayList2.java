package javaexams.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dshalygin on 2/12/19.
 */
public class TCopyOnWriteArrayList2 {
    private static void removeAndPrint(List<String> list) {

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("three")) {
                iterator.remove();      //java.lang.UnsupportedOperationException
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

        //java.lang.UnsupportedOperationException

    }
}
