package creational_patterns.factory_method.factory;

import creational_patterns.factory_method.developer.Developer;
import creational_patterns.factory_method.developer.DeveloperJava;

public class JavaDeveloperFactory extends DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new DeveloperJava();
    }
}
