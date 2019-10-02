package javaexams.alg;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compress1("AAAABBBBBB"));
        System.out.println(compress1("ABBA"));
        System.out.println(compress1("ABBACCC"));

        System.out.println(null == compress1(null));
        System.out.println("A".equals(compress1("A")));
        System.out.println("A3".equals(compress1("AAA")));
        System.out.println("AB2A".equals(compress1("ABBA")));
        System.out.println("AB2AC3".equals(compress1("ABBACCC")));

    }


    private static String compress1(String str) {
        if (str == null) return null;
        if (str.length() == 1) return str;

        StringBuilder result = new StringBuilder(str.charAt(0));

        int counter = 1;
        char lastc = str.charAt(0);
        char c;
        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            if (lastc == c) {
                counter++;
                if (i != str.length() - 1) {
                    continue;
                }
            }
            String delta = String.valueOf(lastc);
            if (counter > 1) {
                delta += counter;
            }
            result.append(delta);
            lastc = c;
            counter = 1;
        }

        return result.toString();
    }
}
