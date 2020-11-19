package javaexams.time;

public class Timestamp {
  public static void main(String[] args) {
    String normString = "2020-11-20 06:10:00";
    java.sql.Timestamp ts = java.sql.Timestamp.valueOf(normString); //ошибки нет
    System.out.println(normString.charAt(11));
    System.out.println(normString.getBytes()[11]);

    String errString = "2020-11-20 06:10:00";
    System.out.println(errString.charAt(11));
    System.out.println(errString.getBytes()[11]); //символ с кодом 160
    if (errString.contains(" ")) {
      System.out.println("неразрывный пробел");
    }


    System.out.println(normString.equals(errString)); //false
    java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(errString); //ошибка есть - из-за неразрывного пробела


  }
}
