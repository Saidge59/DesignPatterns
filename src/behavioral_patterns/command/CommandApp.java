package behavioral_patterns.command;

public class CommandApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));

        user.startCommand();
        user.stopCommand();
        user.resetCommand();
    }
}

class Computer {
    void start() {
        System.out.println("Start computer...");
    }
    void stop() {
        System.out.println("Stop computer...");
    }
    void reset() {
        System.out.println("Reset computer...");
    }
}

class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startCommand () { start.execute(); }
    void stopCommand () { stop.execute(); }
    void resetCommand () { reset.execute(); }
}

interface Command {
    void execute();
}

class StartCommand implements Command {
    Computer computer;

    public StartCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() { computer.start(); }
}

class StopCommand implements Command {
    Computer computer;

    public StopCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() { computer.stop(); }
}

class ResetCommand implements Command {
    Computer computer;

    public ResetCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() { computer.reset(); }
}