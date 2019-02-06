package javaexams.time;

import javaexams.BaseCheck;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CheckTime extends BaseCheck {

    public static void main(String[] args) {
        new CheckTime().go();
    }

    @Override
    public void go() {
        LocalDateTime ldt = LocalDateTime.now();
        p(ldt.toString());   //2019-02-06T09:11:08.663
        p(ldt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));  //06.02.2019 09:11:08

        Period p = Period.of(1, 2, 10);
        p(p.toString());    //P1Y2M10D

        ldt = ldt.plus(p);
        p(ldt.toString());  //2020-04-16T09:11:08.663

        Duration duration1 = Duration.ofDays(365);
        Duration duration2 = Duration.ofDays(60);
        Duration duration3 = Duration.ofDays(10);

        Duration duration = duration1.plus(duration2).plus(duration3);
        p(duration.toString());            //PT10440H
        p(ldt.minus(duration).toString()); //2019-02-06T09:11:08.663
    }
}
