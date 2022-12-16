package creational_patterns.factory_method;

import creational_patterns.factory_method.developer.Developer;
import creational_patterns.factory_method.developer.DeveloperJava;
import creational_patterns.factory_method.factory.DeveloperFactory;

public class FactoryMethod {

    public static void main(String[] args) {

        DeveloperFactory developerFactory = DeveloperFactory.createFactory(LanguageName.JAVA);
        Developer developer = developerFactory.createDeveloper();

        developer.writeCode();
    }
}
