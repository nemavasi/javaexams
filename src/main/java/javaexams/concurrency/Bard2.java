package javaexams.concurrency;
//Четверо бардов пришли в таверну. У каждого из них есть своя песня. В середине вечера, хозяин заведения попросил их
//        исполнить песню. Прилично выпив, барды не смогли прийти к согласию кто именно будет петь и решили составить
//        общую песню на основе остальных. Было решено, что хозяин этого захудалого местечка, получит максимум 8 слов.
//        Барды придумали способ, как составить текст, да так, чтобы каждый поучаствовал. А именно: Один из четверых
//        называет слово, остальные его запоминают. Потом так делает следующий. И так восемь раз, по два раза каждый
//        соответственно, но не два раза подряд. В конце, барды хором поют песню, вызывая бурные овации посетителей зала
//        и недовольство хозяина таверны столь кратким произведением. Для решения этой задачи нужно воспользоваться
//        классом Exchanger(иначе как барды будут друг другу что-то говорить?) и классом Phaser (иначе как барды поймут,
//        когда нужно делиться словом?)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicReference;

public class Bard2 implements Runnable {

    private List<String> song;
    private String name;
    private AtomicReference<Bard2> speaker;
    private Phaser phaser;
    private Exchanger<String> exchanger = new Exchanger<>();
    private List<String> newSong = new ArrayList<>();
    private List<Bard2> bardList;


    public Bard2(List<String> song, String name, AtomicReference<Bard2> speaker, Phaser phaser, List<Bard2> bardList) {
        this.song = song;
        this.name = name;
        this.speaker = speaker;
        this.phaser = phaser;
        this.bardList = bardList;
    }

    @Override
    public void run() {
        try {
            tellWordsToOthers();
            phaser.arriveAndAwaitAdvance();
            singTogether();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tellWordsToOthers() throws Exception {
        int receiveCount = 0; //количество полученных слов
        int sendCount = 0;    //количество отправленных слов (одно и тоже слово считается 1 раз)
        while (sendCount < 2 || receiveCount < (bardList.size() - 1) * 2) {
            System.out.println("phase #" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            Bard2 oldSender = speaker.get();
            phaser.arriveAndAwaitAdvance();
            if (sendCount < 2 && oldSender != this) {
                speaker.set(this);
            }
            phaser.arriveAndAwaitAdvance();
            if (speaker.get() == this && sendCount < 2 ) {
                for (Bard2 bard : bardList) {
                    if (bard != this) {
                        System.out.println(name + " is sending to get...");
                        bard.exchanger.exchange(song.get(sendCount));
                    }
                }
                newSong.add(song.get(sendCount));
                sendCount++;
            } else {
                System.out.println(name + " is waiting to get...");
                String wordFromOther = exchanger.exchange(null);
                receiveCount++;

                newSong.add(wordFromOther);
            }
            System.out.println(name + " send: " + sendCount + " receive: " + receiveCount);
        }

    }

    private void singTogether() {
        System.out.println(name + " " + newSong);
    }

    public static void main(String[] args) throws Exception {
        AtomicReference<Bard2> speaker = new AtomicReference<>();
        Phaser phaser = new Phaser(4);
        Exchanger<String> exchanger = new Exchanger<>();

        List<Bard2> bards = new ArrayList<>();
        bards.add(new Bard2(Arrays.asList("Учил", "я", "Java", "между"), "Jack", speaker, phaser, bards));
        bards.add(new Bard2(Arrays.asList("делом", "а", "таже", "Python"), "Alice", speaker, phaser, bards));
        bards.add(new Bard2(Arrays.asList("и", "C#", "вот только", "лучше"), "Bob", speaker, phaser, bards));
        bards.add(new Bard2(Arrays.asList("надо", "было", "красивых", "девушек", "знать"), "Antony", speaker, phaser, bards));

        bards.forEach(t -> new Thread(t).start());
    }
}
