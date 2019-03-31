package javaexams.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class MessagesQueue extends Thread {

    private static int numberOfLines;
    private static int numberOfThreads;

    private static final Queue<Message> messageQueue = new LinkedList<>();

    public static synchronized void addMessage(Message msg){
        messageQueue.add(msg);
    }
    private static synchronized Message getMessage(){
        return messageQueue.peek();
    }

    private static synchronized Message remove(){
        return messageQueue.poll();
    }

    public static void main(String[] args) {
        //Читаем входные параметры
        if (args.length != 2) {
            throw new IllegalArgumentException("Illegal number of arguments");
        }
        numberOfThreads = Integer.parseInt(args[0]);
        numberOfLines = Integer.parseInt(args[1]);

        //Создаем и запускаем потоки
        Worker[] workers;
        workers = new Worker[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++){
            workers[i] = new Worker();
            workers[i].start();
        }

        //Создаем очередь сообщений
        for(int i = 0; i < numberOfLines; i++){
            for(int j = 0; j < numberOfThreads; j++) {
                addMessage(new Message(Thread.currentThread(), workers[j], workers[j].getName()));
            }
            addMessage(new Message(Thread.currentThread(), workers[0], "\n"));
        }

        synchronized (Worker.class) {
            Worker.class.notifyAll();
        }

        while (!messageQueue.isEmpty()){
            synchronized (Worker.class) {
                try {
                    Worker.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Worker extends Thread{

        public Worker(){
            setDaemon(true);
        }

        @Override
        public void run() {
            super.run();
            synchronized (Worker.class) {
                while(true) {
                    try {
                        Worker.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = getMessage();
                    if (msg!=null && msg.from.getName().equals("main") && msg.to == this) {
                        remove();
                        System.out.print(msg.txt());
                    }
                    Worker.class.notifyAll();
                }
            }
        }
    }

    public static class Message{
        public final Thread from;
        public final Thread to;
        private final String txt;
        public Message(final Thread from, final Thread to, final String txt){
            this.from = from;
            this.to = to;
            this.txt = txt;
        }
        public String txt(){
            return txt + " ";
        }
    }
}