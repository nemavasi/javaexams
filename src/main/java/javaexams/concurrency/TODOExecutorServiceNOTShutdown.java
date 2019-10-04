package javaexams.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TODOExecutorServiceNOTShutdown {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(
                () -> {
                    System.out.println("start");
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("I am interrupted");
                            break;
                        } else {
                            System.out.println("I am not interrupted");
                        }
                        try {
                            TimeUnit.MINUTES.sleep(2);
                            System.out.println("I am not sleeping");
                        } catch (InterruptedException e) {
                            System.out.println("task interrupted");
                          //  throw e; //если не пробросить то поток будет продолжать работать
                        }
                    }
                    System.out.println("end");
                }
        );

        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        } finally {
            if (!service.isTerminated()) {
                System.out.println("service is not terminated");
                service.shutdownNow();  //однако если поток сам ловит InterruptedException и их поглощает - то поток не остановится
            } else {
                System.out.println("service is terminated");
            }
            System.out.println("end finally");
        }

        System.out.println("end main " + service.isShutdown());
    }
}
