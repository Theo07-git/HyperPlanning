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

    // Vérifie les identifiants pour se connecter ou non
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

    // Renvoie la permission de l'utilisateur connecté
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

    // S'il est connecté on remplit la valeur de user (la personne qui vient de se connecter)
    public void updateUser(String email) throws SQLException, ClassNotFoundException {
        User user = new User();
        this.user = user.findByEmail(email);
    }
}
