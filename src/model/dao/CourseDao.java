package model.dao;

import model.Course;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao implements CourseDaoInterface{
    private final Connection connect;

    public CourseDao(Connection connect){ this.connect = connect; }

    public Course findById(String id) throws SQLException, ClassNotFoundException {
        Course course = new Course();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course WHERE idCourse = '" + id + "'");
            if(result.first()) {
                course = new Course(
                        id,
                        result.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    public Course findByName(String name) throws SQLException, ClassNotFoundException {
        Course course = new Course();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course WHERE name = '" + name + "'");
            if(result.first()) {
                course = new Course(
                        result.getString("idCourse"),
                        name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }
}
