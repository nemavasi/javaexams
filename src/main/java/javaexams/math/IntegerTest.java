package javaexams.math;

public class IntegerTest {

    public static void main(String[] args) {

        int x;

        x = Integer.parseUnsignedInt("42");

        System.out.println(Integer.signum(x));

        x = Integer.parseInt("-42");

        System.out.println(Integer.signum(x));
    }
}
