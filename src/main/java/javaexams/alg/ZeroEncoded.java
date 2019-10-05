package javaexams.alg;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1) The input message consists of ASCII characters (7-bit)
//        2) The encoded output message consists of blocks of 0
//        3) A block is separated from another block by a space
//        4) Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
//        - First block: it is always 0 or 00.
//                 If it is 0, then the series contains 1,
//                 if not, it contains 0
//        - Second block: the number of 0 in this block is the number of bits in the series
//
//        1000011 -> 0 0 00 0000 0 00по сути тоже надо бежать и считать одинаковые символы


public class ZeroEncoded {


    private static String convert(String str){

        StringBuilder sb = new StringBuilder(str.length());

        int i = 0;
        while (i < str.length()){
            int count = 0;
            while (i < str.length() && str.charAt(i)=='0'){
                count++;
                i++;
            }
            if (count > 0){
                sb.append("00 " + IntStream.range(0, count).boxed().map(x->"0").collect(Collectors.joining()) + " "); //.collect(Collectors.joining()));
            }
            count = 0;
            while (i < str.length() && str.charAt(i)=='1'){
                count++;
                i++;
            }
            if (count > 0){
                sb.append("0 " + IntStream.range(0, count).boxed().map(x->"0").collect(Collectors.joining()) + " "); //.collect(Collectors.joining()));
            }

        }

        return sb.toString();
    }

    public static void main2(String[] args) {
        IntStream.range(0, 7).boxed().map(x->"6").forEach(System.out::println);
    }

    public static void main(String[] args) {
        String result =

            "1Asosz"
                .chars()
                .boxed()
                .map(Integer::toBinaryString)
                .map(x -> {
                            if (x.length() == 7) {
                                return x;
                            } else {
                                StringBuilder zeros = new StringBuilder("0");
                                for (int i = 0; i<(7 - x.length() - 1); i++){
                                    zeros.append("0");
                                }
                                zeros.append(x);
                                return zeros.toString();
                            }
                        }
                )
                //.map(ZeroEncoded::convert)
                .peek(System.out::println)
                .collect(Collectors.joining())

                ;

        System.out.println(result);
        System.out.println(convert(result));
    }
}
