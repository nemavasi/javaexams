package javaexams.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class TLinkedHashMap {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(10, 0.4f, true);

        map.put(27, "qqq");
        map.put(63, "www");
        map.put(63, "tttt");
        map.put(12, "zzz");

        //сначала сохраняется порядок вставки
        System.out.println(map);
        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
//        {27=qqq, 63=tttt, 12=zzz}
//        27
//        63
//        12

        //но так как accessOrder = true то далее сохраняется порядок использования
        //т.е. самые используемые будут в конце
        map.get(63);
        map.get(27);
        System.out.println(map);
        iter = map.keySet().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
//        {12=zzz, 63=tttt, 27=qqq}
//        12
//        63
//        27
    }
}
