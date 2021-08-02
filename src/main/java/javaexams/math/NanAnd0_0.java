package javaexams.math;

public class NanAnd0_0 {

    public static void main(String[] args) {
        System.out.println(Double.NaN); //NaN

        System.out.println(Double.NaN==Double.NaN); //false

        System.out.println(-0.0==0.0);    //true
        System.out.println(Double.toString(-0.0)==Double.toString(0.0)); //false
        System.out.println(Double.toString(-0.0));   //-0.0

    }
}
