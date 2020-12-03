package model;

import model.dao.DAOFactory;
import model.dao.GroupDao;
import java.sql.SQLException;

public class Group {

    private GroupDao groupDao;
    private String idGroup = "";
    private String nameGroup = "";
    private String idPromotion = "";

    // Constructeurs
    public Group(String idGroup, String nameGroup, String idPromotion) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.idPromotion = idPromotion;
    }
    public Group() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        groupDao = DAOInstance.getGroupDao();
    }

    // Getters
    public String getIdGroup() {
        return idGroup;
    }

    // Setters
    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }
    public void setIdPromotionGroup(String idPromotion) {
        this.idPromotion = idPromotion;
    }

    /**
     * Retourne un groupe trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Group findById(String id) throws SQLException, ClassNotFoundException {
        return groupDao.findById(id);
    }

    /**
     * Retourne un groupe trouvé par son nom
     * @param name
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Group findByName(String name) throws SQLException, ClassNotFoundException {
        return groupDao.findByName(name);
    }

    /**
     * Rempli le resultSet avec la requête sql
     * (en lien avec le groupDao)
     * @param idPromotion
     */
    public void resultSetByIdGroup(String idPromotion){
        groupDao.resultSetByIdGroup(idPromotion);
    }

    /**
     * Remplie un groupe et retourne true tant qu'il y a un groupe dans le resultSet
     * (en lien avec le groupDao)
     * @return
     * @throws SQLException
     */
    public boolean resultSetByIdGroupNext() throws SQLException {
        return(groupDao.resultSetByIdGroupNext(this));
    }

    /**
     * Rempli le resultSet avec la requête sql
     * @throws SQLException
     */
    public void resultSetIdGroup() throws SQLException {
        groupDao.resultSetIdGroup();
    }

    /**
     * Remplie un groupe et retourne true tant qu'il y a un groupe dans le resultSet
     * @return
     * @throws SQLException
     */
    public boolean resultSetIdGroupNext() throws SQLException {
        return(groupDao.resultSetIdGroupNext(this));
    }

    @Override
    public String toString() {
        return "Group{" +
                "IdGroup='" + idGroup + '\'' +
                ", NameGroup='" + nameGroup + '\'' +
                ", idPromotion=" + idPromotion +
                '}';
    }
}
