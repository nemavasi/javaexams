package javaexams.over;

public class Implementing {
  public static void main(String[] args) {
    Player p = (Player) new A();
    p.play();

    //Exception in thread "main" java.lang.ClassCastException: class javaexams.over.
    // B cannot be cast to class javaexams.over.Player (javaexams.over.B and javaexams.over.Player are in unnamed module of loader 'app')
    p = (Player) new B();
    p.play();
  }

}

class A implements Player{
  public void play() {
    System.out.println("A");
  }
}

class B {
  public void play() {
    System.out.println("B");
  }
}

interface Player{
  void play();
}
