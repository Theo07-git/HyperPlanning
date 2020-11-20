package model.dao;

import java.sql.Connection;

public class SiteDao {
    private Connection connect = null;

    public SiteDao(Connection connect){ this.connect = connect; }
}
