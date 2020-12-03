package model.dao;

import model.Course;
import model.Promotion;
import model.User;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements CourseDaoInterface{

    private final Connection connect;
    private ResultSet resultSet;

    // Constructeur
    public CourseDao(Connection connect){ this.connect = connect; }

    public Course findById(String id) throws SQLException, ClassNotFoundException {
        Course course = new Course();
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course WHERE idCourse = '" + id + "'");
            if(resultSet.first()) {
                course = new Course(
                        id,
                        resultSet.getString("name"));
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

    public void resultSetByIdCourse(){
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean resultSetByIdCourseNext(Course course){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                course.setIdCourse(resultSet.getString("idCourse"));
                course.setNameCourse(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

}
