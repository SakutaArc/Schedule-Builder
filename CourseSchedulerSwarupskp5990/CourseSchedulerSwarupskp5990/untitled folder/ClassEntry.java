/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class ClassEntry {

    private String semester;
    private String courseCode;
    private int seats;

    // Constructor
    public ClassEntry(String semester, String courseCode, int seats) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.seats = seats;
    }

    // Getter for Semester
    public String getSemester() {
        return semester;
    }

    // Getter for CourseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for Seats
    public int getSeats() {
        return seats;
    }
}
