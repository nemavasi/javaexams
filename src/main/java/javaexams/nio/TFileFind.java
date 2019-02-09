package javaexams.nio;

import javaexams.BaseCheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TFileFind extends BaseCheck {
    public static void main(String[] args) {
        new TFileFind().go();
    }

    @Override
    public void go() {
        Path path = Paths.get("/home/nemavasi/Загрузки");


        try {
            Files.find(path, 20, (p, att)->p.toString().contains("u") && att.size()>999999999)
                    .forEach(this::p);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
