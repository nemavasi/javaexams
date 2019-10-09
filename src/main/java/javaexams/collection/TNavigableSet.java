package javaexams.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TNavigableSet {
    public static void main(String[] args) {

        //задача найти ближайший элемент к данному - точнее равный заданнному или меньше его

        NavigableSet<Long> set = new TreeSet<>();
        set.add(22L);
        set.add(34L);
        set.add(40L);
        set.add(42L);

        System.out.println(set.floor(39L).equals(34L));
        System.out.println(set.floor(41L).equals(40L));
        System.out.println(set.floor(42L).equals(42L));
        System.out.println(set.floor(43L).equals(42L));

        System.out.println("************************************************");

        NavigableSet<Date> setDates = new TreeSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            setDates.add(sdf.parse("2019-09-01 02:42:34"));
            setDates.add(sdf.parse("2019-10-01 02:42:34"));
            setDates.add(sdf.parse("2019-10-03 02:42:34"));
            setDates.add(sdf.parse("2019-10-03 04:42:34"));

            System.out.println(setDates.floor(new Date()).equals(sdf.parse("2019-10-03 04:42:34")));
            System.out.println(setDates.floor(sdf.parse("2019-10-03 04:42:34")).equals(sdf.parse("2019-10-03 04:42:34")));
            System.out.println(setDates.floor(sdf.parse("2019-10-03 04:42:33")).equals(sdf.parse("2019-10-03 02:42:34")));
            System.out.println(setDates.floor(sdf.parse("2019-10-03 02:40:33")).equals(sdf.parse("2019-10-01 02:42:34")));
            System.out.println(setDates.floor(sdf.parse("2019-08-03 04:42:33"))==null);
            System.out.println(setDates.contains(sdf.parse("2019-08-03 04:42:33"))==false);
            System.out.println(setDates.contains(sdf.parse("2019-09-01 02:42:34")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
