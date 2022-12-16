package behavioral_patterns.command;

public class MyCommandApp {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        lamp.on();
        lamp.off();

        System.out.println();
        Human human = new Human(new ClassOn(lamp), new ClassOff(lamp));

        human.isOn();
        human.isOff();
    }
}

interface Light {
    void state();
}

class Lamp {
    void on() {
        System.out.println("Lamp is on");
    }

    void off() {
        System.out.println("Lamp is off");
    }
}

class ClassOn implements Light {
    Lamp lamp;

    public ClassOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void state() {
        System.out.println("Load state before on!");
        lamp.on();
    }
}

class ClassOff implements Light {
    Lamp lamp;

    public ClassOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void state() {
        System.out.println("Save state before off");
        lamp.off();
    }
}

class Human {
    Light on;
    Light off;

    public Human(Light on, Light off) {
        this.on = on;
        this.off = off;
    }

    void isOn (){ on.state(); }
    void isOff (){ off.state(); }
}
