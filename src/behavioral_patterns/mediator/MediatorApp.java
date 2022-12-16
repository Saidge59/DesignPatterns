package behavioral_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();

        User admin = new Admin("Admin", chat);
        User user1 = new Admin("User1", chat);
        User user2 = new Admin("User2", chat);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMassage("Hello, I'm user1");
        user2.sendMassage("Hello, I'm user2");
        admin.sendMassage("Hello, I'm admin");
    }
}

interface Chat {
    void sendMassage(String massage, User user);
}

interface User {
    void sendMassage(String massage);
    void getMassage(String massage);
}

class Admin implements User{
    String name;
    Chat chat;

    public Admin(String name, Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMassage(String massage) {
        chat.sendMassage(massage, this);
    }

    @Override
    public void getMassage(String massage) {
        System.out.println(this.name + " receiving massage: " + massage + ".");
    }
}

class SimpleUser implements User{
    String name;
    Chat chat;

    public SimpleUser(String name, Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMassage(String massage) {
        chat.sendMassage(massage, this);
    }

    @Override
    public void getMassage(String massage) {
        System.out.println(this.name + " receiving massage: " + massage + ".");
    }
}

class SimpleTextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser (User user) {
        users.add(user);
    }

    @Override
    public void sendMassage(String massage, User user) {
        for(User u: users) {
            if(u != user) {
                u.getMassage(massage);
            }
        }

        admin.getMassage(massage);
    }
}