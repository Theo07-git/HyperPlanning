package model.dao;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInterface{
    private Connection connect = null;

    ResultSet resultSet;

    public UserDao(Connection conn){
        this.connect = conn;
    }

    public UserDao() {
        super();
    }

    public boolean create(User user){ return false; }

    public boolean update(User user){
        return false;
    }

    public boolean delete(User user){
        return false;
    }

    public User findById(String id) throws SQLException, ClassNotFoundException {
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);
            if(result.first()){
                user = new User(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"));
            }
            else System.out.println("Erreur identification user non trouve");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public User findByEmail(String email) throws SQLException, ClassNotFoundException {
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE email = '" + email + "'");
            if(result.first()) {
                user = new User(
                        result.getString("idUser"),
                        email,
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public User findByLastName(String last_name) throws SQLException, ClassNotFoundException {
        User user = new User();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE last_name = '" + last_name + "'");
            if(result.first())
                user = new User(
                        result.getString("idUser"),
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

    public void ResultSetByName()  {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user ORDER BY last_name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean ResultSetByNameNext(User user){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                user.setId(resultSet.getString("idUser"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setLastName(resultSet.getString("last_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setPermission(resultSet.getString("permission"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
}
