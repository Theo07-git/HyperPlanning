package controller;

import model.Group;
import model.Promotion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdmin {

    private List<Promotion> promotions;
    private List<Group> groupsPromotion;

    public ControllerAdmin(){
        promotions = new ArrayList<>();
    }

    public ArrayList<String> getAllIdPromotion() throws SQLException, ClassNotFoundException {

        Promotion promotion = new Promotion();

        promotion.resultSetByIdPromotion();
        promotions.add(promotion);

        ArrayList<String> allIdPromotion = new ArrayList<>();

        while(promotion.resultSetByIdPromotionNext()){
            promotions.add(promotion);
            assert allIdPromotion != null;
            allIdPromotion.add(promotion.getIdPromotion());
        }

        System.out.println(promotions);

        /*//ArrayList<String> allIdPromotion = null;
        for (int i = 0; i < promotions.size(); i++) {
            assert allIdPromotion != null;
            allIdPromotion.set(i, promotions.get(i).getIdPromotion());
        }*/

        return allIdPromotion;
    }
}
