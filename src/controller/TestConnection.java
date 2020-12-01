package controller;

import model.User;

import java.sql.SQLException;

public class TestConnection {

    private User user;
    public boolean isConnect;
    public boolean idFaild;
    public String firstName;


    public TestConnection(User user) {
        this.user = user;
        isConnect = false;
        idFaild =false;
    }

    public void isConnected(String email, String mdp) throws SQLException, ClassNotFoundException {
        User user = new User();
        user = user.findByEmail(email);
        firstName = user.getFirstName();

        if(!email.equals("") && !mdp.equals("")) {
            if (mdp.equals(user.getPassword()) && (email.equals(user.getEmail()) || email.equals(user.getId()))) {
                isConnect = true;
            }
             else {
            idFaild = true;
             }

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

    public boolean getIsIdFaild() {
        return idFaild;
    }

    public void getActualUser(){
        //System.out.println(user.toString());
    }
    public User getUser(){
        return user;
    }
}
