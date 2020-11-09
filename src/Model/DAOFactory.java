package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DAOFactory {
    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) throws ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        // Monte le driver connecteur à la base de données
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
    }

    public DAOFactory() throws ClassNotFoundException {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning?useUnicode=true&useJDBCCompliant" +
                "TimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.username = "root";
        this.password = "planning$*";
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
    }


    // Méthode chargée de fournir une connexion à la base de données
    private  Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    //  Méthodes de récupération des différents DAO
    public DAO getUserDao() throws SQLException{
        return new UserDao(this.getConnection());
    }

    public DAO getStudentDao() throws SQLException{
        return new StudentDao(this.getConnection());
    }

    //public DAO getProfesseurDao() throws SQLException{
      //  return new ProfesseurDao(this.getConnection());
    //}

    public DAO getPromotionDao() throws SQLException{
        return new PromotionDao(this.getConnection());
    }

}