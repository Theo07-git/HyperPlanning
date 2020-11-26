package model.dao;

import model.Promotion;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean ResultSetByIdPromotionNext(Promotion promotion){
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
}
