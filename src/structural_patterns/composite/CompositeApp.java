package structural_patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

    public static void main(String[] args) {

        Developer developer1 = new CppDeveloper();
        Developer developer2 = new JavaDeveloper();
        Developer developer3 = new JavaDeveloper();

        Developer developer4 = new CppDeveloper();
        Developer developer5 = new JavaDeveloper();

        Team team = new Team();
        Team team1 = new Team();
        Team team2 = new Team();

        team1.addDeveloper(developer1);
        team1.addDeveloper(developer2);
        team1.addDeveloper(developer3);

        System.out.println("Team 1 ==========");
        team1.writeCode();
        System.out.println();

        team2.addDeveloper(developer4);
        team2.addDeveloper(developer5);

        System.out.println("Team 2 ==========");
        team2.writeCode();
        System.out.println();

        team.addDeveloper(team1);
        team.addDeveloper(team2);

        System.out.println("Team ==========");
        team.writeCode();
        System.out.println();
    }
}

interface Developer {
    void writeCode();
}

class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes c++ code...");
    }
}

class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}

class Team implements Developer{
    private List<Developer> developers = new ArrayList();

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void removeDeveloper(Developer developer) {
        developers.remove(developer);
    }

    @Override
    public void writeCode() {
        for (Developer developer: developers) {
            developer.writeCode();
        }
    }
}

