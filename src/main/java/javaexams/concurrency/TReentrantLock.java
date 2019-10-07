package javaexams.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TReentrantLock {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable r1 = ()-> {
            try {
                reentrantLock.lock();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            System.out.println("r1 is ended");
        };

        Runnable r2 = ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(reentrantLock.isLocked());
                System.out.println(reentrantLock.tryLock());
                System.out.println(reentrantLock.isHeldByCurrentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("r2 is ended");
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
