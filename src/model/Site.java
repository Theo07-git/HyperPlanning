package model;

import model.dao.DAOFactory;
import model.dao.SiteDao;

import java.sql.SQLException;
import java.util.List;

public class Site {

    private SiteDao siteDao;
    private String IdSite;
    private String NameSite="";

    public Site(String idSite, String nameSite) {
        IdSite = idSite;
        NameSite = nameSite;
    }

    public Site() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        siteDao = DAOInstance.getSiteDao();
    }

    public String getNameSite() {
        return NameSite;
    }

    public String getIdSite() {
        return IdSite;
    }

    public void setIdSite(String idSite) {
        IdSite = idSite;
    }

    public void setNameSite(String nameSite) {
        NameSite = nameSite;
    }

    public void resultSetSiteName(){
        siteDao.resultSetSiteName();
    }

    public boolean resultSetSiteNameNext(){
        return siteDao.resultSetSiteNameNext(this);
    }

    public Site findByName(String nameSite) throws SQLException, ClassNotFoundException{
        return siteDao.findByName(nameSite);
    }
}
