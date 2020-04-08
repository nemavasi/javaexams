package javaexams.time;

import java.text.SimpleDateFormat;

public class ParseStringToTime {
  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    System.out.println(sdf.parse("24:00"));
  }
}
