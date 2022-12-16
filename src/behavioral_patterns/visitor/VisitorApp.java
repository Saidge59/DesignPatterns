package behavioral_patterns.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        Project project = new Project();

        Developer juniorDev = new JuniorDeveloper();
        Developer seniorDev = new SeniorDeveloper();

        System.out.println("Junior is Action...");
        project.beWritten(juniorDev);

        System.out.println();
        System.out.println("Senior is Action...");
        project.beWritten(seniorDev);
    }
}

interface ProjectElement {
    void beWritten(Developer developer);
}

class Project implements ProjectElement {
    private ProjectElement[] projectElements;

    public Project() {
        this.projectElements = new ProjectElement[]{ new ProjectClass(),
                                 new Database(),
                                 new Test() };


    }

    @Override
    public void beWritten(Developer developer) {
        for (ProjectElement pe: projectElements) {
            pe.beWritten(developer);
        }
    }
}

class ProjectClass implements ProjectElement {

    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

class Database implements ProjectElement {

    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

class Test implements ProjectElement {

    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}

interface Developer {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}

class JuniorDeveloper implements Developer {

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing poor code...");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating not reliable tests...");
    }
}

class SeniorDeveloper implements Developer {

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting junior code...");
    }

    @Override
    public void create(Database database) {
        System.out.println("Fixing database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating reliable tests...");
    }
}