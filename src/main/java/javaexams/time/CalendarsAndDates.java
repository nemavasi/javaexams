package javaexams.time;

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
  }
}
