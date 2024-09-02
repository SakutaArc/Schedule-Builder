/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.sql.Timestamp;

public class ScheduleEntry {

    private String semester;
    private String courseCode;
    private String studentID;
    private String status;
    private Timestamp timestamp;

    // Constructor
    public ScheduleEntry(String semester, String courseCode, String studentID, String status, Timestamp timestamp) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.studentID = studentID;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getter for Semester
    public String getSemester() {
        return semester;
    }

    // Getter for CourseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for StudentID
    public String getStudentID() {
        return studentID;
    }

    // Getter for Status
    public String getStatus() {
        return status;
    }

    // Getter for Timestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }
}

