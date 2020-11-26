package model.dao;

import model.Student;

import java.sql.SQLException;

public interface StudentDaoInterface {

    boolean create(Student student);

    boolean update(Student student);

    boolean delete(Student student);

    Student findById(String id) throws SQLException, ClassNotFoundException;
}
