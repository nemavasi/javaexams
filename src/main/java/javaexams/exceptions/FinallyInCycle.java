package javaexams.exceptions;

public class FinallyInCycle {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                if (i < 3) {
                    continue;
                }
            } finally {
                System.out.println(i);
            }
        }
    }
}

//    0
//    1
//    2
//    3
//    4