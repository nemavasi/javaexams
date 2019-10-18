package javaexams.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Out0000011111 {

    //будет хранить какому потоку можно осуществлять вывод
    private static AtomicReference<MyThread> link = new AtomicReference<>();

    public static void main(String[] args) throws Exception {

        //для одновременного запуска потоков делаем защелку
        CountDownLatch latch = new CountDownLatch(1);

        MyThread thread1 = new MyThread(false, latch);
        MyThread thread2 = new MyThread(true, latch);

        //пусть каждый поток имеет ссылку на другого
        thread1.setOtherThread(thread2);
        thread2.setOtherThread(thread1);

        link.compareAndSet(null, thread1); //инициализация

        thread1.start();
        thread2.start();

        //на всякий случай подождем чтоб оба на защелке зависли
        Thread.sleep(1000);

        //запуск обоих потоков
        latch.countDown();
    }


    public static class MyThread extends Thread {
        private boolean flag;   //флаг того что именно печатать
        private CountDownLatch latch;
        private MyThread otherThread;

        public MyThread(boolean flag, CountDownLatch latch) {
            this.flag = flag;
            this.latch = latch;
        }

        void setOtherThread(MyThread thread) {
            this.otherThread = thread;
        }

        @Override
        public void run() {
            super.run();
            try {
                //ждем на защелке
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                //крутимся в цикле пока не сможем напечатать
                while (true) {
                    //печатаем только если разрешено
                    if (link.get() == MyThread.this) {
                        if (flag) {
                            System.out.println("11111");
                        } else {
                            System.out.println("00000");
                        }
                        link.compareAndSet(this, otherThread);
                        break;
                    }
                }
            }
        }
    }
}
