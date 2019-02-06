package javaexams.time;

import javaexams.BaseCheck;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class CheckTime extends BaseCheck {

    public static void main(String[] args) {
        new CheckTime().go();
    }

    @Override
    public void go() {
        LocalDateTime ldt = LocalDateTime.now();
        p(ldt.toString());
        p(ldt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));

        Period p = Period.of(1, 2, 10);
        p(p.toString());

        ldt = ldt.plus(p);
        p(ldt.toString());

        Duration duration1 = Duration.ofDays(365);
        Duration duration2 = Duration.ofDays(60);
        Duration duration3 = Duration.ofDays(10);

        Duration duration = duration1.plus(duration2).plus(duration3);
        p(duration.toString());
        p(ldt.minus(duration).toString());
    }
}
