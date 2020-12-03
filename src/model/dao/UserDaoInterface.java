package model.dao;

import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDaoInterface {

    // Trouver l'utilisateur
    User findById(String id) throws SQLException, ClassNotFoundException;
    User findByEmail(String email) throws SQLException, ClassNotFoundException;

    // Parcourir tous les utilisateurs
    void ResultSetAll();
    boolean ResultSetAllNext(User user);

    // Met à jour le mot de passe
    User updatePassword(User user);

    // Vérifie si l'utilisateur existe
    boolean alreadyExist(String id) throws SQLException;
}
