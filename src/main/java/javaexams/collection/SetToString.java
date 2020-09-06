package javaexams.collection;

import java.util.HashSet;
import java.util.Set;

public class SetToString {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("asdfsdf");
    set.add("qqqsdfsdfdf");

    System.out.println(String.join(";", set));

  }
}
