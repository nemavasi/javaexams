package javaexams.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.System.out;

public class CoolSemaphore {
    private final int PERMITS = Integer.MAX_VALUE;
    private Semaphore semaphore = new Semaphore(PERMITS);

    private String mountainKingName;


    public void read(){
        try {
            semaphore.acquire(1);
            out.println(" read king = " + Thread.currentThread().getName() + mountainKingName + " "+ semaphore.availablePermits());
            //TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            out.println(Thread.currentThread().getName() + " is interrupted!");
        } finally {
            semaphore.release(1);
        }
    }

    public void write(){
        try {
            semaphore.acquire(PERMITS);
            out.println("write king = " + Thread.currentThread().getName() + " " + semaphore.availablePermits());
            //TimeUnit.SECONDS.sleep(1);
            mountainKingName = Thread.currentThread().getName();
        } catch (InterruptedException e) {
            out.println(Thread.currentThread().getName() + " is interrupted!");
        } finally {
            semaphore.release(PERMITS);
        }
    }


    public static void main(String[] args) {

        CoolSemaphore cool = new CoolSemaphore();

        List<Callable<String>> all = new ArrayList<>();
        for (int i=0; i < 100; i++){
            all.add(
                    ()->
                    {
                        cool.read();
                        return null;
                    });
        }

        for (int i=0; i < 10; i++){
            all.add(
                    ()->
                    {
                        cool.write();
                        return null;
                    });
        }
        all.sort((z,x)-> new Random().nextInt());
        out.println(all);

        ExecutorService service = Executors.newWorkStealingPool();
        try {
            service.invokeAll(all);
            TimeUnit.SECONDS.sleep(5);
            service.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
