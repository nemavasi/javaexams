package javaexams.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayIO {
  public static void main(String[] args) throws IOException {
    System.out.println();
    String str = "Привет, мир!";

    CharArrayReader charArrayReader = new CharArrayReader(str.toCharArray());

    System.out.println();
    int c;
    while((c = charArrayReader.read()) != -1){
      if (c == ',') {
        System.out.print("ЗПТ");
      } else {
        System.out.print((char) c);
      }
    }


    //
    CharArrayWriter charArrayWriter = new CharArrayWriter();
    charArrayWriter.write("Test "+ str, 2, str.length() );
    System.out.println();
    System.out.println("--------------------");
    System.out.println(charArrayWriter.toCharArray());
  }
}
