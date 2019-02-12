package javaexams.collection;

import java.util.HashMap;

public class THashMap {
    public static void main(String[] args) {
        HashMap t = new HashMap();
        t.put("1", "2");
        t.put("2", "3");
        System.out.println(t.containsValue("1"));     //false
        System.out.println(t.containsValue("3"));     //true
        System.out.println(t.containsKey("1"));       //true
    }
}
