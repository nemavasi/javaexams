package javaexams.format;

import javaexams.BaseCheck;

public class CheckNumberFormat extends BaseCheck {
    public static void main(String[] args) {
       new CheckNumberFormat().go();
    }

    @Override
    public void go() {
        Float f = 345.6f;
        p(f);
    }
}
