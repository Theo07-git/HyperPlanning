package model.dao;

import java.sql.Connection;

public class GroupDao {
    private Connection connect = null;

    public GroupDao(Connection connect){ this.connect = connect; }
}
