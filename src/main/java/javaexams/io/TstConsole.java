package javaexams.io;

import java.io.Console;

public class TstConsole {
  public static void main(String[] args) {
    /*If the virtual machine is started automatically, for example by a background job scheduler, then it will typically not have a console.*/
    Console console = System.console(); //будет null если запускать класс не из консоли
    char[] pass = console.readPassword();
    System.out.println(new String(pass));
  }
}
