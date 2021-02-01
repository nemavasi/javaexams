package javaexams.streamapi;

import static java.util.Optional.ofNullable;

public class OfNullable {
  public static void main(String[] args) {

      PersDTO persDTO1 = new PersDTO();
      persDTO1.setNm("Jack");
      persDTO1.setSnm("Noob");

      Pers p1 =  ofNullable(persDTO1)
          .map(dto -> new Pers(dto.getNm(), dto.getSnm()))
          .orElse(null);

      PersDTO persDTO2 = null;
      Pers p2 =  ofNullable(persDTO2)
          .map(dto -> new Pers(dto.getNm(), dto.getSnm()))
          .orElse(null);

      PersDTO persDTO3 = new PersDTO();
      Pers p3 =  ofNullable(persDTO3)
          .map(dto -> new Pers(dto.getNm(), dto.getSnm()))
          .orElse(null);

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
  }


  static class PersDTO {
    private String nm;
    private String snm;

    public PersDTO() {
    }

    public String getNm() {
      return nm;
    }

    public void setNm(String nm) {
      this.nm = nm;
    }

    public String getSnm() {
      return snm;
    }

    public void setSnm(String snm) {
      this.snm = snm;
    }
  }

  static class Pers {
    private String name;
    private String surname;

    public Pers(String name, String surname) {
      this.name = name;
      this.surname = surname;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getSurname() {
      return surname;
    }

    public void setSurname(String surname) {
      this.surname = surname;
    }

    @Override
    public String toString() {
      return name + surname;
    }
  }

}
