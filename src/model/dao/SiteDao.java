package model.dao;

import model.Site;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteDao {

    private final Connection connect;
    ResultSet resultSet;

    // Constructeur
    public SiteDao(Connection connect){ this.connect = connect; }

    // Trouve le site
    public Site findByName(String nameSite) throws SQLException, ClassNotFoundException {
        Site site = new Site();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE name = '" + nameSite + "'");
            if(result.first())
                site= new Site(
                        result.getString("idSite"),
                        nameSite);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return site;
    }

    // Parcourir tous les sites
    public void resultSetSiteName() {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean resultSetSiteNameNext(Site site) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                site.setIdSite(resultSet.getString("idSite"));
                site.setNameSite(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
}
