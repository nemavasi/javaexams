package javaexams.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapNullKeys {

    public static void main(String[] args) {
        Map<String, String > map = new HashMap<>();
        System.out.println(map.get(null));

        map = new LinkedHashMap<>();
        System.out.println(map.get(null));

        map = new ConcurrentHashMap<>();
        System.out.println(map.get(null)); //Exception in thread "main" java.lang.NullPointerException
    }
}
