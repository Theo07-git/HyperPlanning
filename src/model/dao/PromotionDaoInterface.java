package model.dao;

import model.Group;
import model.Promotion;
import java.sql.SQLException;
import java.util.List;

public interface PromotionDaoInterface {

    // Parourir les promotions
    void resultSetByIdPromotion();
    boolean resultSetByIdPromotionNext(Promotion promotion);

    // Donne le nombre d'élèves dans la promo
    int getNumberStudentsByPromotion(String idPromotion);
}
