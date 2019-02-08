package javaexams.nio;

import javaexams.BaseCheck;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TPath extends BaseCheck {
    public static void main(String[] args) {
        new TPath().go();
    }

    @Override
    public void go() {
        Path path = Paths.get("/home/nemavasi/Загрузки/..");
        p(path);  ///home/nemavasi/Загрузки/..
        p(path.getRoot()); // /
        try {
            p(path.toRealPath()); // /home/nemavasi

            p(path.getParent()); ///home/nemavasi/Загрузки

            p(path.toRealPath().getParent());  // /home
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
