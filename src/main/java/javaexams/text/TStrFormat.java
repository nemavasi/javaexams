package javaexams.text;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TStrFormat {
    public static void main(String[] args)  {

        String str="Hello {0} {1}";
        System.out.println(MessageFormat.format(str,"Ivanov","Ivan"));

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date utilDate= null;
        try {
            utilDate = sdf.parse("2012-05-11 11-23-45");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(utilDate);
    }
}
