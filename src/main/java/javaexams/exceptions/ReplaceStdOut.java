package javaexams.exceptions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ReplaceStdOut {

    public static void main(String[] args) {
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, false, StandardCharsets.UTF_8);
        System.setOut(ps);
        try {
            System.out.println("Привет, мир!");
        } finally {
            System.setOut(oldPrintStream);
        }

        System.out.println("baos: " + baos.toString(StandardCharsets.UTF_8));
    }
}
