package model.dao;

import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentDaoInterface {

    // Création/Suppression d'un élève
    void createStudent(Student student);
    void deleteStudent(String idStudent);

    // Trouve un élève
    Student findById(String id) throws SQLException, ClassNotFoundException;

    // Parcourir les élèves
    void resultSetByGroupPromotion(String idGroupPromotion);
    boolean resultSetByGroupPromotionNext(Student student);
}
