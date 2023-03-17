package edu.sdccd.cisc191.template;
public class AthleteStudent extends Students {
    private String sport;
    public AthleteStudent(String id, String lastName, String firstName, String sport, double gpa) {
        super(Integer.parseInt(id), lastName, firstName, gpa);
        this.sport = sport;
    }
    @Override
    public String sport() {
        return this.sport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
