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


public class ClassQueries {

    private static Connection connection;
    private static PreparedStatement addClassStatement;
    private static PreparedStatement getAllCourseCodesStatement;
    private static PreparedStatement getClassSeatsStatement;

    // Add a ClassEntry to the database
    public static void addClass(ClassEntry classEntry) {
        connection = DBConnection.getConnection();
        try {
            // Adjust the SQL query based on your database schema
            addClassStatement = connection.prepareStatement("INSERT INTO app.class (semester, courseCode, seats) VALUES (?, ?, ?)");

            // Set the values based on your ClassEntry class structure
            addClassStatement.setString(1, classEntry.getSemester());
            addClassStatement.setString(2, classEntry.getCourseCode());
            addClassStatement.setInt(3, classEntry.getSeats());

            addClassStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    // Get all course codes for a given semester
    public static ArrayList<String> getAllCourseCodes(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<>();
        try {
            // Adjust the SQL query based on your database schema
            getAllCourseCodesStatement = connection.prepareStatement("SELECT courseCode FROM app.class WHERE semester = ?");

            getAllCourseCodesStatement.setString(1, semester);

            ResultSet resultSet = getAllCourseCodesStatement.executeQuery();

            while (resultSet.next()) {
                courseCodes.add(resultSet.getString("CourseCode"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }

    // Get available seats for a class in a given semester and course code
    public static int getClassSeats(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        int seats = -1; // Default value, adjust as needed
        try {
            // Adjust the SQL query based on your database schema
            getClassSeatsStatement = connection.prepareStatement("SELECT seats FROM app.class WHERE semester = ? AND courseCode = ?");

            getClassSeatsStatement.setString(1, semester);
            getClassSeatsStatement.setString(2, courseCode);

            ResultSet resultSet = getClassSeatsStatement.executeQuery();

            if (resultSet.next()) {
                seats = resultSet.getInt("Seats");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return seats;
    }
    public static void dropClass(String semester, String courseCode) {
    connection = DBConnection.getConnection();
    try {
        // Adjust the SQL query based on your database schema
        PreparedStatement dropClassStatement = connection.prepareStatement(
            "DELETE FROM app.class WHERE semester = ? AND courseCode = ?"
        );

        // Set the values based on your ClassEntry class structure
        dropClassStatement.setString(1, semester);
        dropClassStatement.setString(2, courseCode);

        dropClassStatement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
}
}

