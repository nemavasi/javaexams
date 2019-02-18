package javaexams.streamapi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dshalygin on 2/18/19.
 */
public class TCollectorsToSet {
    public static void main(String[] args) {


        Map<Integer, String> map =
                IntStream
                        .of(0, 67, 88, 45, 34, 88, 44, 67)
                        .boxed()
                        //.collect(Collectors.toMap(Function.identity(), String::valueOf)); //java.lang.IllegalStateException: Duplicate key 88
                        .collect(Collectors.toMap(Function.identity(), String::valueOf, (x, y)->x.length()>y.length()?x:y));
        System.out.println(map);
        //{0=0, 34=34, 67=67, 88=88, 44=44, 45=45}
        System.out.println(map.getClass());
        //class java.util.HashMap

    }
}
