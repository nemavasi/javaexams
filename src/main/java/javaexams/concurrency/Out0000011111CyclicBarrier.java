package javaexams.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

public class Out0000011111CyclicBarrier {

    //будет хранить какому потоку можно осуществлять вывод
    private static AtomicReference<MyThread> link = new AtomicReference<>();

    public static void main(String[] args) throws Exception {

        //для одновременного запуска потоков делаем барьер
        CyclicBarrier cb = new CyclicBarrier(2);

        MyThread thread1 = new MyThread(false, cb);
        MyThread thread2 = new MyThread(true, cb);

        //пусть каждый поток имеет ссылку на другого
        thread1.setOtherThread(thread2);
        thread2.setOtherThread(thread1);

        link.compareAndSet(null, thread1); //инициализация

        thread1.start();
        thread2.start();

    }


    public static class MyThread extends Thread {
        private boolean flag;   //флаг того что именно печатать
        private CyclicBarrier cb;
        private MyThread otherThread;

        public MyThread(boolean flag, CyclicBarrier cb) {
            this.flag = flag;
            this.cb = cb;
        }

        void setOtherThread(MyThread thread) {
            this.otherThread = thread;
        }

        @Override
        public void run() {
            super.run();
            try {
                //ждем на барьере
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
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
