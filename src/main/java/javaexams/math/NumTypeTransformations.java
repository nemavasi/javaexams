package javaexams.math;

import java.math.BigDecimal;

public class NumTypeTransformations {

    public static void main(String[] args) {
        double a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        int c = 1;

        System.out.println(a + b + c); //1.8446744073709552E19
        System.out.println(c + b + a); //0.0
        System.out.println(Long.toBinaryString(Long.MIN_VALUE)); //1000000000000000000000000000000000000000000000000000000000000000
        System.out.println(new Double(Long.MIN_VALUE));  //-9.223372036854776E18
        System.out.println(new Double(Long.MAX_VALUE));  //-9.223372036854776E18

        BigDecimal bd = new BigDecimal(Long.MIN_VALUE);
        bd = bd.add(new BigDecimal( Long.MAX_VALUE));
        System.out.println(bd); //-1



    }
}
