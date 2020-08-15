package javaexams.enums;

public enum EnamName {
  RED, BLUE;

  public static void main(String[] args) {
    System.out.println(EnamName.RED);

    System.out.println(BLUE==EnamName.valueOf("BLUE"));
    System.out.println(BLUE==EnamName.valueOf("BLUE2"));
  }
}
