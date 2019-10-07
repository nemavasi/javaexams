package javaexams.concurrency.synchronizers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TCyclicBarier {


    public static void main(String[] args) {
        int runnersInGroup = 3;

        Semaphore semaphore = new Semaphore(runnersInGroup);
        CyclicBarrier barrier = new CyclicBarrier(runnersInGroup);

        List<Thread> list = new ArrayList<>(21);
        for (int i = 0; i < 21; i++) {
            list.add(new Runner(semaphore, barrier));
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }

    }

    static class Runner extends Thread {

        private Semaphore semaphore;
        private CyclicBarrier barrier;

        public Runner(Semaphore semaphore, CyclicBarrier barrier) {
            this.semaphore = semaphore;
            this.barrier = barrier;

        }

        @Override
        public void run() {
            super.run();

            System.out.println(Thread.currentThread().getName() + " is near the start");
            try {

                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is prepearing to start!");
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is running!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            Random rand = new Random();
            while (true) {
                if (rand.nextLong() > Long.MAX_VALUE - 0x7fffffffL) {
                    break;
                }
            }

            System.out.println(Thread.currentThread().getName() + " is finished!");


        }
    }


}
