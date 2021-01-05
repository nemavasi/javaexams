package javaexams.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;

public class StandardIO {
  public static void main(String[] args) throws IOException {
    System.out.println(System.getProperty("java.class.path"));
    String[] javaClassPaths = System.getProperty("java.class.path").split(File.pathSeparator);

//    File file = new File(javaClassPaths[0] + File.separator + "example.txt");
    File file = new File(javaClassPaths[0] + File.separator + "wp1.txt");
    System.out.println(file.exists());

    System.out.println();
    System.out.println("читаем по одному байту");
    try(InputStream inputStream = new FileInputStream(file)){
      int b;
      while ((b = inputStream.read()) > 0) {
        System.out.print(b);
        System.out.print(" ");
      }
    }

    System.out.println();
    System.out.println("читаем по одному символу - но как число");
    try(Reader reader = new FileReader(file)){
      int b;
      while ((b = reader.read()) > 0) {
        System.out.print(b);
        System.out.print(" ");
      }
    }

    System.out.println();
    System.out.println("читаем по одному символу - и выводим символ");
    long t1 = new Date().getTime();
    try(Reader reader = new FileReader(file)){
      int b;
      while ((b = reader.read()) > 0) {
        System.out.print((char)b);
      }
    }
    System.out.println("=" + (new Date().getTime() - t1));

    System.out.println();
    System.out.println();
    System.out.println("читаем по пачке символов - и выводим");
    long t2 = new Date().getTime();
    try(Reader reader = new FileReader(file, Charset.forName("Windows-1251"))){
      int s = 100000;
      char[] b = new char[s];
      int cnt;
      while ((cnt = reader.read(b, 0, s)) > 0) {
        for (int i = 0; i < cnt; i++) {
          System.out.print(b[i]);
        }
      }
    }
    System.out.println("=" + (new Date().getTime() - t2));


    System.out.println();
    System.out.println("читаем только часть символов - с 10 по 20, в начало подставляем другой текст");
    try(Reader reader = new FileReader(file, Charset.forName("Windows-1251"))){
      char[] chars = new char[25];
      String str = "Привет, друг. ";
      for (int i = 0; i < str.length(); i++) {
        chars[i] = str.charAt(i);
      }
      System.out.println(chars);
      if (reader.skip(9) > 0){
        reader.read(chars, 14, 11);
      }
      System.out.println(chars);

    }
  }
}
