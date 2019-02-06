package javaexams.format;

import javaexams.BaseCheck;

import java.text.NumberFormat;

public class CheckNumberFormat extends BaseCheck {
    public static void main(String[] args) {
       new CheckNumberFormat().go();
    }

    @Override
    public void go() {
        Float f = 0.3456f;
        p(f);

        NumberFormat nf = NumberFormat.getPercentInstance();
        p(nf.format(f));
    }
}
