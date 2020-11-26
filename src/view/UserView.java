package view;

import model.User;

import java.sql.SQLException;

public class UserView {
    public void DisplayForm() throws SQLException, ClassNotFoundException {

        User user = new User();
        // Affiche tous les utilisateurs classés par nom
        //user.ResultSetByName();
        //while(user.ResultSetByNameNext()){
            //System.out.println(user.toString());
        //}

        //Test la recherche de User
        /*
        DAOFactory DAOInstance = new DAOFactory();
        DAO<User> userDao = DAOInstance.getUserDao();
        DAO<User> userDao1 = DAOInstance.getUserDao();
        DAO<User> userDao2 = DAOInstance.getUserDao();
        DAO<User> userDao3 = DAOInstance.getUserDao();
        User user = userDao.findById("0001");
        User user1 = userDao1.findByEmail("re@ece.fr");
        User user2 = userDao2.findById("0012");
        User user3 = userDao3.findByLastName("OIN");

        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

         */
    }
    public void DisplayGrid(){

    }

}
