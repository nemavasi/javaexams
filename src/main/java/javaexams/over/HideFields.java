package javaexams.over;

public class HideFields {
  public static void main(String[] args) {
    X x = new X();
    System.out.println(x.health);
    x.printHealth();
  }
}


class Z{
  protected int health = 7;

  void printHealth(){
    System.out.println("SUPER!!");
  }
}

class X extends Z{
  protected int health = 8;

  void printHealth(){
    super.printHealth();
    System.out.println("this.health=" + this.health);
    System.out.println("super.health=" + super.health);
  }
}