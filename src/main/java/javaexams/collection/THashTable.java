package javaexams.collection;

import java.util.Hashtable;

public class THashTable {
    public static void main(String[] args) {
        Hashtable t = new Hashtable();
        t.put("1", "2");
        t.put("2", "3");
        System.out.println(t.contains("1"));     //false
        System.out.println(t.contains("3"));     //true
        System.out.println(t.containsKey("1"));  //true
    }
}
