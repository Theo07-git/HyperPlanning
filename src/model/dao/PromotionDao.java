package model.dao;

import model.Promotion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionDao implements PromotionDaoInterface{

    private final Connection connect;
    private ResultSet resultSet;

    // Constructeur
    public PromotionDao(Connection connect) {
        this.connect = connect;
    }

    /**
     * Rempli le resultSet avec la requête sql
     */
    public void resultSetByIdPromotion() {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplie une promotion et retourne true tant qu'il y a une promotion dans le resultSet
     * @param promotion
     * @return
     */
    public boolean resultSetByIdPromotionNext(Promotion promotion) {
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

    /**
     * Retourne le nombre d'élèves dans la promotion
     * en fonction de l'id
     * @param idPromotion
     * @return
     */
    public int getNumberStudentsByPromotion(String idPromotion) {
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
