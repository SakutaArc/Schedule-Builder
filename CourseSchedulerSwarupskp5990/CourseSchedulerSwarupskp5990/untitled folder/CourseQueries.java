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

public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourseCodes;
    private static ResultSet resultSet;
    private static PreparedStatement getCourseSeats;

    public static void addCourse(CourseEntry course) {
        connection = DBConnection.getConnection();
        try {
            addCourse = connection.prepareStatement("insert into app.course (courseCode, description) values (?, ?)");
            addCourse.setString(1, course.getCourseCode());
            addCourse.setString(2, course.getDescription());
            addCourse.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<String> getAllCourseCodes() {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<>();
        try {
            getAllCourseCodes = connection.prepareStatement("select courseCode from app.course order by courseCode");
            resultSet = getAllCourseCodes.executeQuery();

            while (resultSet.next()) {
                courseCodes.add(resultSet.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
        public static int getCourseSeats(String semester, String courseCode)  
    {
        connection = DBConnection.getConnection();
        int seats = 0;
        try
        {
            getCourseSeats = connection.prepareStatement("select seats from app.class where semester = ? and coursecode = ?");
            getCourseSeats.setString(1, semester);
            getCourseSeats.setString(2, courseCode);
            resultSet = getCourseSeats.executeQuery();
            
            while (resultSet.next()) {
                seats = resultSet.getInt(1);
            }
            
            return seats;
                    
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return seats;
    }
}
