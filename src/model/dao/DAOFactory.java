package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private final String url;
    private final String username;
    private final String password;

    // Constructeur créeant la connection
    public DAOFactory() throws ClassNotFoundException {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning?useUnicode=true&useJDBCCompliant" +
                "TimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
        this.username = "root";
        this.password = "bqpnr5cd";
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
    }

    // Méthode chargée de fournir une connexion à la base de données
    private  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //  Méthodes de récupération des différents DAO
    public CourseDao getCourseDao() throws SQLException {
        return new CourseDao(this.getConnection());
    }
    public GroupDao getGroupDao() throws SQLException {
        return new GroupDao(this.getConnection());
    }
    public PromotionDao getPromotionDao() throws SQLException {
        return new PromotionDao(this.getConnection());
    }
    public RoomDao getRoomDao() throws SQLException {
        return new RoomDao(this.getConnection());
    }
    public SessionDao getSessionDao() throws SQLException {
        return new SessionDao(this.getConnection());
    }
    public SiteDao getSiteDao() throws SQLException {
        return new SiteDao(this.getConnection());
    }
    public StudentDao getStudentDao() throws SQLException {
        return new StudentDao(this.getConnection());
    }
    public TeacherDao getTeacherDao() throws SQLException {
        return new TeacherDao(this.getConnection());
    }
    public UserDao getUserDao() throws SQLException {
        return new UserDao(this.getConnection());
    }
}