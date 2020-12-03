package model;

import model.dao.DAOFactory;
import model.dao.SiteDao;
import java.sql.SQLException;

public class Site {

    private SiteDao siteDao;
    private String IdSite;
    private String NameSite="";

    // Construceurs
    public Site(String idSite, String nameSite) {
        IdSite = idSite;
        NameSite = nameSite;
    }
    public Site() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        siteDao = DAOInstance.getSiteDao();
    }

    // Getters
    public String getNameSite() {
        return NameSite;
    }
    public String getIdSite() {
        return IdSite;
    }

    // Setters
    public void setIdSite(String idSite) {
        IdSite = idSite;
    }
    public void setNameSite(String nameSite) {
        NameSite = nameSite;
    }

    /**
     * Retourne un site trouvé par son nom
     * @param nameSite
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Site findByName(String nameSite) throws SQLException, ClassNotFoundException {
        return siteDao.findByName(nameSite);
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec le sitDao)
     */
    public void resultSetSiteName(){
        siteDao.resultSetSiteName();
    }

    /**
     * Remplit un site et retourne true tant qu'il y a une site dans le resultSet
     * (en lien avec le sitDao)
     * @return
     */
    public boolean resultSetSiteNameNext(){
        return siteDao.resultSetSiteNameNext(this);
    }
}
