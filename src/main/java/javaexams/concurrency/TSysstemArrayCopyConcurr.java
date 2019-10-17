package javaexams.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TSysstemArrayCopyConcurr {
    private static volatile int[] arrayOriginal = new int[1024 * 1024 * 10];
    private static volatile int[] arraySrc = new int[1024 * 1024 * 10];
    private static volatile int[] arrayDist = new int[1024 * 1024 * 10];
    private static ReentrantLock lock = new ReentrantLock();

    private static void modify() {
        for (int i = 0; i < arraySrc.length; i++) {
            arraySrc[i] = i + 1;
        }
    }

    private static void copy() {
        System.arraycopy(arraySrc, 0, arrayDist, 0, arraySrc.length);
    }

    private static void init() {
        for (int i = 0; i < arraySrc.length; i++) {
            arrayOriginal[i] = i;
            arraySrc[i] = i;
            arrayDist[i] = 0;
        }
    }

    private static void doThreadSafeCheck() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("run count: " + (i + 1));
            init();
            Condition condition = lock.newCondition();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    condition.signalAll();
                    lock.unlock();
                    copy();
                }
            }).start();


            lock.lock();
            // Here Condition is used to ensure that the copy thread is already running.
            condition.await();
            lock.unlock();

            Thread.sleep(2); // Sleep for 2 milliseconds, make sure the copy operation has been executed before performing the modify operation.
            modify();

            if (!Arrays.equals(arrayOriginal, arrayDist)) {
                for (int k=0; k<arrayOriginal.length; k++)
                    if (arrayOriginal[k] != arrayDist[k]) {
                        System.out.println("diff :: " + k + " " + arrayOriginal[k] + " "  + arrayDist[k]);
                        break;
                    }
                throw new RuntimeException("System.arraycopy is not thread safe");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        doThreadSafeCheck();
    }


}
