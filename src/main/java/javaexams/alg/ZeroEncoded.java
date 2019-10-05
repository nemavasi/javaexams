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

    /**
     * работа через строки - очень плохо по памяти
     * */
    private static String convert(String str2) {
        String str = str2
                        .chars()
                        .boxed()
                        .map(Integer::toBinaryString)
                        .map(x -> {
                                    if (x.length() == 7) {
                                        return x;
                                    } else {
                                        StringBuilder zeros = new StringBuilder("0");
                                        for (int i = 0; i < (7 - x.length() - 1); i++) {
                                            zeros.append("0");
                                        }
                                        zeros.append(x);
                                        return zeros.toString();
                                    }
                                }
                        )
                        //.map(ZeroEncoded::convert)
                        .peek(System.out::println)
                        .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder(str.length());

        int i = 0;
        while (i < str.length()) {
            int count = 0;
            while (i < str.length() && str.charAt(i) == '0') {
                count++;
                i++;
            }
            if (count > 0) {
                sb.append("00 " + IntStream.range(0, count).boxed().map(x -> "0").collect(Collectors.joining()) + " "); //.collect(Collectors.joining()));
            }
            count = 0;
            while (i < str.length() && str.charAt(i) == '1') {
                count++;
                i++;
            }
            if (count > 0) {
                sb.append("0 " + IntStream.range(0, count).boxed().map(x -> "0").collect(Collectors.joining()) + " "); //.collect(Collectors.joining()));
            }

        }
        return sb.toString();
    }


    private static String convert2(String str) {
        String TEXT = str; //"Chuck Norris' keyboard has 2 keys: 0 and white space.";
        char[] MESSAGE = TEXT.toCharArray();
        boolean pbit = (MESSAGE[0] & 0x40) != 0;
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(pbit ? "0 " : "00 ");
        for (char B : MESSAGE) {
            for (char bm = 0x40; bm != 0; bm >>= 1) {
                boolean bit = (B & bm) != 0;
                sb.append((bit == pbit) ? "0" : bit ? " 0 0" : " 00 0");
                pbit = bit;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Chuck Norris' keyboard has 2 keys: 0 and white space.";

        System.out.println(convert(str));
        System.out.println(convert2(str));
        System.out.println(convert("C"));
        System.out.println(convert2("C"));
    }
}
