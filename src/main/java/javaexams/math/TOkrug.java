package javaexams.math;

class Tack {
    static short s = 42;
    public Tack(short ss) {
        new Tack();
        s *= ss;
       // s = s * ss;   --wrong - result is int type

    }
    public Tack() { ; }
}
public class TOkrug extends Tack {

    public TOkrug(int s) { System.out.println(s + 1); }  //hiding

    public static void main(String[] args) {
        TOkrug b = new TOkrug(3);  //4
    }
}