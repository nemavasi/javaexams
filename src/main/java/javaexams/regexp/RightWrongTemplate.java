package javaexams.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RightWrongTemplate {
  public static void main(String[] args) {
    String rightRequest = ".*right.*";
    String wrongRequest = ".*wrong.*";;

    Pattern patternRight = Pattern.compile(".*right.*");
    Pattern patternWrong = Pattern.compile(".*wrong.*");

    System.out.println(patternRight.matcher("It's all right").matches());
    System.out.println(patternWrong.matcher("It's all right").matches());

    System.out.println(patternRight.matcher("It's all Right").matches());

    Pattern patternRight2 = Pattern.compile(".*right.*", Pattern.CASE_INSENSITIVE);
    System.out.println(patternRight2.matcher("It's all Right").matches());

  }
}
