package model;

import java.sql.SQLException;

public class Student extends User{

    public Student(String id, String email, String password, String lastName, String firstName, String permission, int studentNumber) throws SQLException, ClassNotFoundException {
        super(id, email, password, lastName, firstName, permission);
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
