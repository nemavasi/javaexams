package javaexams.exceptions;

public class TstTryFinally {
  public static void main(String[] args) {
    try {
      throw new StackOverflowError();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } catch (Throwable e) {
      throw new RuntimeException(e);
    } finally {
      System.out.println("asdas");
    }

  }
}
