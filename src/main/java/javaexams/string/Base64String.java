package javaexams.string;

import java.text.SimpleDateFormat;
import java.util.Base64;

public class Base64String {
  public static void main(String[] args) throws Exception {

    System.out.println(new String((Base64.getEncoder()).encode(("test:test").getBytes())));
  }
}
