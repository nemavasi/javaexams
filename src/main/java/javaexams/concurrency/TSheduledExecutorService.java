package javaexams.concurrency;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TSheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> System.out.println("1 " + LocalDate.now());
        Runnable task2 = () -> System.out.println("****************************");
        Runnable task3 = () -> System.out.println("3 " + LocalDate.now());

        service.schedule(task1, 3, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(task2, 0, 5, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(task3, 0, 2, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(30);
        service.shutdownNow();

    }
}
