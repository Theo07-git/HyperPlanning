package model;

import model.Course;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class Teacher extends User {

    private List<Course> myCourses;


    public Teacher(String id, String name, String lastName, String email, String password, String permission, List<Course> myCourses) throws SQLException, ClassNotFoundException {
        super(id, name, lastName, email, password, permission);
        this.myCourses = myCourses;
    }

    public Teacher(String id, String name, String lastName, String email, String password, String permission) throws SQLException, ClassNotFoundException {
        super(id, name, lastName, email, password, permission);
    }

    public void addCourse() {
    // appelle methode dans TeacherDAO
    }


    public void removeCourse() {
        // appelle methode dans TeacherDAO
    }
}
