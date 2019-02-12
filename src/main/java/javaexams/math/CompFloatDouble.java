package javaexams.math;

public class CompFloatDouble {
    public static void main(String [] args) {
        float f = 29.1f;
        double d = 29.1;
        System.out.println( f == d );  //false
        f = 29.1f;
        d = 29.1f;
        System.out.println( f == d );  //true
        int i = 1;
        long l = 1L;
        System.out.println( i == l );  //true
    }
}