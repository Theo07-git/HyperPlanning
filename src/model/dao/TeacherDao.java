package model.dao;
import model.Teacher;

import java.sql.*;

public class TeacherDao implements TeacherDaoInterface {

    private final Connection connect;
    ResultSet resultSet;

    // Constructeur
    public TeacherDao(Connection connect){ this.connect = connect; }

    // Création/Suppresion d'un professeur
    public void createTeacher(Teacher teacher) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO user VALUES('" + teacher.getId() + "', '" + teacher.getEmail() + "', '" + teacher.getPassword() + "', '" + teacher.getLastName() + "', '" + teacher.getFirstName() + "', '" + teacher.getPermission() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO teacher VALUES('" + teacher.getId() + "', '" + teacher.getIdCourse() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteTeacher(String idTeacher) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM teacher WHERE (id_UserT = '" + idTeacher + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM user WHERE idUser = '" + idTeacher + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Trouver le professeur
    public Teacher findById(String id) throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);
            ResultSet result1 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM teacher WHERE id_UserT = " + id);
            if(result.first() && result1.first()) {
                teacher = new Teacher(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"),
                        result1.getString("id_CourseT"));
            }
            else System.out.println("Erreur identification professeur non trouve");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return teacher;
    }
    public Teacher findByName(String nameTeacher) throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user JOIN teacher\n" +
                    "ON user.idUser = teacher.id_UserT\n" +
                    "WHERE user.last_name = '" + nameTeacher + "'");
            if(result.first())
                teacher = new Teacher(
                        result.getString("idUser"),
                        result.getString("email"),
                        result.getString("password"),
                        nameTeacher,
                        result.getString("first_name"),
                        result.getString("permission"),
                        result.getString("id_CourseT"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return teacher;
    }

    // Parcourir les professeurs
    public void resultSetByCourse(String nameCourse) {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user JOIN teacher JOIN course \n" +
                    "ON user.idUser = teacher.id_UserT\n" +
                    "AND teacher.id_CourseT = course.idCourse\n" +
                    "WHERE course.name = '" + nameCourse + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean resultSetByCourseNext(Teacher teacher) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                teacher.setId(resultSet.getString("idUser"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPassword(resultSet.getString("password"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setPermission(resultSet.getString("permission"));
                teacher.setIdCourse(resultSet.getString("id_CourseT"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    // Vérifie si le professeur est déjà en cours
    public boolean alreadyTeach(int week, Date date, Time startTime, Time endTime, String idTeacher) throws SQLException {
        try {
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session \n" +
                    "JOIN teachers_session\n" +
                    "    ON session.idSession = teachers_session.id_SessionTS\n" +
                    "JOIN teacher\n" +
                    "    ON teachers_session.id_TeacherTS = teacher.id_UserT\n" +
                    "WHERE teacher.id_UserT = '" + idTeacher + "'\n" +
                    "AND session.week = '" + week + "'\n" +
                    "AND session.date = '" + date + "' \n" +
                    "AND session.start_time = '" + startTime + "'\n" +
                    "AND session.end_time = '" + endTime + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resultSet.first()){
            return true;
        }else return false;
    }

    // Vérifie si le professeur exitse
    public boolean alreadyExist(String nameTeacher) throws SQLException {
        try {
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE last_name = '" + nameTeacher +"'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resultSet.first()){
            return true;
        }else return false;
    }
}
