package creational_patterns.builder.exercise;

public class MusicBandApp {
    public static void main(String[] args) {
        MusicBand sb = DirectorBand.buildMusicBand(new SingingBand());
        System.out.println(sb);
        MusicBand db = DirectorBand.buildMusicBand(new DanceBand());
        System.out.println(db);
        MusicBand md = DirectorBand.buildMusicBand(new MixedBand());
        System.out.println(md);
    }
}

class DirectorBand {

    public static MusicBand buildMusicBand (BuilderBand builderBand) {
        builderBand.createMusicBand();
        builderBand.buildAmount();
        builderBand.buildAverageAge();
        builderBand.buildNameBand();
        return builderBand.getMusicBand();
    }
}

abstract class BuilderBand {
    MusicBand musicBand;

    public void createMusicBand () { musicBand = new MusicBand(); }
    public MusicBand getMusicBand() { return musicBand; }

    public abstract void buildAmount();
    public abstract void buildAverageAge();
    public abstract void buildNameBand();
}

class MusicBand {
    private int amount;
    private int averageAge;
    private String nameBand;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "\n\tamount=" + amount +
                ", \n\taverageAge=" + averageAge +
                ", \n\tnameBand='" + nameBand + '\'' + "\n"+
                '}';
    }
}

class SingingBand extends BuilderBand{

    @Override public void buildAmount()     { musicBand.setAmount(2); }
    @Override public void buildAverageAge() { musicBand.setAverageAge(25); }
    @Override public void buildNameBand()   { musicBand.setNameBand("New song"); }
}

class DanceBand extends BuilderBand{

    @Override public void buildAmount()     { musicBand.setAmount(5); }
    @Override public void buildAverageAge() { musicBand.setAverageAge(35); }
    @Override public void buildNameBand()   { musicBand.setNameBand("dance to the night"); }
}

class MixedBand extends BuilderBand{

    @Override public void buildAmount()     { musicBand.setAmount(10); }
    @Override public void buildAverageAge() { musicBand.setAverageAge(60); }
    @Override public void buildNameBand()   { musicBand.setNameBand("flush band"); }
}