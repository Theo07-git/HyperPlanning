package model.dao;

import java.sql.Connection;

public class TeacherDao {
    private Connection connect = null;

    public TeacherDao(Connection connect){ this.connect = connect; }
}
