package javaexams.io;

import java.io.*;
import java.nio.charset.Charset;

public class BytesIO {
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

    try(Reader reader = new FileReader(file)){
      int b;
      while ((b = reader.read()) > 0) {
        System.out.print((char)b);
      }
    }

    System.out.println();
    System.out.println();
    System.out.println("читаем по пачке символов - и выводим");
    try(Reader reader = new FileReader(file, Charset.forName("Windows-1251"))){
      int s = 1000;
      char[] b = new char[s];
      int cnt;
      while ((cnt = reader.read(b, 0, s)) > 0) {
        for (int i = 0; i < cnt; i++) {
          System.out.print(b[i]);
        }
      }
    }
  }
}
