package javaexams.alg;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compress1("AAAABBBBBB"));
        System.out.println(compress1("ABBA"));
        System.out.println(compress1("ABBACCC"));
//
//        System.out.println(null == compress2(null));
//        System.out.println("A".equals(compress2("A")));
//        System.out.println("A3".equals(compress2("AAA")));
//        System.out.println("AB2A".equals(compress2("ABBA")));
//        System.out.println("AB2AC3".equals(compress2("ABBACCC")));

/*
        long time1, time2;

        time1 = (new Date()).getTime();
        System.out.println(compress3(STR));
        time2 = (new Date()).getTime();
        System.out.println("compress hot :: " + (time2 - time1));

        time1 = (new Date()).getTime();
        System.out.println(compress3(STR));
        time2 = (new Date()).getTime();
        System.out.println("compress3 :: " + (time2 - time1));

        time1 = (new Date()).getTime();
        System.out.println(compress2(STR));
        time2 = (new Date()).getTime();
        System.out.println("compress2 :: " + (time2 - time1));

        time1 = (new Date()).getTime();
        System.out.println(compress1(STR));
        time2 = (new Date()).getTime();
        System.out.println("compress1 :: " + (time2 - time1));

 */
    }


    private static String compress2(String str) {

        if (str == null) return null;
        if (str.length() == 1) return str;
        String result = str;
        boolean b = false;
        Pattern pattern = Pattern.compile("(\\w)(\\1+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            int n = matcher.group(2).length();
            // System.out.println(matcher.group(2));
            n++;
            result = matcher.replaceFirst("$1" + n);
            b = true;
        }
        if (b) result = compress2(result);
        return result;
    }

    private static String compress3(String str) {
        if (str == null) return null;
        if (str.length() == 1) return str;
        String result = str;
        Pattern pattern = Pattern.compile("(\\w)(\\1+)");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            int n = matcher.group(2).length();
            n++;
            result = matcher.replaceFirst("$1" + n);
            matcher = pattern.matcher(result);
        }
        return result;
    }

    //todo доделать свою реализацию
    private static String compress1(String str) {
        //fast path
        if (str == null) return null;
        if (str.length() == 1) return str;

        //
        StringBuilder result = new StringBuilder();

        Status status = Status.EAT_DIFF;

        int len = str.length();
        int cursor_dif = 1;
        int cursor_rep = 1;

        boolean endFlag = false;

        while (true) {
            if (status == Status.EAT_DIFF) {
                cursor_dif++;
                endFlag = cursor_dif == len;
                if (!endFlag) {
                    if (str.charAt(cursor_dif) == str.charAt(cursor_dif - 1)) {
                        cursor_dif = cursor_dif - 2;
                        if (cursor_dif > cursor_rep) {
                            result.append(str, cursor_rep, cursor_dif);
                        }
                        cursor_rep = cursor_dif;
                        status = Status.EAT_REP;
                        continue;
                    }
                }
                if (endFlag) {
                    cursor_dif = cursor_dif - 1;
                    if (cursor_dif > cursor_rep) {
                        result.append(str, cursor_rep, cursor_dif);
                    }
                    break;
                }
            }


            if (status == Status.EAT_REP) {
                cursor_rep++;
                endFlag = cursor_rep == len;
                if (!endFlag) {
                    if (str.charAt(cursor_rep) != str.charAt(cursor_rep - 1)) {
                        cursor_rep = cursor_rep - 1;
                        if (cursor_dif < cursor_rep) {
                            result.append(str, cursor_dif, cursor_rep);
                        }
                        cursor_dif = cursor_rep;
                        status = Status.EAT_DIFF;
                        continue;
                    }
                }
                if (endFlag) {
                    cursor_rep = cursor_rep - 1;
                    if (cursor_dif < cursor_rep) {
                        result.append(str, cursor_dif, cursor_rep);
                    }
                    break;
                }
            }
        }

        return result.toString();
    }

    enum Status {
        EAT_DIFF,
        EAT_REP
    }

    private static String STR = "AAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasdahjsdhjsaHJLKHLHLHhsjahsjhajshjahsроPPPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdas" +
            "dkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "FGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsda" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjah" +
            "sроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajs" +
            "hjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajsh" +
            "jahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsр" +
            "оPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPP" +
            "PPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPP" +
            "PPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPd" +
            "asdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjh" +
            "askjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskj" +
            "dkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsd" +
            "faerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaer" +
            "ererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaererer" +
            "GGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGG" +
            "GGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGG" +
            "GGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGG" +
            "GGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGD" +
            "HGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGG" +
            "HAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa " +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdas" +
            "dkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhas" +
            "kjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajf" +
            "sdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfs" +
            "dfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfa" +
            "erererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerere" +
            "rGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGG" +
            "GGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGG" +
            "DHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHG" +
            "GHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGH" +
            "AAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAA" +
            "BBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBC" +
            "FdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdf" +
            "ghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsj" +
            "dkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhg" +
            "dfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQ" +
            "QWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWas" +
            "GFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFF" +
            "FGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsda" +
            "sda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda h" +
            "jsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdh" +
            "jsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa H" +
            "JLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKH" +
            "LHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLH" +
            "hsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjah" +
            "sjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjah" +
            "sроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajs" +
            "hjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajsh" +
            "jahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsр" +
            "оPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPP" +
            "PPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPP" +
            "PPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPd" +
            "asdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjh" +
            "askjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskj" +
            "dkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsd" +
            "faerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaer" +
            "ererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaererer" +
            "GGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGG" +
            "GGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGG" +
            "GGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGG" +
            "GGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGD" +
            "HGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGG" +
            "HAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa " +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdas" +
            "dkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhas" +
            "kjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajf" +
            "sdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfs" +
            "dfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfa" +
            "erererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerere" +
            "rGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGG" +
            "GGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGG" +
            "DHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHG" +
            "GHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGH" +
            "AAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAA" +
            "BBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBC" +
            "FdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdf" +
            "ghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsj" +
            "dkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhg" +
            "dfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQ" +
            "QWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWas" +
            "GFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFF" +
            "FGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsda" +
            "sda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda h" +
            "jsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdh" +
            "jsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa H" +
            "JLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKH" +
            "LHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLH" +
            "hsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjah" +
            "sjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjah" +
            "sроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajs" +
            "hjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajsh" +
            "jahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsр" +
            "оPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPP" +
            "PPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPP" +
            "PPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPd" +
            "asdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjh" +
            "askjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskj" +
            "dkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsd" +
            "faerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaer" +
            "ererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaererer" +
            "GGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGG" +
            "GGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGG" +
            "GGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGG" +
            "GGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGD" +
            "HGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGG" +
            "HAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa " +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdas" +
            "dkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhas" +
            "kjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajf" +
            "sdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfs" +
            "dfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfa" +
            "erererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerere" +
            "rGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGG" +
            "GGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGG" +
            "DHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHG" +
            "GHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGH" +
            "AAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAA" +
            "BBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBC" +
            "FdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdf" +
            "ghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsj" +
            "dkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhg" +
            "dfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQ" +
            "QWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWas" +
            "GFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFF" +
            "FGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsda" +
            "sda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda h" +
            "jsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdh" +
            "jsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa H" +
            "JLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKH" +
            "LHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLH" +
            "hsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjah" +
            "sjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjah" +
            "sроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajs" +
            "hjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajsh" +
            "jahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsр" +
            "оPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPP" +
            "PPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPP" +
            "PPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPd" +
            "asdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjh" +
            "askjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskj" +
            "dkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsd" +
            "faerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaer" +
            "ererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaererer" +
            "GGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGG" +
            "GGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGG" +
            "GGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGG" +
            "GGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGD" +
            "HGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGG" +
            "HAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa " +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdas" +
            "dkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasd" +
            "kjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdk" +
            "jhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhas" +
            "kjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajf" +
            "sdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfs" +
            "dfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfa" +
            "erererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerere" +
            "rGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGG" +
            "GGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGG" +
            "DHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHG" +
            "GHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGH" +
            "AAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAA" +
            "BBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBC" +
            "FdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdf" +
            "ghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsj" +
            "dkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhg" +
            "dfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQ" +
            "QWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWas" +
            "GFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFF" +
            "FGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsda" +
            "sda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda h" +
            "jsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdh" +
            "jsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa H" +
            "JLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKH" +
            "LHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLH" +
            "hsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjah" +
            "sjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjah" +
            "sроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajs" +
            "hjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhaj" +
            "shjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajsh" +
            "jahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsр" +
            "оPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPP" +
            "PPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPP" +
            "PPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPd" +
            "asdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPda" +
            "sdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjh" +
            "askjdkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskj" +
            "dkajfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdka" +
            "jfsdfaerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsd" +
            "faerererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaer" +
            "ererGGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaererer" +
            "GGGGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGG" +
            "GGGGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGG" +
            "GGGGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGG" +
            "GGGGGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGG" +
            "GGDHGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGD" +
            "HGGHAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGG" +
            "HAAAAABBCFdfghsjdkjhgdfQQWasGFFFFGsdasda hjsdhjsa " +
            "kjhgdfQQWasGFFFFGsdasda hjsdhjsa HJLKHLHLHhsjahsjhajshjahsроPPPPPPdasdkjhaskjdkajfsdfaerererGGGGGGGGGGGDHGGH";

}
