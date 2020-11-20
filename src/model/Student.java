package model;

import model.User;

import java.sql.SQLException;

public class Student extends User {

    private int StudentNumber;

    public Student(String id, String email, String password, String lastName, String firstName, String permission, int studentNumber) throws SQLException, ClassNotFoundException {
        super(id, email, password, lastName, firstName, permission);
        StudentNumber = studentNumber;
    }

    public Student() throws SQLException, ClassNotFoundException {
        super();
    }

    public void addCourse() {
        // appelle methode dans TeacherDAO

    }

    public void removeCourse() {

    }
}
