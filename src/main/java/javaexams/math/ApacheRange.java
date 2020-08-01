package javaexams.math;

import org.apache.commons.lang3.Range;

public class ApacheRange {
  //9001803000057L
  public static void main(String[] args) {
    Range<Long> numberRange = Range.between(9001803000057L, 9001803000057L);
    System.out.println(numberRange.contains(new Long(9001803000057L)));
  }

}
