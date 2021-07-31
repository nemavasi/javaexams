package javaexams.chars;

public class CharactersClassTest {

    public static void main(String[] args) {
        System.out.println(Character.isDigit('6'));
        System.out.println(Character.isDigit('☺')); //false

        System.out.println(Character.isAlphabetic('z'));
        System.out.println(Character.isAlphabetic('☺')); //false

        System.out.println(Character.getName('☺')); //WHITE SMILING FACE

        System.out.println(Character.isLetter('☺')); //false

        System.out.println(Character.isValidCodePoint('☺')); //true

        System.out.println('\u2083'); //₃
        System.out.println(Character.getName('\u2083')); //SUBSCRIPT THREE
    }
}
