package behavioral_patterns.template_method;

public class TemplateMethodApp {
    public static void main(String[] args) {
        TemplateMethod wp = new WelcomePage();
        TemplateMethod np = new NewsPage();

        wp.doSomething();
        System.out.println("\n===========\n");
        np.doSomething();
    }
}

abstract class TemplateMethod {
    void doSomething(){
        System.out.println("Header");
        print();
        System.out.println("Footer");
    }
    abstract void print();
}

class WelcomePage extends TemplateMethod {

    @Override
    void print() {
        System.out.println("Welcome page");
    }
}

class NewsPage extends TemplateMethod {

    @Override
    void print() {
        System.out.println("News page");
    }
}