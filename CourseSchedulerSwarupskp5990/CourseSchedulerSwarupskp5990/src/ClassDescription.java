/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class ClassDescription {

    private String courseCode;
    private String description;
    private int seats;

    // Constructor
    public ClassDescription(String courseCode, String description, int seats) {
        this.courseCode = courseCode;
        this.description = description;
        this.seats = seats;
    }

    // Getter for CourseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }

    // Getter for Seats
    public int getSeats() {
        return seats;
    }
}
