package model;

import model.dao.DAOFactory;
import model.dao.GroupDao;

import java.sql.SQLException;
import java.util.List;

public class Group {

    private GroupDao groupDao;
    private String idGroup = "";
    private String nameGroup = "";
    private String idPromotion = "";
    private List<Course>GroupCours;
    private List<Student>GroupStudent;

    public Group(GroupDao groupDao, String idGroup, String nameGroup, String idPromotion, List<Course> groupCours, List<Student> groupStudent) {
        this.groupDao = groupDao;
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.idPromotion = idPromotion;
        GroupCours = groupCours;
        GroupStudent = groupStudent;
    }

    public Group(String idGroup, String nameGroup, String idPromotion) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.idPromotion = idPromotion;
    }

    public Group() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        groupDao = DAOInstance.getGroupDao();
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public void setIdPromotionGroup(String idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Group findById(String id) throws SQLException, ClassNotFoundException {
        return groupDao.findById(id);
    }

    public Group findByName(String name) throws SQLException, ClassNotFoundException {
        return groupDao.findByName(name);
    }

    public void resultSetByIdGroup(String idPromotion){
        groupDao.resultSetByIdGroup(idPromotion);
    }

    public boolean resultSetByIdGroupNext(){
        return(groupDao.resultSetByIdGroupNext(this));
    }

    public List<Student> getGroupStudent() {
        return GroupStudent;
    }

    @Override
    public String toString() {
        return "Group{" +
                "IdGroup='" + idGroup + '\'' +
                ", NameGroup='" + nameGroup + '\'' +
                ", idPromotion=" + idPromotion +
                '}';
    }

    public List<Course> getGroupCours() {
        return GroupCours;
    }
}
