package Model;

import Controller.Promotion;
import Controller.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionDao extends DAO<Promotion> {
    public PromotionDao(Connection conn) {
        super(conn);
    }

    public boolean create(Promotion obj) {
        return false;
    }

    public boolean update(Promotion obj) {
        return false;
    }

    public boolean delete(Promotion obj) {
        return false;
    }

    public Promotion find(String idPromotion) {
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
}
