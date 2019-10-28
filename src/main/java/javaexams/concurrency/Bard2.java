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

public class Bard2 {

    private List<String> song;
    private String name;
    private AtomicReference<Bard2> speaker;
    private Phaser phaser;
    private Exchanger<String> exchanger;
    private List<String> newSong = new ArrayList<>();

    //private

    public Bard2(List<String>  song, String name, AtomicReference<Bard2> speaker, Phaser phaser, Exchanger<String> exchanger) {
        this.song = song;
        this.name = name;
        this.speaker = speaker;
        this.phaser = phaser;
        this.exchanger = exchanger;
    }

    public void tellWordsToOthers () throws Exception{
        for (int i=0; i < 2; i++) {
            phaser.arriveAndAwaitAdvance();
            if (speaker.get() != this) {
                speaker.set(this);
            }
            phaser.arriveAndAwaitAdvance();
            if (speaker.get() == this) {
                exchanger.exchange(song.get(i));
                exchanger.exchange(song.get(i));
                exchanger.exchange(song.get(i));
            } else {
                String wordFromOther = exchanger.exchange(null);
                newSong.add(wordFromOther);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AtomicReference<Bard2> speaker = new AtomicReference<>();
        Phaser phaser = new Phaser(4);
        Exchanger<String> exchanger = new Exchanger<>();

        List<Bard2> bards = new ArrayList<>();
        bards.add(new Bard2(Arrays.asList("Hello", "world", "Java", "People"), "Jack", speaker, phaser, exchanger));
        bards.add(new Bard2(Arrays.asList("Hello", "world", "Java", "People"), "Jack", speaker, phaser, exchanger));
        bards.add(new Bard2(Arrays.asList("Hello", "world", "Java", "People"), "Jack", speaker, phaser, exchanger));
        bards.add(new Bard2(Arrays.asList("Hello", "world", "Java", "People"), "Jack", speaker, phaser, exchanger));

        for(Bard2 bard : bards){
            bard.tellWordsToOthers();
        }

        System.out.println(bards.get(0).newSong);

    }
}
