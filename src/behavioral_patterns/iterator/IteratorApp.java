package behavioral_patterns.iterator;

public class IteratorApp {
    public static void main(String[] args) {
        String[] skills = {"Java core", "XML", "Hibernate", "Maven"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Denis", skills);

        System.out.println("Java developer: " + javaDeveloper.getName());
        System.out.print("Developer skills: ");
        MyIterator iterator = javaDeveloper.getIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
    }
}

interface MyIterator<T> {
    boolean hasNext();

    T next();
}

interface MyCollection {
    MyIterator getIterator();
}

class JavaDeveloper implements MyCollection {
    String name;
    String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    @Override
    public MyIterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements MyIterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < skills.length;
        }

        @Override
        public String next() {
            return skills[index++];
        }
    }
}