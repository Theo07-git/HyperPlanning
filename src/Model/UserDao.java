package Model;

import Controller.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DAO<User>{
    public UserDao(Connection connection){
        super(connection);
    }

    public boolean create(User user){ return false; }

    public boolean update(User obj){
        return false;
    }

    public boolean delete(User obj){
        return false;
    }

    public User findById(String id){
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);
            if(result.first())
                user = new User(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public User findByEmail(String email){
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE email = '" + email + "'");
            if(result.first())
                user = new User(
                        result.getString("idUser"),
                        email,
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public User findByLastName(String last_name) {
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE last_name = '" + last_name + "'");
            if(result.first())
                user = new User(
                        result.getString("idUser"),
                        result.getString("email"),
                        result.getString("password"),
                        "OIN",
                        result.getString("first_name"),
                        result.getString("permission"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}
