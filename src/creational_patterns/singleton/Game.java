package creational_patterns.singleton;

public class Game {

    private static Game instance = null;

    public static Game getGame() {

        if(instance == null) {
            instance = new Game();
        }

        return instance;
    }

    public void print() {
        System.out.println("Instance Game");
    }
}
