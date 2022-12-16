package behavioral_patterns.state;

public class StateApp {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();
        developer.setActivity(activity);

        for(int i=0; i<10; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}

interface Activity {
    void justDoIt();
}

class Sleeping implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
class Reading implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Reading...");
    }
}
class Training implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
class Coding implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Coding...");
    }
}

class Developer {

    Activity activity;

    void changeActivity() {
        if(activity instanceof Sleeping) {
            setActivity(new Reading());
        } else if(activity instanceof Reading) {
            setActivity(new Training());
        } else if(activity instanceof Training) {
            setActivity(new Coding());
        } else if(activity instanceof Coding) {
            setActivity(new Sleeping());
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    void justDoIt(){
        activity.justDoIt();
    }
}