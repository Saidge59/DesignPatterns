package structural_patterns.adapter;

public class DatabaseRunner {

    public static void main(String[] args) {
        
        Database database = new AdapterJavaToDatabase();

        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}

interface Database {
    void insert();
    void update();
    void select();
    void remove();
}

class AdapterJavaToDatabase extends JavaApplication implements Database {
    @Override public void insert() { saveObject(); }
    @Override public void update() { updateObject(); }
    @Override public void select() { loadObject(); }
    @Override public void remove() { deleteObject(); }
}

class JavaApplication {
    public void saveObject(){ System.out.println("Save object"); }
    public void updateObject(){ System.out.println("Update object"); }
    public void loadObject(){  System.out.println("Load object"); }
    public void deleteObject(){
        System.out.println("Delete object");
    }
}

