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

    // Constructeur
    public Promotion() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        promotionDao = DAOInstance.getPromotionDao();
    }
    public Promotion(String idPromotion, String namePromotion) throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        promotionDao = DAOInstance.getPromotionDao();
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
    }

    // Getters
    public String getIdPromotion() {
        return idPromotion;
    }
    public String getNamePromotion() {
        return namePromotion;
    }

    // Setters
    public void setIdPromotion(String idPromotion) {
        this.idPromotion = idPromotion;
    }
    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    /**
     * Rempli le resultSet avec la requête sql
     * (en lien avec la promotionDao)
     */
    public void resultSetByIdPromotion(){
        promotionDao.resultSetByIdPromotion();
    }

    /**
     * Remplie une promotion et retourne true tant qu'il y a une promotion dans le resultSet
     * (en lien avec la promotionDao)
     * @return
     */
    public boolean resultSetByIdPromotionNext(){
        return(promotionDao.resultSetByIdPromotionNext(this));
    }

    /**
     * Retourne une liste de promotion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Retourne le nombre d'élèves dans la promotion
     * @return
     */
    public int getNumberStudentsByPromotion() {
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

