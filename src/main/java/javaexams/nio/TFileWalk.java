package javaexams.nio;

import javaexams.BaseCheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TFileWalk extends BaseCheck {
    public static void main(String[] args) {
        new TFileWalk().go();
    }

    @Override
    public void go() {
        Path path = Paths.get("/home/nemavasi");
        try {
            Files.walk(path).forEach(this::p);  //depth first

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
