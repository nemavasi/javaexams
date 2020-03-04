package javaexams.bitops;

public class Shift3 {
    public static void main(String[] args) {
        long start = 11917478287L; //Long.MAX_VALUE-11;
        for (long i = start; i < start + 10; i++ ) {
            System.out.println(String.format("%d %d %d", i, i >>> 32, i ^ (i>>>32)));
        }
    }
}
