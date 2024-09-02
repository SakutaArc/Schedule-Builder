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
    private static Connection connection;
    private static PreparedStatement getAllClassDescriptionsStatement;
    private static PreparedStatement getOnlyDescription;

    // Other necessary initialization code goes here

    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester) {
        ArrayList<ClassDescription> classDescriptions = new ArrayList<>();
        connection = DBConnection.getConnection();
        try {
            getAllClassDescriptionsStatement = connection.prepareStatement("SELECT * FROM app.class WHERE semester = ?");
            getOnlyDescription = connection.prepareStatement("SELECT description FROM app.course WHERE courseCode = ?");
            getAllClassDescriptionsStatement.setString(1, semester);

            ResultSet resultSet = getAllClassDescriptionsStatement.executeQuery();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("courseCode");

                // Execute the second query to get the description based on the current courseCode
                getOnlyDescription.setString(1, courseCode);
                ResultSet resultDescription = getOnlyDescription.executeQuery();

                // Check if there is a result for the description query
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
}

