package edu.sdccd.cisc191.template;
public class normalStudent extends Students {
    public normalStudent(String id, String lastName, String firstName, double gpa) {
        super(Integer.parseInt(id), lastName, firstName, gpa);
    }

    @Override
    public String sport() {
        return "none";
    }
}
