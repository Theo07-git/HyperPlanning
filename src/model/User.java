package model;

import model.dao.DAOFactory;
import model.dao.UserDao;
import java.sql.SQLException;
import java.util.Observable;

public  class User extends Observable {

    UserDao userDao;
    protected String id = "";
    protected String email = "";
    protected String password = "";
    protected String lastName = "";
    protected String firstName = "";
    protected String permission;

    // Constructeurs
    public User() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        userDao = DAOInstance.getUserDao();
    }
    public User(String id, String email, String password, String lastName, String firstName, String permission) throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        userDao = DAOInstance.getUserDao();
        this.id = id;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.permission = permission;
    }

    // Getters
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPermission() {
        return permission;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * Retourne un utilisateur trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User findById(String id) throws SQLException, ClassNotFoundException {
        return userDao.findById(id);
    }

    /**
     * Retourne un utilisateur trouvé par son email
     * @param email
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User findByEmail(String email) throws SQLException, ClassNotFoundException {
        return userDao.findByEmail(email);
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec le userDao)
     */
    public void ResultSetAll(){
        userDao.ResultSetAll();
    }

    /**
     * Remplit un utiliosateur et retourne true tant qu'il y a un utilisateur dans le resultSet
     * (en lien avec le userDao)
     * @return
     */
    public boolean ResultSetAllNext(){
        return userDao.ResultSetAllNext(this);
    }

    /**
     * Met à jour le mot de passe de l'utilisateur qui appelle cette fonction
     * @param password
     */
    public void updatePassword(String password){
        this.password = password;
        userDao.updatePassword(this);
    }

    /**
     * Retourne true si le resultSet contient un élément
     * --> si l'id de l'utilisateur existe déja
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String id) throws SQLException{
        return userDao.alreadyExist(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", LastName='" + lastName + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", Email='" + email + '\'' +
                ", Permission='" + permission + '\''+
                '}';
    }
}
