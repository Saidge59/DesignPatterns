package structural_patterns.facade;

public class FacadeApp {
    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.copy();
    }
}

class Facade {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFroDvd(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }

    void off(){
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data;

    public void load(){
        data = true;
    }

    public void unload(){
        data = false;
    }

    public boolean hasData(){
        return data;
    }
}

class HDD {
    void copyFroDvd(DVDRom dvdRom) {
        if(dvdRom.hasData()) {
            System.out.println("Copy data from disk");
        } else {
            System.out.println("Put in disk with data");
        }
    }
}