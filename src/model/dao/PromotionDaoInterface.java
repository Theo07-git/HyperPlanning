package model.dao;

import model.Promotion;

import java.sql.SQLException;

public interface PromotionDaoInterface {
    boolean create(Promotion promotion);

    boolean update(Promotion promotion);

    boolean delete(Promotion promotion);

    Promotion findById(String idPromotion) throws SQLException, ClassNotFoundException;
}
