package javaexams.math;

public class Exact {

    public static void main(String[] args) {
        //Math.negateExact(Integer.MIN_VALUE); //Exception in thread "main" java.lang.ArithmeticException: integer overflow

        Math.addExact(Integer.MAX_VALUE, 1); //Exception in thread "main" java.lang.ArithmeticException: integer overflow
    }
}
