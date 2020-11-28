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

    public User() throws ClassNotFoundException, SQLException {
        String url ="jdbc:mysql://localhost:3306/hyperplanning?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        DAOFactory DAOInstance = new DAOFactory();
        userDao = DAOInstance.getUserDao();
    }

    public User(String id, String email, String password, String lastName, String firstName, String permission) throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        UserDao userDao = DAOInstance.getUserDao();
        this.id = id;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User findByEmail(String email) throws SQLException, ClassNotFoundException {
        return userDao.findByEmail(email);
    }

    public User findById(String id) throws SQLException, ClassNotFoundException {
        return userDao.findById(id);
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

    public void ResultSetByName(){
        userDao.ResultSetByName();
    }

    public boolean ResultSetByNameNext(){
        return(userDao.ResultSetByNameNext(this));
    }
}
