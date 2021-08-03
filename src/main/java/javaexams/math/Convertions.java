package javaexams.math;

public class Convertions {

    public static void main(String[] args) {
        byte b = Integer.MAX_VALUE + Integer.MAX_VALUE; //константа времени компиляции
        System.out.println(b); //-2

        System.out.println((int)Double.MAX_VALUE);  //2147483647
        System.out.println(((int)Double.MAX_VALUE)==Integer.MAX_VALUE); //true
        System.out.println((int)Long.MAX_VALUE);    //-1
    }
}
