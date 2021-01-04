package javaexams.time;

import groovy.json.JsonOutput;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarsAndDates {
  public static void main(String[] args) throws Exception{
    //System.out.println(ZoneInfo.getAvailableIDs());

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss Z");
    Date date = new Date();
    System.out.println(sdf.format(date));

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    System.out.println(sdf.format(calendar.getTime()));

    calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
    calendar.setTime(date);
    System.out.println(sdf.format(calendar.getTime()));

    calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Vancouver"));
    calendar.setTime(date);
    System.out.println(sdf.format(calendar.getTime()));

    Thread.sleep(1000);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(new Date());

    System.out.println(calendar2.after(date));
    System.out.println(calendar2.before(date));
    //ибо нефиг сравнивать разные классы
    System.out.println(calendar2.after(calendar));

    System.out.println("*********************************");

    Calendar calendar3 = Calendar.getInstance();
    calendar3.setTime(new Date());
    calendar3.add(Calendar.DATE, 1);  // number of days to add
    System.out.println(sdf.format(calendar3.getTime()));  // dt is now the new date


  }
}
