package behavioral_patterns.chain_of_responsibility;

public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK!", Priority.ROUTINE);
        System.out.println();
        reportNotifier.notifyManager("Something went wrong!", Priority.IMPORTANT);
        System.out.println();
        reportNotifier.notifyManager("We've have a problem here!!!", Priority.ASAP);
    }
}

class Priority {
    public static final int ROUTINE = 1;
    public static final int IMPORTANT = 2;
    public static final int ASAP = 3;
}

abstract class Notifier {

    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String massage, int level) {
        if(level >= priority) {
            write(massage);
        }
        if(nextNotifier != null) {
            nextNotifier.notifyManager(massage, level);
        }
    }

    abstract void write(String massage);
}

class SimpleReportNotifier extends Notifier {

    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    void write(String massage) {
        System.out.println("Notifying using sample report: " + massage);
    }
}

class EmailNotifier extends Notifier {

    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    void write(String massage) {
        System.out.println("Sanding email: " + massage);
    }
}

class SMSNotifier extends Notifier {

    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    void write(String massage) {
        System.out.println("Sanding sms to massage: " + massage);
    }
}

