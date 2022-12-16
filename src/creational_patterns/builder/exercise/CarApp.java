package creational_patterns.builder.exercise;

public class CarApp {

    public static void main(String[] args) {
        Car car = DirectorCar.buildCar(new SpecialCar());
        System.out.println(car);
    }
}

class DirectorCar {
    public static Car buildCar(CarBuilder carBuilder){
        carBuilder.createCar();
        carBuilder.buildMark();
        carBuilder.buildSpeed();
        return carBuilder.getCar();
    }
}

abstract class CarBuilder {
    protected Car car;

    public void createCar() { this.car = new Car(); }
    public Car getCar() { return car; }

    public abstract void buildMark();
    public abstract void buildSpeed();
}

class SerialCar extends CarBuilder {

    @Override public void buildMark() { car.setMark("BMW"); }
    @Override public void buildSpeed() { car.setSpeed(250); }
}

class SpecialCar extends CarBuilder {

    @Override public void buildMark() { car.setMark("TOYOTA"); }
    @Override public void buildSpeed() { car.setSpeed(320); }
}

class Car {
    private String mark;
    private int speed;

    public void setMark(String mark) { this.mark = mark; }
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public String toString() {
        return "Car{" +
                "\n\tmark='" + mark + '\'' +
                ", \n\tspeed=" + speed + "\n" +
                '}';
    }
}
