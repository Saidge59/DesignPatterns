package structural_patterns.decorator;

public class DecoratorApp {

    public static void main(String[] args) {
        PrintInterface printInterface = new RightBracketDecorator( new LeftBracketDecorator( new QuotesDecorator(new Printer("Hello"))));
        printInterface.print();

        PrintInterface printInterface2 = new BeforeDecorator("\n[\"", new AfterDecorator("\"]", new Printer("World")));
        printInterface2.print();
    }
}

interface PrintInterface { void print(); }

class Printer implements PrintInterface {
    String value;
    public Printer(String value) { this.value = value; }

    @Override
    public void print() { System.out.print(value); }
}

class BeforeDecorator implements PrintInterface{

    PrintInterface component;
    String before;

    public BeforeDecorator(String before, PrintInterface component) {
        this.before = before;
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print(before);
        component.print();
    }
}

class AfterDecorator implements PrintInterface{

    PrintInterface component;
    String after;

    public AfterDecorator(String after, PrintInterface component) {
        this.after = after;
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print(after);
    }
}

class QuotesDecorator implements PrintInterface{
    PrintInterface component;
    public QuotesDecorator(PrintInterface component) { this.component = component; }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator implements PrintInterface {
    PrintInterface component;
    public LeftBracketDecorator(PrintInterface component) { this.component = component; }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator implements PrintInterface {
    PrintInterface component;
    public RightBracketDecorator(PrintInterface component) { this.component = component; }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}