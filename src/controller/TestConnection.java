package controller;

import model.User;

import java.sql.SQLException;

public class TestConnection {

    private User user;
    public boolean isConnect;

    public TestConnection(User user) {
        this.user = user;
        isConnect = false;
    }

    public void isConnected(String email, String mdp) throws SQLException, ClassNotFoundException {
        User user = new User();
        user = user.findByEmail(email);

        if (mdp.equals(user.getPassword()) && ( email.equals(user.getEmail()) || email.equals(user.getId()))){
            System.out.println("Connexion Réussi");
            isConnect = true;
        }
        else{
            System.out.println("Connexion Échoué : Vous avez entrez mdp:"+mdp+" id:"+email);
        }
    }

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

    public void updateUser(String email, String password) throws SQLException, ClassNotFoundException {
        User user = new User();
        this.user = user.findByEmail(email);
    }

    public boolean getIsConnect() {
        return isConnect;
    }

    public void getActualUser(){
        //System.out.println(user.toString());
    }
    public User getUser(){
        return user;
    }
}
