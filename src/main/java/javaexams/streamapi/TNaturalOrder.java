package javaexams.streamapi;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TNaturalOrder {
    public static void main(String[] args) {

        System.out.println(Stream.of("sdf", "sss", "55", "dsf", "aq")  //with null - java.lang.NullPointerException
                .sorted().collect(Collectors.toList()));
        //[55, aq, dsf, sdf, sss]

        System.out.println(Stream.of("sdf", "sss", "55", "dsf", "aq") //with null - java.lang.NullPointerException
                .sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        //[55, aq, dsf, sdf, sss]

        System.out.println(Stream.of("sdf", "sss", "55", "dsf", "aq") //with null - java.lang.NullPointerException
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        //[sss, sdf, dsf, aq, 55]

        System.out.println(Stream.of("sdf", "sss", "55", "dsf", "aq", null)
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .collect(Collectors.toList()));
        //[null, 55, aq, dsf, sdf, sss]
    }
}
