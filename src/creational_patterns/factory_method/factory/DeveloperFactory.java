package creational_patterns.factory_method.factory;

import creational_patterns.factory_method.LanguageName;
import creational_patterns.factory_method.developer.Developer;

public abstract class DeveloperFactory {

    public abstract Developer createDeveloper();

    public static DeveloperFactory createFactory(LanguageName name) {

        switch (name) {
            case JAVA:
                return new JavaDeveloperFactory();
            case Cpp :
                return new CppDeveloperFactory();
            case PHP :
                return new PhpDeveloperFactory();
            default:
                throw new RuntimeException(name + " is unknown factory");
        }
    }
}
