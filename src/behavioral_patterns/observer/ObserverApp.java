package behavioral_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        JavaDeveloperJobSite javaDeveloperJobSite = new JavaDeveloperJobSite();

        javaDeveloperJobSite.addVacancy("First java vacancy");
        javaDeveloperJobSite.addVacancy("Second java vacancy");

        Observer firstSubscriber = new Subscriber("Denis Shesyernyak");
        Observer secondSubscriber = new Subscriber("Marina Chubenko");

        javaDeveloperJobSite.addObserver(firstSubscriber);
        javaDeveloperJobSite.addObserver(secondSubscriber);

        javaDeveloperJobSite.addVacancy("Third java vacancy");
        javaDeveloperJobSite.removeVacancy("First java vacancy");
    }
}

interface Observer {
    void handleEvent(List<String> vacancies);
}

interface Observed {
    void addObserver (Observer observer);
    void removeObserver (Observer observer);
    void notifyObservers ();
}

class Subscriber implements Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Deer " + name + "\nWe have some change in vacancies " + vacancies +
                "\n=========================================================\n");
    }
}

class JavaDeveloperJobSite implements Observed {

    private List<String> vacancies = new ArrayList<>();
    private List<Observer> subscribes = new ArrayList<>();


    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribes.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribes.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: subscribes) {
            observer.handleEvent(vacancies);
        }
    }
}