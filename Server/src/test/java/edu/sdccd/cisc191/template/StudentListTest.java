package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StudentListTest {
    @Test
    public void testNormalStudent() {
        normalStudent student = new normalStudent("123", "Doe", "John", 3.5);
        assertEquals("123", student.getId());
        assertEquals("Doe", student.getLastName());
        assertEquals("John", student.getFirstName());
        assertEquals(3.5, student.getGpa(), 0.001);
        assertEquals("none", student.sport());
    }
    @Test
    public void testAthleteStudent() {
        AthleteStudent student = new AthleteStudent("456", "Smith", "Jane", "Basketball", 3.9);
        assertEquals("456", student.getId());
        assertEquals("Smith", student.getLastName());
        assertEquals("Jane", student.getFirstName());
        assertEquals(3.9, student.getGpa(), 0.001);
        assertEquals("Basketball", student.sport());

        // Test the setter for the sport field
        student.setSport("Soccer");
        assertEquals("Soccer", student.getSport());
    }

}


