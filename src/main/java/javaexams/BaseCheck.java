package javaexams;

public abstract class BaseCheck {

    public abstract void go();

    public void p(String s){
        System.out.println(s);
    }

    public void p(Float f){
        p(f.toString());
    }
}
