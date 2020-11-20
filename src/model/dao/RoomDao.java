package model.dao;

import java.sql.Connection;

public class RoomDao {
    private Connection connect = null;

    public RoomDao(Connection connect){ this.connect = connect; }
}
