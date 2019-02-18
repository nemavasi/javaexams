package javaexams.streamapi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dshalygin on 2/18/19.
 */
public class TCollectorsToSet {
    public static void main(String[] args) {

        //2
        Map<Integer, String> map2 =
                IntStream
                        .of(0, 67, 88, 45, 34, 44)
                        .boxed()
                        .collect(Collectors.toMap(Function.identity(), String::valueOf));
        System.out.println(map2);
        //{0=0, 34=34, 67=67, 88=88, 44=44, 45=45}
        System.out.println(map2.getClass());
        //class java.util.HashMap

        //3
        Map<Integer, String> map3 =
                IntStream
                        .of(0, 67, 88, 45, 34, 88, 44, 67)
                        .boxed()
                        //.collect(Collectors.toMap(Function.identity(), String::valueOf)); //java.lang.IllegalStateException: Duplicate key 88
                        .collect(Collectors.toMap(Function.identity(), String::valueOf, (x, y) -> x.length() > y.length() ? y + x : x + y));
        System.out.println(map3);
        //{0=0, 34=34, 67=6767, 88=8888, 44=44, 45=45}
        System.out.println(map3.getClass());
        //class java.util.HashMap

        //4
        Map<Integer, String> map4 =
                IntStream
                        .of(0, 67, 88, 45, 34, 88, 44, 67)
                        .boxed()
                        //.collect(Collectors.toMap(Function.identity(), String::valueOf)); //java.lang.IllegalStateException: Duplicate key 88
                        .collect(Collectors.toMap(Function.identity(), String::valueOf, (x, y) -> x.length() > y.length() ? y + x : x + y, LinkedHashMap::new));
        System.out.println(map4);
        //{0=0, 67=6767, 88=8888, 45=45, 34=34, 44=44}
        System.out.println(map4.getClass());
        //class java.util.LinkedHashMap


    }
}
