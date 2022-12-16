package creational_patterns.builder.exercise;

public class ComplexLunchApp {
    public static void main(String[] args) {
        ComplexLunch scl = DirectorCL.createComplexLunch(new StandardComplexLunch());
        System.out.println(scl);
        ComplexLunch acl = DirectorCL.createComplexLunch(new AdditionalComplexLunch());
        System.out.println(acl);
    }
}

class DirectorCL {
    public static ComplexLunch createComplexLunch(BuilderComplexLunch builderComplexLunch) {
        builderComplexLunch.createComplexLunch();
        builderComplexLunch.buildSoup();
        builderComplexLunch.buildMainDish();
        builderComplexLunch.buildDessert();
        builderComplexLunch.buildBeverage();
        builderComplexLunch.buildSalad();
        builderComplexLunch.buildSeafoods();
        return builderComplexLunch.getComplexLunch();
    }
}

abstract class BuilderComplexLunch {
    ComplexLunch complexLunch;

    public void createComplexLunch() { this.complexLunch = new ComplexLunch(); }
    public ComplexLunch getComplexLunch() { return complexLunch; }

    public abstract void buildSoup();
    public abstract void buildMainDish();
    public abstract void buildDessert();
    public abstract void buildBeverage();
    public abstract void buildSalad();
    public abstract void buildSeafoods();
}

class ComplexLunch {
    protected String soup;
    protected String mainDish;
    protected String dessert;
    protected String beverage;
    protected String salad;
    protected String seafoods;

    public void setSoup(String soup) { this.soup = soup; }
    public void setMainDish(String mainDish) { this.mainDish = mainDish; }
    public void setDessert(String dessert) { this.dessert = dessert; }
    public void setBeverage(String beverage) { this.beverage = beverage; }
    public void setSalad(String salad) { this.salad = salad; }
    public void setSeafoods(String seafoods) { this.seafoods = seafoods; }

    public String getSoup() { return soup; }
    public String getMainDish() { return mainDish; }
    public String getDessert() { return dessert; }
    public String getBeverage() { return beverage; }
    public String getSalad() { return salad; }
    public String getSeafoods() { return seafoods; }

    @Override
    public String toString() {
        return "ComplexLunch{" +
                "soup='" + soup + '\'' +
                ", mainDish='" + mainDish + '\'' +
                ", dessert='" + dessert + '\'' +
                ", beverage='" + beverage + '\'' +
                (salad.equals("") ? "" : "salad='" + salad + '\'') +
                (salad.equals("") ? "" : ", seafoods='" + seafoods + '\'') +
                '}';
    }
}

class StandardComplexLunch extends BuilderComplexLunch{
    @Override public void buildSoup() { complexLunch.setSoup("борщ"); }
    @Override public void buildMainDish() { complexLunch.setMainDish("мясной гуляш"); }
    @Override public void buildDessert() { complexLunch.setDessert("мороженое"); }
    @Override public void buildBeverage() { complexLunch.setBeverage("апельсиновый сок"); }
    @Override public void buildSalad() { complexLunch.setSalad(""); }
    @Override public void buildSeafoods() {complexLunch.setSeafoods(""); }
}

class AdditionalComplexLunch extends BuilderComplexLunch{
    @Override public void buildSoup() { complexLunch.setSoup("суп грибной"); }
    @Override public void buildMainDish() { complexLunch.setMainDish("жаркое"); }
    @Override public void buildDessert() { complexLunch.setDessert("эклер"); }
    @Override public void buildBeverage() { complexLunch.setBeverage("гранатовый сок"); }
    @Override public void buildSalad() { complexLunch.setSalad("ананасовый"); }
    @Override public void buildSeafoods() {complexLunch.setSeafoods("кальмар"); }
}
