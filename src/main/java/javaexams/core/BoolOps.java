package javaexams.core;

import java.util.Random;

public class BoolOps {

    private static Boolean x = true;
    private static Boolean y = false;

    public static void main(String[] args) {

        System.out.println(x^y);

        x ^= true;
        System.out.println(x);

        x = false;
        y = b();
        x = x && y; //ok - because short calculations
        x &= y; //not ok - because x = x & y;


    }

    private static Boolean b(){
        return null;
    }
}
