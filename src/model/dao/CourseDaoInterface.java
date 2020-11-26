package model.dao;

import model.Course;

import java.sql.SQLException;

public interface CourseDaoInterface{
    Course findById(String id) throws SQLException, ClassNotFoundException;

    Course findByName(String name) throws SQLException, ClassNotFoundException;
}
