package creational_patterns.factory_method.factory;

import creational_patterns.factory_method.developer.Developer;
import creational_patterns.factory_method.developer.DeveloperPhp;

public class PhpDeveloperFactory extends DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new DeveloperPhp();
    }
}
