package model;

import model.Group;

import java.util.ArrayList;
import java.util.List;

public class Promotion {


    protected String IdPromotion="";
    private String NamePromotion="";
    private List<Group>GroupPromtion;

    public Promotion(String idPromotion, String namePromotion) {
        IdPromotion = idPromotion;
        NamePromotion = namePromotion;
        GroupPromtion = new ArrayList<Group>();
    }

    public Promotion(){}

    public String getIdPromotion() {
        return IdPromotion;
    }

    public void setIdPromotion(String idPromotion) {
        IdPromotion = idPromotion;
    }

    public String getNamePromotion() {
        return NamePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        NamePromotion = namePromotion;
    }

    public void addGroup(){

        // appelle methode PromotionDAO
    }

    public void removeGroup(){

        // appelle methode PromotionDAO
    }
}

