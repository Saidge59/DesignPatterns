package creational_patterns.factory_method.exercise;

public class FigureTetrisApp {

    public static void main(String[] args) {

        FactoryFigure factoryFigure = new FactoryFigure(new RandomFigure().getFigure());
        Character character = factoryFigure.getFigure();
        System.out.println(character);

        FactoryFigure factoryFigure2 = new FactoryFigure(new Figure_L());
        Character character2 = factoryFigure2.getFigure();
        System.out.println(character2);
    }
}

class FactoryFigure {
    Figure figure;

    public FactoryFigure(Figure figure) {
        this.figure = figure;
    }

    public Character getFigure() {
        return figure.getCharacter();
    }
}

class RandomFigure {

    public Figure getFigure () {

        int random = (int) ( Math.random() * 7);

        switch (random) {
            case 0: return new Figure_O();
            case 1: return new Figure_J();
            case 2: return new Figure_L();
            case 3: return new Figure_S();
            case 4: return new Figure_T();
            case 5: return new Figure_Z();
            case 6: return new Figure_I();
            default:
                throw new RuntimeException("not such");
        }
    }
}

abstract class Figure {
    Character character;

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}

class Figure_O extends Figure{
    Character character = 'O';
    public Character getCharacter() {
        return character;
    }
}
class Figure_J extends Figure{
    Character character = 'J';
    public Character getCharacter() {
        return character;
    }
}
class Figure_L extends Figure{
    Character character = 'L';
    public Character getCharacter() {
        return character;
    }
}
class Figure_S extends Figure{
    Character character = 'S';
    public Character getCharacter() {
        return character;
    }
}
class Figure_T extends Figure{
    Character character = 'T';
    public Character getCharacter() {
        return character;
    }
}
class Figure_Z extends Figure{
    Character character = 'Z';
    public Character getCharacter() {
        return character;
    }
}
class Figure_I extends Figure{
    Character character = 'I';
    public Character getCharacter() {
        return character;
    }
}

