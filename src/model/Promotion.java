package model;

import model.dao.DAOFactory;
import model.dao.PromotionDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private PromotionDao promotionDao;
    private String idPromotion ="";
    private String namePromotion ="";
    private List<Group> GroupPromtion;

    public Promotion() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        promotionDao = DAOInstance.getPromotionDao();
    }

    public Promotion(String idPromotion, String namePromotion) throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        promotionDao = DAOInstance.getPromotionDao();
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
        GroupPromtion = new ArrayList<Group>();
    }

    public String getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(String idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public void resultSetByIdPromotion(){
        promotionDao.resultSetByIdPromotion();
    }

    public boolean resultSetByIdPromotionNext(){
        return(promotionDao.resultSetByIdPromotionNext(this));
    }

    public List<Group> getGroup(String idPromotion) throws SQLException, ClassNotFoundException {
        return(promotionDao.getGroup(idPromotion));
    }

    public ArrayList<Promotion> getAllPromotions() throws SQLException, ClassNotFoundException {
        ArrayList<Promotion> promotions = new ArrayList<>();
        Promotion promotion = new Promotion();
        promotion.resultSetByIdPromotion();
        promotions.add(promotion);
        while(promotion.resultSetByIdPromotionNext()){
            promotions.add(new Promotion(promotion.getIdPromotion(), promotion.getNamePromotion()));
        }
        return promotions;
    }

    public int getNumberStudentsByPromotion() throws SQLException {
        return promotionDao.getNumberStudentsByPromotion(this.getIdPromotion());
    }

    @Override
    public String toString(){
        return "Promotion{" +
                "Id='" + idPromotion + '\'' +
                ", Name='" + namePromotion + '\'' +
                "}";
    }
}

