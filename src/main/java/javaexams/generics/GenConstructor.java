package javaexams.generics;

public class GenConstructor {

    interface Rankable{
        int getRank();
    }

    class Person{
        int rank;
        String name;

        public Person(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        public <T extends Rankable> Person(String name, T rankable){
            this.name = name;
            this.rank = rankable.getRank();
        }
    }

}
