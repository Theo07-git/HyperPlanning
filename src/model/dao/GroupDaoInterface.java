package model.dao;

import model.Group;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GroupDaoInterface {

    // Trouver le groupe
    Group findById(String id) throws SQLException, ClassNotFoundException;
    Group findByName(String name) throws SQLException, ClassNotFoundException;

    // Parcourir les groupes
    void resultSetByIdGroup(String idPromotion);
    boolean resultSetByIdGroupNext(Group group);
    void resultSetIdGroup();
    boolean resultSetIdGroupNext(Group group);
}
