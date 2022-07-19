package javaexams.streamapi;

import java.util.stream.Stream;

public class StreamEmpty {

    public static void main(String[] args) {
        System.out.println(Stream.empty() == Stream.empty());
    }
}

//false