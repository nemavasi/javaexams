package javaexams.time;

import javaexams.BaseCheck;

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
        p(ldt.toString());
        p(ldt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));

        Period p = Period.of(1, 2, 10);
        p(p.toString());

        ldt = ldt.plus(p);
        p(ldt.toString());
    }
}
