package javaexams.nulls;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class OptionalTst {
  public static void main(String[] args) {

    System.out.println(Optional.ofNullable(null));
    //System.out.println(Optional.of(null));  //падает с NPE

    OptionalTst x = new OptionalTst();
    for (int i = 0; i < 10; i++) {
      x.printOld(x.popPerson());
    }

    for (int i = 0; i < 10; i++) {
      x.popPersonOptional().ifPresent(x::printNew);
    }
  }

  public void printNew(Person person) {
    System.out.println("n Person: ");
    Optional.ofNullable(person.getName()).ifPresent(
        (x) -> System.out.println("n    name: " + x));
    Optional.ofNullable(person.getAge()).ifPresent(
        (x) -> System.out.println("n    age: " + x));
    Optional.ofNullable(person.getPassport())
        .map(Passport::getAddress)
        .map(Address::getStreet)
        .ifPresent((street) -> System.out.println("n    street: " + street));
  }

  public void printOld(Person person) {
    if (null != person) {
      System.out.println("Person: ");
      if (person.getName() != null) {
        System.out.println("    name: " + person.getName());
      }
      if (person.getAge() != null) {
        System.out.println("    age: " + person.getAge());
      }
      if (person.getPassport() != null && person.getPassport().getAddress() != null && person.getPassport().getAddress().getStreet() != null) {
        System.out.println("    street: " + person.getPassport().getAddress().getStreet());
      }
    }
  }

  private Person popPerson() {
    float m = new Random().nextFloat();
    if (m < 0.3) {
      return new Person(UUID.randomUUID().toString(), new Random().nextInt(), new Passport(new Address(UUID.randomUUID().toString())));
    } else if (m < 0.5) {
      return new Person(UUID.randomUUID().toString(), null, null);
    } else if (m < 0.7) {
      return new Person(null, new Random().nextInt(), new Passport(new Address(UUID.randomUUID().toString())));
    } else {
      return null;
    }
  }

  private Optional<Person> popPersonOptional() {
    return Optional.ofNullable(popPerson());
  }

  public static class Person {

    private String name;
    private Integer age;
    private Passport passport;

    public Person(String name, Integer age, Passport passport) {
      this.name = name;
      this.age = age;
      this.passport = passport;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    public Passport getPassport() {
      return passport;
    }

    public void setPassport(Passport passport) {
      this.passport = passport;
    }
  }

  public static class Passport {
    private Address address;

    public Passport(Address address) {
      this.address = address;
    }

    public Address getAddress() {
      return address;
    }

    public void setAddress(Address address) {
      this.address = address;
    }
  }

  public static class Address {
    public Address(String street) {
      this.street = street;
    }

    private String street;

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }
  }

}
