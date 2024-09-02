
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduledStudentCount;
    private static PreparedStatement getScheduleByStudent; 
    private static ResultSet resultSet;


    public static void addScheduleEntry(ScheduleEntry entry) {
            connection = DBConnection.getConnection();

        try {
            

            addScheduleEntry = connection.prepareStatement(
                    "INSERT INTO app.schedule (semester, studentid, coursecode, status, timestamp) VALUES (?, ?, ?, ?, ?)");

            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTimestamp());

            addScheduleEntry.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // Close the PreparedStatement in a finally block to ensure it's closed even if an exception occurs
            if (addScheduleEntry != null) {
                try {
                    addScheduleEntry.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
         public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID) 
    {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedule = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select * from app.schedule where SEMESTER = ? and STUDENTID = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            resultSet = getScheduleByStudent.executeQuery();
            
            
            while(resultSet.next())
            {
                String currstudentID = resultSet.getString("STUDENTID");
                String currsemester = resultSet.getString("SEMESTER");
                String courseCode = resultSet.getString("COURSECODE");
                String status = resultSet.getString("STATUS");
                Timestamp timestamp = resultSet.getTimestamp("TIMESTAMP");
                
                ScheduleEntry currentSchedule = new ScheduleEntry(currsemester, courseCode, currstudentID, status, timestamp); 
                schedule.add(currentSchedule);
            }
                    
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return schedule;
        
    }
         public static int getScheduledStudentCount(String currentSemester, String courseCode)   
    {
        connection = DBConnection.getConnection();
        int count = 0;
        try
        {
            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from app.schedule where SEMESTER = ? and COURSECODE = ?" );
            getScheduledStudentCount.setString(1, currentSemester);
            getScheduledStudentCount.setString(2, courseCode);
            
            resultSet = getScheduledStudentCount.executeQuery();
            
            while(resultSet.next())
            {
                count = resultSet.getInt(1);
            }
                    
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return count;
    }
         
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
    connection = DBConnection.getConnection();
    ArrayList<ScheduleEntry> waitlistedStudents = new ArrayList<>();
    try {
        // Adjust the SQL query based on your database schema
        PreparedStatement waitlistedStudentsStatement = connection.prepareStatement(
            "SELECT * FROM app.schedule WHERE semester = ? AND courseCode = ? AND status = 'W'"
        );

        waitlistedStudentsStatement.setString(1, semester);
        waitlistedStudentsStatement.setString(2, courseCode);

        ResultSet resultSet = waitlistedStudentsStatement.executeQuery();

        while (resultSet.next()) {
            // Assuming the existence of the constructor in ScheduleEntry class
            ScheduleEntry waitlistedStudent = new ScheduleEntry(
                resultSet.getString("SEMESTER"),
                resultSet.getString("COURSECODE"),
                resultSet.getString("STUDENTID"),
                resultSet.getString("STATUS"),
                resultSet.getTimestamp("TIMESTAMP")
            );
            waitlistedStudents.add(waitlistedStudent);
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
    return waitlistedStudents;
}
    
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            // Adjust the SQL query based on your database schema
            PreparedStatement dropStudentScheduleStatement = connection.prepareStatement(
                "DELETE FROM app.schedule WHERE semester = ? AND studentID = ? AND courseCode = ?"
            );

            dropStudentScheduleStatement.setString(1, semester);
            dropStudentScheduleStatement.setString(2, studentID);
            dropStudentScheduleStatement.setString(3, courseCode);

            dropStudentScheduleStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            // Adjust the SQL query based on your database schema
            PreparedStatement dropScheduleStatement = connection.prepareStatement(
                "DELETE FROM app.schedule WHERE semester = ? AND courseCode = ?"
            );

            dropScheduleStatement.setString(1, semester);
            dropScheduleStatement.setString(2, courseCode);

            dropScheduleStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public static void updateScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        try {
            // Adjust the SQL query based on your database schema
            PreparedStatement updateScheduleStatement = connection.prepareStatement(
                "UPDATE app.schedule SET status = ? WHERE semester = ? AND courseCode = ? AND studentID = ?"
            );

            // Set the values based on your ScheduleEntry class structure
            updateScheduleStatement.setString(1, entry.getStatus());
            updateScheduleStatement.setString(2, entry.getSemester());
            updateScheduleStatement.setString(3, entry.getCourseCode());
            updateScheduleStatement.setString(4, entry.getStudentID());

            updateScheduleStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
