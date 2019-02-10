package javaexams.text;

import java.text.MessageFormat;

public class TStrFormat {
    public static void main(String[] args) {

        String str="Hello {0} {1}";
        System.out.println(MessageFormat.format(str,"Ivanov","Ivan"));
    }
}
