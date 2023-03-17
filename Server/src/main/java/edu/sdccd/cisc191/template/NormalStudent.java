package edu.sdccd.cisc191.template;
public class NormalStudent extends Students {
    public NormalStudent(String id, String lastName, String firstName, double gpa) {
        super(Integer.parseInt(id), lastName, firstName, gpa);
    }

    @Override
    public String sport() {
        return "none";
    }
}
