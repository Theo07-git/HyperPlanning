package Model;

import Controller.Student;
import Controller.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends DAO<Student>{
    public StudentDao(Connection connection){
        super(connection);
    }

    public boolean create(Student obj){
        return false;
    }

    public boolean update(Student obj) {
        return false;
    }

    public boolean delete(Student obj) {
        return false;
    }

    public Student find(String id) {
        Student student = new Student();
        return student;
    }
}
