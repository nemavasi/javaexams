package javaexams.concurrency.locks;

import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

public class TStampedLock {

    private String name = "Cezar";
    private StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) throws Exception {

        TStampedLock obj = new TStampedLock();

        Callable writer = ()->{
            long stamp = 0;
            try {
                TimeUnit.SECONDS.sleep(1);
                stamp = obj.stampedLock.writeLock();
                TimeUnit.SECONDS.sleep(2);
                obj.name = "Noy";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("written");
                obj.stampedLock.unlock(stamp);
            }
            return null;
        };

        Callable reader = () -> {
            long stamp;
            String result = null;
            stamp = obj.stampedLock.tryOptimisticRead();

            if (stamp !=0) {
                result = obj.name;
                TimeUnit.SECONDS.sleep(1);
                if (obj.stampedLock.validate(stamp)) {
                    System.out.println("optimistic read");
                    return result;
                }
            }
            try {
                stamp = obj.stampedLock.readLock();
                System.out.println("locked read");
                result = obj.name;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                obj.stampedLock.unlock(stamp);
            }
            return result;
        };

        ExecutorService es = Executors.newWorkStealingPool();
        Future<String> r1 = es.submit(reader);
        Future<String> w = es.submit(writer);
        Future<String> r2 = es.submit(reader);
        Future<String> r3 = es.submit(reader);
        Future<String> r4 = es.submit(reader);

        System.out.println(w.get());
        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());
        System.out.println(r4.get());


        //output:
//        optimistic read
//        optimistic read
//        written
//        null
//        locked read
//        locked read
//        Cezar
//        Cezar
//        Noy
//        Noy


    }
}
