package javaexams.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvetEncodingFromFile {

    public static void main(String[] args) throws IOException {


        Path path = Paths.get("/home/nick/test.txt");

        Stream<String> lines = Files.lines(path, Charset.forName("Windows-1251"));
     //   String data = Files.readAllLines(path, Charset.forName("Windows-1251")).get(0);
        String data = lines.collect(Collectors.joining("\n"));
        System.out.println(data);
        lines.close();

    }
}
