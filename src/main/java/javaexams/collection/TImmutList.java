package javaexams.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dshalygin on 2/12/19.
 */
public class TImmutList {
    public static void main(String[] args) {
        String[] str = new String[] { "1", "2", "3" };

        List list = Arrays.asList(str);                                      //immutable list
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Object object = (Object) iterator.next();
            iterator.remove();                                                //java.lang.UnsupportedOperationException
        }
        System.out.println(list.size());
    }

}
