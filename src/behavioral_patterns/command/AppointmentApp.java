package behavioral_patterns.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class AppointmentApp {

    private static Calendar dateCreator = Calendar.getInstance();

    public static void main(String[] args) {

        System.out.println("Example for the Command pattern");
        System.out.println();
        System.out.println("This sample will use a command class called");
        System.out.println("ChangeLocationCommand to update the location");
        System.out.println("of an Appointment object.");
        System.out.println("The ChangeLocationCommand has the additional");
        System.out.println("ability to undo and redo commands, so it can");
        System.out.println("set the location back to its original value,");
        System.out.println(" if desired.");
        System.out.println();

        System.out.println("Creating an Appointment for use in the demo");
        Contact [] people = { new Contactlmpl() , new Contactlmpl() };
        Appointment appointment = new Appointment("Java Twister Semi-Finals",
        people, new Locationlmpl(""), createDate(2001, 10, 31, 14, 30),
        createDate(2001, 10, 31, 14, 31));

        System.out.println("Creating the ChangeLocationCommand");
        ChangeLocationCommand cmd = new ChangeLocationCommand();
        cmd.setAppointment(appointment) ;

        System.out.println("Creating the GUI");
        CommandGui application = new CommandGui(cmd);
        application.setAppointment(appointment);
        cmd.setLocationEditor(application);
        application.createGui();
    }

     public static Date createDate(int year, int month, int day, int hour,int minute) {
        dateCreator.set(year, month, day, hour, minute);
        return dateCreator.getTime();
     }
}

interface Location extends Serializable{
    String getLocation();
    void setLocation(String newLocation);
}

class Locationlmpl implements Location{
    private String location;

    public Locationlmpl() { }
    public Locationlmpl(String newLocation) {
        location = newLocation;
    }

    public String getLocation() { return location; }
    public void setLocation(String newLocation) { location = newLocation; }
    public String toString() { return location; }
}

class ChangeLocationCommand implements UndoableCommand {
    private Appointment appointment;
    private Location oldLocation;
    private Location newLocation;
    private LocationEditor editor;

    public Appointment getAppointment() { return appointment; }

    public void setAppointment(Appointment appointment) { this.appointment = appointment; }
    public void setLocationEditor(LocationEditor locationEditor) { editor = locationEditor; }

    public void executed () {
        oldLocation = appointment.getLocation ();
        newLocation = editor.getNewLocation ();
        appointment.setLocation(newLocation);
    }

    public void undo() {
        appointment.setLocation(oldLocation);
    }

    public void redo () {
        appointment.setLocation(newLocation);
    }
}

class Appointment {
    private String reason;
    private Contact[] contacts;
    private Location location;
    private Date startDate;
    private Date endDate;

    public Appointment(String reason, Contact[] contacts, Location location, Date startDate, Date endDate) {
        this.reason = reason;
        this.contacts = contacts;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReason(){ return reason; }
    public Contact[] getContacts(){ return contacts; }
    public Location getLocation(){ return location; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate(){ return endDate; }

    public void setLocation(Location location) { this.location = location; }

    public String toString() {
        return "Appointment:" + "\n Reason: " + reason +
        "\n Location: " + location + "\n Start; " +
        startDate + "\n End: " + "\n";
    }
}

interface UndoableCommand extends Commandos {
    void undo ();
    void redo ();
}

interface Commandos {
    void executed ();
}

class CommandGui implements ActionListener, LocationEditor {
    private JFrame mainFrame;
    private JTextArea display;
    private JTextField updatedLocation;
    private JButton update,undo,redo,exit;
    private JPanel controlPanel,displayPanel,editorPanel;
    private UndoableCommand command;
    private Appointment appointment;

    public CommandGui(UndoableCommand newCommand) {
        command = newCommand;
    }

    public void setAppointment(Appointment newAppointment) {
        appointment = newAppointment;
    }

    public void createGui() {
        mainFrame = new JFrame("Command Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        editorPanel= new JPanel();
        editorPanel.add(new JLabel("Location"));
        updatedLocation = new JTextField(20);
        editorPanel.add(updatedLocation) ;
        content.add(editorPanel);

        displayPanel= new JPanel();
        display = new JTextArea(10, 40);
        display.setEditable(false);
        displayPanel.add(display);
        content.add(displayPanel);

        controlPanel = new JPanel();
        update = new JButton("Update Location");
        undo = new JButton("Undo Location");
        redo = new JButton("Redo Location");
        exit = new JButton("Exit");
        controlPanel.add(update);
        controlPanel.add(undo);
        controlPanel.add(redo);
        controlPanel.add(exit);
        content.add(controlPanel);

        update.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);
        exit.addActionListener(this);

        refreshDisplay();
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object originator = evt.getSource();
        if (originator == update) {
            executeCommand();
        }
        if (originator == undo) {
            undoCommand();
        }
        if (originator == redo) {
            redoCommand();
        } else if (originator == exit) {
            exitApplication();
        }
    }

    private class WindowCloseManager extends WindowAdapter {
        public void windowClosing(WindowEvent evt) {
            exitApplication();
        }
    }

    public Location getNewLocation(){
        return new Locationlmpl(updatedLocation.getText());
    }

    private void executeCommand () {
        command.executed();
        refreshDisplay();
    }

    private void undoCommand() {
    command.undo();
    refreshDisplay();
    }

    private void redoCommand() {
    command.redo();
    refreshDisplay();
    }

    private void refreshDisplay() {
        display.setText(appointment.toString());
    }

    private void exitApplication() {
        System.exit(0);
    }
}

interface LocationEditor {
    Location getNewLocation();
}

interface Contact extends Serializable {
    String SPACE = " ";
    String getFirstName();
    String getLastName();
    String getTitle();
    String getOrganization();

    void setFirstName(String newFirstName);
    void setLastName(String newLastName);
    void setTitle(String newTitle);
    void setOrganization(String newOrganization);
}

class Contactlmpl implements Contact {
    private String firstName;
    private String lastName;
    private String title;
    private String organization;
    public static final String EOL_STRING =
    System.getProperty("line.separator");

    public Contactlmpl(){ }
    public Contactlmpl(String newFirstName, String newLastName, String newTitle, String newOrganization) {
        firstName = newFirstName;
        lastName = newLastName;
        title = newTitle;
        organization = newOrganization;
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getTitle() { return title; }
    public String getOrganization(){ return organization; }

    public void setFirstName(String newFirstName){ firstName = newFirstName; }
    public void setLastName(String newLastName){ lastName = newLastName; }
    public void setTitle(String newTitle){ title = newTitle; }
    public void setOrganization(String newOrganization){ organization = newOrganization; }

    public String toString(){
        return firstName + " " + lastName;
    }
}