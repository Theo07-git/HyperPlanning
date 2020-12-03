package model.dao;

import model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInterface{

    private final Connection connect;
    ResultSet resultSet;

    // Constructeur
    public UserDao(Connection conn){
        this.connect = conn;
    }

    /**
     * Retourne un utilisateur trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Retourne un utilisateur trouvé par son email
     * @param email
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     *Remplit le resultSet avec la requête sql
     */
    public void ResultSetAll() {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplit un utiliosateur et retourne true tant qu'il y a un utilisateur dans le resultSet
     * @param user
     * @return
     */
    public boolean ResultSetAllNext(User user){
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

    /**
     * Met à jour le mot de passe de l'utilisateur qui appelle cette fonction
     * @param user
     * @return
     */
    public User updatePassword(User user){
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "UPDATE user SET password = '" + user.getPassword() + "' WHERE idUser = '" + user.getId() + "'");
            user = this.findById(user.getId());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Retourne true si le resultSet contient un élément
     * --> si l'id de l'utilisateur existe déja
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String id) throws SQLException {
        try {
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resultSet.first()){
            return true;
        }else return false;
    }
}
