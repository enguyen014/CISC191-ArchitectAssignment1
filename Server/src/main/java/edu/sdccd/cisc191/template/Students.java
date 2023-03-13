package edu.sdccd.cisc191.template;
public abstract class Students {
    private String id;
    private String lastName;
    private String firstName;
    private double gpa;

    public Students(int id, String lastName, String firstName, double gpa) {
        this.id = String.valueOf(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;

    }

    public abstract String sport();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
