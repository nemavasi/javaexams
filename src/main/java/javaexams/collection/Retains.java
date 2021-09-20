package javaexams.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Retains {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("foo", "boo", "dfg", "sdfdfd", "sd", "sdsd"));
        list.retainAll(Arrays.asList("foo", "boo", "coo"));

        System.out.println(list);
        // [foo, boo]
    }
}
