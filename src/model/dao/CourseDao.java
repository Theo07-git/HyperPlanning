package model.dao;

import model.Course;

import java.sql.Connection;

public class CourseDao {
    private Connection connect = null;

    public CourseDao(Connection connect){ this.connect = connect; }
}
