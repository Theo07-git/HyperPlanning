package Controller;

import java.util.List;

public class Promotion {


    protected String IdPromotion="";
    private String NamePromotion="";
    private List<Group>GroupPromtion;

    public Promotion(String idPromotion, String namePromotion, List<Group> groupPromtion) {
        IdPromotion = idPromotion;
        NamePromotion = namePromotion;
        GroupPromtion = groupPromtion;
    }

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

