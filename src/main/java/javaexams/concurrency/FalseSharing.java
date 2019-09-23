package javaexams.concurrency;

import java.util.Date;

class CalcThread implements Runnable {

    private int idx;
    private long nOperations;

    public CalcThread(int idx, long nOperations) {
        this.idx = idx;
        this.nOperations = nOperations;
    }

    @Override
    public void run() {
        for (int i = 0; i < nOperations; i++) {
            FalseSharing.m[idx] = (FalseSharing.m[idx] / 2) + 4;
        }
    }
}


public class FalseSharing {

    protected static volatile int[] m = new int[100];
    private final static int x = 0;
    private final static int y = 99; //99

    public static void main(String[] args) throws InterruptedException {

        Long start = new Date().getTime();

        Thread t1 = new Thread(new CalcThread(x, 999999999));
        Thread t2 = new Thread(new CalcThread(y, 999999999));

        t1.start();
        t2.start();

        t2.join();
        t1.join();

        Long end = new Date().getTime();
        System.out.printf("%d :: %d", m[x] + m[y], end - start); //14 :: 10229  14 :: 10967
    }
}
