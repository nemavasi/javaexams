package javaexams.imports;

import static java.lang.Math.PI;
import static java.util.Arrays.*;

import java.util.Arrays;

public class StaticImports {

    double PI = 3.14;

    public static void main(String[] args) {
        int[] m = new int[]{4 , 6, 1};
        sort(m);
        //System.out.println(toString(m)); //method toString is a name of method in Object class, although without args
        System.out.println(Arrays.toString(m));
        //System.out.println(PI); //because it exists in this class
    }
}
