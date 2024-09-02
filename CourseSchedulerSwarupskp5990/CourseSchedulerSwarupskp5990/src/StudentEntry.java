/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class StudentEntry {

    private String studentID;
    private String firstName;
    private String lastName;

    // Constructor
    public StudentEntry(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter for StudentID
    public String getStudentID() {
        return studentID;
    }

    // Getter for FirstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for LastName
    public String getLastName() {
        return lastName;
    }
}

