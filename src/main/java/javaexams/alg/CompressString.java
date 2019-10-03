package javaexams.alg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compress2("AAAABBBBBB"));
        System.out.println(compress2("ABBA"));
        System.out.println(compress2("ABBACCC"));

        System.out.println(null == compress2(null));
        System.out.println("A".equals(compress2("A")));
        System.out.println("A3".equals(compress2("AAA")));
        System.out.println("AB2A".equals(compress2("ABBA")));
        System.out.println("AB2AC3".equals(compress2("ABBACCC")));

        System.out.println(compress2("AAAAABBCFdfghsjdkjhgdfQQW "));
    }

    private static String compress2(String str){
        if (str == null) return null;
        if (str.length() == 1) return str;
        String result = str;
        boolean b = false;
        Pattern pattern = Pattern.compile("(\\w)(\\1+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            int n = matcher.group(2).length();
            n++;
            result = matcher.replaceFirst("$1" + n);
            b = true;
        }
        if (b) result = compress2(result);
        return result;
    }

    private static String compress1(String str) {
        if (str == null) return null;
        if (str.length() == 1) return str;

        StringBuilder result = new StringBuilder(str.charAt(0));

        int counter = 1;
        char lastc = (char) -1; //str.charAt(0);
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (lastc == c) {
                counter++;
                if (i != str.length() - 1) {
                    continue;
                }
            }
            String delta="";
            if (counter > 1) {
                delta = String.valueOf(counter);
            }
            if (i != str.length() - 1) {
                delta += String.valueOf(c);
            } else {
                if (c==lastc) {
                    delta = String.valueOf(counter);
                }
            }
            result.append(delta);
            lastc = c;
            counter = 1;
        }

        return result.toString();
    }
}
