package javaexams.streamapi;

import java.util.Arrays;
import java.util.List;

public class TLimits {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("sd", "fasd");
        System.out.println(list.stream().limit(0).toArray().length);
    }
}
