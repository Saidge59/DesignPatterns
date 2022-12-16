package behavioral_patterns.memento;

import java.util.Date;

public class MementoApp {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Create new project version 1.0");
        project.setVersionAndDate("version 1.0");
        System.out.println(project);
        System.out.println("Save current version project...");
        gitHub.setSave(project.save());
        System.out.println();

        System.out.println("Updating project to version 1.1");
        System.out.println("Writing poor code...");
        project.setVersionAndDate("version 1.1");
        System.out.println(project);

        Thread.sleep(2000);
        System.out.println();
        System.out.println("Found a mistake in code!");
        System.out.println("Rolling back to version 1.0");
        project.load(gitHub.getSave());

        System.out.println();
        System.out.println("Project after rollback.");
        System.out.println(project);
    }
}

class Project {
    private String version;
    private Date date;

    public void setVersionAndDate(String version) {
        this.version = version;
        this.date = new Date();
    }

    public Save save() {
        return new Save(version);
    }

    public void load (Save save) {
        version = save.getVersion();
        date = save.getDate();
    }

    @Override
    public String toString() {
        return "Project{" +
                "version='" + version + '\'' +
                ", date=" + date +
                '}';
    }
}

class Save {
    private final String version;
    private final Date date;

    public Save(String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}

class GitHubRepo {
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}