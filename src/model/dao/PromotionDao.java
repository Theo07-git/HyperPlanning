package model.dao;

import model.Group;
import model.Promotion;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao implements PromotionDaoInterface{

    private final Connection connect;
    private ResultSet resultSet;

    public PromotionDao(Connection connect) {
        this.connect = connect;
    }

    public boolean create(Promotion promotion) {
        return false;
    }

    public boolean update(Promotion promotion) {
        return false;
    }

    public boolean delete(Promotion promotion) {
        return false;
    }

    public Promotion findById(String idPromotion) throws SQLException, ClassNotFoundException {
        Promotion promotion = new Promotion();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE idPromotion = " + idPromotion);
            if(result.first())
                promotion = new Promotion(
                        idPromotion,
                        result.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return promotion;
    }

    public void resultSetByIdPromotion()  {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean resultSetByIdPromotionNext(Promotion promotion){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                promotion.setIdPromotion(resultSet.getString("idPromotion"));
                promotion.setNamePromotion(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    public List<Group> getGroup(String idPromotion) throws SQLException, ClassNotFoundException {
        List<Group> groups = new ArrayList<>();
        Group group = new Group();
        boolean found = false;
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM group_promotion " +
                    "WHERE group_promotion.id_promotion =" + idPromotion);
            group = new Group(resultSet.getString("idGroupPromotion"),
                    resultSet.getString("name"), idPromotion);
            groups.add(group);
            if(resultSet.next()){
                found = true;
                group = new Group(resultSet.getString("idGroupPromotion"),
                        resultSet.getString("name"), idPromotion);
                groups.add(group);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return groups;
    }

    public int getNumberStudentsByPromotion(String idPromotion){
        int nbStudents = 0;
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM user " +
                    "JOIN student " +
                    "ON user.idUser = student.id_UserS " +
                    "JOIN group_promotion " +
                    "ON student.id_group_promotionS = group_promotion.idGroupPromotion " +
                    "JOIN promotion " +
                    "ON promotion.idPromotion = group_promotion.id_promotion " +
                    "WHERE promotion.idPromotion = '" + idPromotion + "'");
            if(resultSet.first()){
                nbStudents = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nbStudents;
    }
}
