package javaexams.concurrency;


public class TThreadImpl extends Thread {
    public void go() { System.out.println( "Go!" + Thread.currentThread().getName()); }
    public void run() { System.out.println( "Run!" + Thread.currentThread().getName()); }
    public void begin() { System.out.println( "Begin!"+ Thread.currentThread().getName() ); }
    public void execute() { System.out.println( "Execute!"+ Thread.currentThread().getName() ); }

    public static void main( String[] args ) {
        TThreadImpl myTest = new TThreadImpl();
        myTest.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("42 " + Thread.currentThread().getName());
            }
        }.start();

//        42 Thread-1
//        Run!Thread-0
    }
}