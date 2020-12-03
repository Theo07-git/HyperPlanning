package model.dao;

import model.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao implements GroupDaoInterface{

    private final Connection connect;
    private ResultSet resultSet;

    // Constructeur
    public GroupDao(Connection connect){ this.connect = connect; }

    // Trouver le groupe
    public Group findById(String id) throws SQLException, ClassNotFoundException {
        Group group = new Group();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM group_promotion WHERE idGroupPromotion = '" + id + "'");
            if(result.first()) {
                group = new Group(
                        id,
                        result.getString("name"),
                        result.getString("id_promotion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return group;
    }
    public Group findByName(String name) throws SQLException, ClassNotFoundException {
        Group group = new Group();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM group_promotion WHERE name = '" + name + "'");
            if(result.first()) {
                group = new Group(
                        result.getString("idGroupPromotion"),
                        name,
                        result.getString("id_promotion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return group;
    }

    // Parcourir tous les groupes
    public void resultSetByIdGroup(String idPromotion) {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM group_promotion WHERE id_promotion = '" + idPromotion + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean resultSetByIdGroupNext(Group group) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                group.setIdGroup(resultSet.getString("idGroupPromotion"));
                group.setNameGroup(resultSet.getString("name"));
                group.setIdPromotionGroup(resultSet.getString("id_promotion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
    public void resultSetIdGroup() {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM group_promotion");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean resultSetIdGroupNext(Group group) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                group.setIdGroup(resultSet.getString("idGroupPromotion"));
                group.setNameGroup(resultSet.getString("name"));
                group.setIdPromotionGroup(resultSet.getString("id_promotion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
}
