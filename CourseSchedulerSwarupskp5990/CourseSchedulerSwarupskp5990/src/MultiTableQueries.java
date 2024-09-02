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

public class MultiTableQueries {
    // Other necessary initialization code goes here

    private static Connection getConnection() {
        return DBConnection.getConnection();
    }

    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester) {
        ArrayList<ClassDescription> classDescriptions = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement getAllClassDescriptionsStatement =
                     connection.prepareStatement("SELECT * FROM app.class WHERE semester = ?");
             PreparedStatement getOnlyDescription =
                     connection.prepareStatement("SELECT description FROM app.course WHERE courseCode = ?")) {

            getAllClassDescriptionsStatement.setString(1, semester);
            ResultSet resultSet = getAllClassDescriptionsStatement.executeQuery();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("courseCode");
                getOnlyDescription.setString(1, courseCode);
                ResultSet resultDescription = getOnlyDescription.executeQuery();

                if (resultDescription.next()) {
                    String description = resultDescription.getString("description");
                    int seats = resultSet.getInt("seats");
                    ClassDescription classDescription = new ClassDescription(courseCode, description, seats);
                    classDescriptions.add(classDescription);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return classDescriptions;
    }

    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode) {
        ArrayList<StudentEntry> scheduledStudents = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement getScheduledStudentsStatement = connection.prepareStatement(
                    "SELECT schedule.studentID, student.firstName, student.lastName " +
        "FROM app.schedule " +
        "JOIN app.student ON schedule.studentID = student.studentID " +
        "WHERE schedule.semester = ? AND schedule.courseCode = ? AND schedule.status = 'S'")) {
                

            getScheduledStudentsStatement.setString(1, semester);
            getScheduledStudentsStatement.setString(2, courseCode);

            ResultSet resultSet = getScheduledStudentsStatement.executeQuery();

            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                StudentEntry student = new StudentEntry(studentID, firstName, lastName);
                scheduledStudents.add(student);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return scheduledStudents;
    }

    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        ArrayList<StudentEntry> waitlistedStudents = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement getWaitlistedStudentsStatement = connection.prepareStatement(
                     "SELECT studentID, firstName, lastName FROM schedule sch JOIN student ON sch.studentID = "
                             + "student.studentID WHERE sch.semester = ? AND sch.courseCode = ? AND sch.status = 'W'")) {

            getWaitlistedStudentsStatement.setString(1, semester);
            getWaitlistedStudentsStatement.setString(2, courseCode);

            ResultSet resultSet = getWaitlistedStudentsStatement.executeQuery();

            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                StudentEntry student = new StudentEntry(studentID, firstName, lastName);
                waitlistedStudents.add(student);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return waitlistedStudents;
    }
}
