package javaexams.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrettyPrintMap {
  public static void main(String[] args) {
    Map<String, String[]> map = new HashMap<String, String[]>();
    map.put("asd", new String[]{"sdsd", "dfdfd"});
    System.out.println(new PrettyPrintingMap(map));
  }
}


class PrettyPrintingMap{
  private Map<String, String[]> map;

  public PrettyPrintingMap(Map<String, String[]> map) {
    this.map = map;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Iterator<Map.Entry<String, String[]>> iter = map.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, String[]> entry = iter.next();
      sb.append(entry.getKey());
      sb.append('=').append('"');
      sb.append(Arrays.toString(entry.getValue()));
      sb.append('"');
      if (iter.hasNext()) {
        sb.append(',').append(' ');
      }
    }
    return sb.toString();
  }
}