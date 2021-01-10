package javaexams.io;

import java.io.Console;

public class TstConsole {
  public static void main(String[] args) {
    Console console = System.console(); //будет null если запускать класс не из консоли
    char[] pass = console.readPassword();
    System.out.println(new String(pass));
  }
}
