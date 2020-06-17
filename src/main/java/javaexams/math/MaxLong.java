package javaexams.math;

public class MaxLong {
  public static void main(String[] args) {
    long n = Long.MAX_VALUE;
    System.out.println(n);
    n++;
    System.out.println(n);
    System.out.println(n % 100);

    n = n + 8;
    System.out.println(n % 100);
  }
}
