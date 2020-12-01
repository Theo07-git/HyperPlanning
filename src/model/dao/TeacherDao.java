package model.dao;

import model.Student;
import model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {

    private Connection connect = null;
    ResultSet resultSet;

    public TeacherDao(Connection connect){ this.connect = connect; }

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

    public void resultSetByCourse(String nameCourse){
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

    public void createTeacher(Teacher teacher){
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO user VALUES('" + teacher.getId() + "', '" + teacher.getEmail() + "', '" + teacher.getPassword() + "', '" + teacher.getLastName() + "', '" + teacher.getFirstName() + "', '" + teacher.getPermission() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO teacher VALUES('" + teacher.getId() + "', '" + teacher.getIdCourse() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
