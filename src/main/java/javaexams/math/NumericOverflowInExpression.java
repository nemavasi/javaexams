package javaexams.math;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NumericOverflowInExpression {
  public static void main(String[] args) throws Exception {
    System.out.println(new SimpleDateFormat("dd.MM.yyyy").parse("22.05.2020").getTime() + 30 * 24 * 60 * 60 * 1000 > new Date().getTime());
    System.out.println(new SimpleDateFormat("dd.MM.yyyy").parse("22.05.2020").getTime() + 30L * 24 * 60 * 60 * 1000 > new Date().getTime());
  }
}
