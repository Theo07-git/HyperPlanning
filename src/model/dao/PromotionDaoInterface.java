package model.dao;

import model.Group;
import model.Promotion;
import java.sql.SQLException;
import java.util.List;

public interface PromotionDaoInterface {

    // Trouver la promotion
    Promotion findById(String idPromotion) throws SQLException, ClassNotFoundException;

    // Parourir les promotions
    void resultSetByIdPromotion();
    boolean resultSetByIdPromotionNext(Promotion promotion);

    // Donne les groupes de la promo
    List<Group> getGroup(String idPromotion);

    // Donne le nombre d'élèves dans la promo
    int getNumberStudentsByPromotion(String idPromotion);
}
