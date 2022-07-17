package javaexams.templates.creational.prototype;

public class Car {

    private String producer;
    private String name;
    private String model;
    private Integer mileage;
    private Integer year;
    private String motor;
    private String number;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car copyIt() {
        Car car = new Car();
        car.setProducer(producer);
        car.setName(name);
        car.setMotor(motor);
        car.setModel(model);
        return car;
    }

    @Override
    public String toString() {
        return "producer='" + producer + '\'' +
            ", name='" + name + '\'' +
            ", model='" + model + '\'' +
            ", mileage=" + mileage +
            ", year=" + year +
            ", motor='" + motor + '\'' +
            ", number='" + number + '\'';
    }
}
