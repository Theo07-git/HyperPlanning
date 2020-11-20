package model.dao;

import java.sql.Connection;

public class CourseDao implements CourseDaoInterface{
    private Connection connect = null;

    public CourseDao(Connection connect){ this.connect = connect; }
}
