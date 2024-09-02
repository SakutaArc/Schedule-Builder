/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudentStatement;
    private static PreparedStatement getAllStudentsStatement;
    private static PreparedStatement dropStudentStatement ;
    // Other necessary initialization code goes here

    public static void addStudent(StudentEntry student) {
        connection = DBConnection.getConnection();
        try {
            addStudentStatement = connection.prepareStatement("INSERT INTO app.student (studentID, firstName, lastName) VALUES (?, ?, ?)");
            addStudentStatement.setString(1, student.getStudentID());
            addStudentStatement.setString(2, student.getFirstName());
            addStudentStatement.setString(3, student.getLastName());

            addStudentStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<StudentEntry> getAllStudents() {
        ArrayList<StudentEntry> students = new ArrayList<>();
        connection = DBConnection.getConnection();
        try {
            getAllStudentsStatement = connection.prepareStatement("SELECT * FROM app.student");

            ResultSet resultSet = getAllStudentsStatement.executeQuery();

            while (resultSet.next()) {
                String studentID = resultSet.getString("StudentID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");

                StudentEntry student = new StudentEntry(studentID, firstName, lastName);
                students.add(student);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return students;
    }
    public static StudentEntry getStudent(String studentID) {
        connection = DBConnection.getConnection();
        StudentEntry student = null;
        try {
            // Adjust the SQL query based on your database schema
            PreparedStatement getStudentStatement = connection.prepareStatement(
                "SELECT * FROM app.student WHERE StudentID = ?"
            );

            getStudentStatement.setString(1, studentID);

            ResultSet resultSet = getStudentStatement.executeQuery();

            if (resultSet.next()) {
                // Assuming the existence of the constructor in StudentEntry class
                student = new StudentEntry(
                    resultSet.getString("StudentID"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName")
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return student;
}
    public static void dropStudent(String studentID) {
    connection = DBConnection.getConnection();
    try {
        // Adjust the SQL query based on your database schema
            dropStudentStatement= connection.prepareStatement("DELETE FROM app.student WHERE StudentID = ?");
        

        dropStudentStatement.setString(1, studentID);
        dropStudentStatement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
}
}
