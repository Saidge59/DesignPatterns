package creational_patterns.singleton;

public class Singleton {

    public static void main(String[] args) {

        Game game = Game.getGame();
        Game game2 = Game.getGame();

        game.print();
        game2.print();

        System.out.println(game.hashCode());
        System.out.println(game2.hashCode());
        System.out.println(game == game2);
    }
}
