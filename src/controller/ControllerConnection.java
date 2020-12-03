package controller;

import model.User;
import java.sql.SQLException;

public class ControllerConnection {

    private User user;
    public boolean isConnect;
    public boolean idFailed;
    public String firstName;

    // Constructeur
    public ControllerConnection(User user) {
        this.user = user;
        isConnect = false;
        idFailed =false;
    }

    // Getters
    public User getUser(){
        return user;
    }
    public boolean getIsConnect() {
        return isConnect;
    }
    public boolean getIsIdFaild() {
        return idFailed;
    }

    /**
     * Vérifie la saisie des informations pour l'authentification (connexion)
     * met la variable isConnect à true si les infos sont OK
     * @param email
     * @param mdp
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void isConnected(String email, String mdp) throws SQLException, ClassNotFoundException {
        User user = new User();
        user = user.findByEmail(email);
        firstName = user.getFirstName();
        if(!email.equals("") && !mdp.equals("")) {
            if (mdp.equals(user.getPassword()) && (email.equals(user.getEmail()) || email.equals(user.getId()))) {
                isConnect = true;
            }
            else {
                idFailed = true;
            }
        }
    }

    /**
     * Retourne un entier en fonction de la permission de l'utilisateur qui vient de se connecter
     * @return
     */
    public int testPermission(){
        int i = switch (user.getPermission()) {
            case "ADMIN" -> 1;
            case "EDUCATIONAL REFERENT" -> 2;
            case "TEACHER" -> 3;
            case "STUDENT" -> 4;
            default -> 0;
        };
        return i;
    }

    /**
     * Remplit un utilisateur avec les données correspondant à l'email de l'utilisateur qui est connecté
     * @param email
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateUser(String email) throws SQLException, ClassNotFoundException {
        User user = new User();
        this.user = user.findByEmail(email);
    }
}
