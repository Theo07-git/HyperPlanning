package model.dao;

import java.sql.Connection;

public class SessionDao {
    private Connection connect = null;

    public SessionDao(Connection connect){ this.connect = connect; }
}
