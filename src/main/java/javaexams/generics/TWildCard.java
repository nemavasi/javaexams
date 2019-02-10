package javaexams.generics;

import javaexams.BaseCheck;

import java.util.ArrayList;
import java.util.List;

public class TWildCard extends BaseCheck {

    public static void main(String[] args) {
        new TWildCard().go();
    }

    @Override
    public void go() {
        List<? super String> list = new ArrayList<>();
        list.add("dfhdfgdf");
        p(list);

        List<? extends String> list2 = new ArrayList<>();
        //list2.add("dfhdfgdf"); //wrong
        p(list2);
    }
}
