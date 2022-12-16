package creational_patterns.prototype;

public class VersionControleRunner {

    public static void main(String[] args) {
        Project proj1 = new Project(1, "SuperProject", "SourceCode");

        ProjectFactory projFact = new ProjectFactory(proj1);
        Project proj2 = projFact.cloneProject();

        Project proj3 = proj2.copy();
        proj3.setProjectName("NewName");
        proj3.setId(3);

        System.out.println(proj1);
        System.out.println(proj2);
        System.out.println(proj3);
    }
}
