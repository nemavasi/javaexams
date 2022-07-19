package javaexams.math;

public class CompareBoxed {

    public static void main(String[] args) {
        testInt(22, 22);
        testInt(222, 222);
    }

    private static void testInt(Integer i1, Integer i2) {
        System.out.println(i1 == i2);
    }

}

//true
//false