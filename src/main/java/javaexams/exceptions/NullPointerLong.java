package javaexams.exceptions;

public class NullPointerLong {

  private long x;

  public static void main(String[] args) {
    NullPointerLong n = new NullPointerLong();
    Long l = null;
    n.setX(l);
    System.out.println(n.getX());
  }

  public void setX(long x) {
    this.x = x;
  }

  public long getX() {
    return x;
  }
}
