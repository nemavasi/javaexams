package javaexams.concurrency;
//
//Четверо бардов пришли в таверну. У каждого из них есть своя песня. В середине вечера, хозяин заведения попросил их
//        исполнить песню. Прилично выпив, барды не смогли прийти к согласию кто именно будет петь и решили составить
//        общую песню на основе остальных. Было решено, что хозяин этого захудалого местечка, получит максимум 8 слов.
//        Барды придумали способ, как составить текст, да так, чтобы каждый поучаствовал. А именно: Один из четверых
//        называет слово, остальные его запоминают. Потом так делает следующий. И так восемь раз, по два раза каждый
//        соответственно, но не два раза подряд. В конце, барды хором поют песню, вызывая бурные овации посетителей зала
//        и недовольство хозяина таверны столь кратким произведением. Для решения этой задачи нужно воспользоваться
//        классом Exchanger(иначе как барды будут друг другу что-то говорить?) и классом Phaser (иначе как барды поймут,
//        когда нужно делиться словом?)

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Bard extends Thread {

    private volatile static boolean isSong = false;
    private  static AtomicInteger countsWords = new AtomicInteger(0);
    private String name;
    private String song;
    private String newSong = "";
    private Exchanger<String> exchanger;
    private Phaser phaser;
    private Semaphore semaphore;

    public Bard(String name, String song, Exchanger<String> exchanger, Phaser phaser, Semaphore semaphore) {
        this.name = name;
        this.song = song;
        this.exchanger = exchanger;
        this.phaser = phaser;
        this.semaphore = semaphore;
        this.start();
    }

    private synchronized boolean isSong(){
        return !isSong && (isSong = true);
    }

    @Override
    public void run() {
        String[] songArr = song.split(" ");
        for (int i = 0; i < 2; i++) {

            try {
                semaphore.acquire();
                String word = songArr[(int) (Math.random() * songArr.length)] + " ";
                if (isSong()) {
                    newSong += word;
                    countsWords.getAndIncrement();
                    exchanger.exchange(newSong);

                } else {
                    newSong = exchanger.exchange("");
                    newSong += word;
                    countsWords.getAndIncrement();
                    System.out.println(name + ": " + newSong);
                    if (countsWords.get() < 8) {
                        exchanger.exchange(newSong);
                    }
                }
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phaser.arriveAndAwaitAdvance();
        }
    }
}

class Bar {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Semaphore semaphore = new Semaphore(2);
        Phaser phaser = new Phaser(3);
        new Bard("Jack", "Hello world Java People", exchanger, phaser, semaphore);
        new Bard("Kim", "Hi students rock KPI", exchanger, phaser, semaphore);
        new Bard("Bill", "Ku over party fire",exchanger,phaser, semaphore);
        new Bard("Richard", "Winner star awesome things",exchanger,phaser, semaphore);
    }
}