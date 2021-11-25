package javaexams.math;

public class DivideTest {

    public static void main(String[] args) {
        long a = 1519516510498L;
        int b = 86400000;
        long result = a / b * b;
        long result2 = a - a % b;
        double resultD = (1.0 * a / b) * b;
        System.out.println(result);
        System.out.println(result2);
        System.out.println(resultD);

    }
}
