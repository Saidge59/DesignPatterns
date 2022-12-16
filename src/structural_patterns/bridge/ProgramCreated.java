package structural_patterns.bridge;

public class ProgramCreated {

    public static void main(String[] args) {
        Program [] programs = {
                new BankSystem(new JavaDeveloper()),
                new StockExchange(new CppDeveloper()),
                new Website(new PhpDeveloper())};

        for(Program program: programs){
            System.out.println("==============");
            program.startDevelop();
        }
    }
}

interface Developer {
    void writeCode();
}

class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}

class PhpDeveloper implements Developer {
    @Override
    public void writeCode() { System.out.println("PHP developer writes php code..."); }
}

class CppDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("C++ developer writes c++ code...");
    }
}

abstract class Program {

    protected Developer developer;

    public Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developerProgram ();

    protected void startDevelop() {
        developerProgram();
        developer.writeCode();
    }
}

class Website extends Program {
    public Website(Developer developer) {
        super(developer);
    }

    @Override
    public void developerProgram() {
        System.out.println("Website development in progress");
    }

}

class StockExchange extends Program {
    public StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developerProgram() {
        System.out.println("Stock Exchange development in progress");
    }
}

class BankSystem extends Program {
    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developerProgram() {
        System.out.println("Bank System development in progress");
    }
}

