package model.dao;

import model.Site;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface SiteDaoInterface {

    // Trouve le site
    Site findByName(String nameSite) throws SQLException, ClassNotFoundException;

    // Parcourir tous les sites
    void resultSetSiteName();
    boolean resultSetSiteNameNext(Site site);
}
