package javaexams.io;

import java.io.*;
import java.util.Arrays;

public class DataIO {
  public static void main(String[] args) throws IOException {
    String[] javaClassPaths = System.getProperty("java.class.path").split(File.pathSeparator);
    System.out.println(Arrays.asList(javaClassPaths));
    File file = new File(javaClassPaths[0] + File.separator + "dataio1.data");

    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      DataOutput dataOutput = new DataOutputStream(fileOutputStream);
      dataOutput.writeInt(42);
      dataOutput.writeChar('\n');
      dataOutput.writeUTF("Hello!");
    }

    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      DataInput dataInput = new DataInputStream(fileInputStream);
      System.out.println(dataInput.readInt());
      System.out.println(dataInput.readChar());
      System.out.println(dataInput.readUTF());
    }
  }
}
