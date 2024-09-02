/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class CourseEntry {

    private String courseCode;
    private String description;

    // Constructor
    public CourseEntry(String courseCode, String description) {
        this.courseCode = courseCode;
        this.description = description;
    }

    // Getter for CourseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }
}

