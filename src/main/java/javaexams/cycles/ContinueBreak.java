package javaexams.cycles;

import java.util.stream.IntStream;

public class ContinueBreak {

    public static void main(String[] args) {

        int[] nm = IntStream.range(0, 5).toArray();

        OUTER:
        for (int i = 0; i < nm.length; i++) {
            for (int j = i; j < nm.length; j++) {
                if (i < 3) {
                    continue OUTER;
                }
                System.out.printf("%d %d \n", i, j);
            }
            System.out.printf("end of i=%d\n", i);
        }
    }
}
