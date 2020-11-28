package model.dao;

import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface{

    private Connection connect = null;
    ResultSet resultSet;

    public StudentDao(Connection connect){ this.connect = connect; }

    public boolean create(Student student){
        return false;
    }

    public boolean update(Student student) {
        return false;
    }

    public boolean delete(Student student) {
        return false;
    }

    public Student findById(String id) throws SQLException, ClassNotFoundException {
        Student student = new Student();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);
            ResultSet result1 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM student WHERE id_UserS = " + id);
            if(result.first() && result1.first())
                student = new Student(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"),
                        result1.getString("number"),
                        result1.getString("id_group_promotionS"));
            else System.out.println("Erreur identification eleve non trouve");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    public void resultSetById()  {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM student ORDER BY id_UserS");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean resultSetByIdNext(Student student){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                student.setId(resultSet.getString("idUser"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setPermission(resultSet.getString("permission"));
                student.setStudentNumber(resultSet.getString("number"));
                student.setIdGroupPromotion(resultSet.getString("id_group_promotionS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    public void resultSetByGroupPromotion(String idGroupPromotion){
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user JOIN student ON user.idUser = student.id_UserS WHERE student.id_group_promotionS ='" + idGroupPromotion + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean resultSetByGroupPromotionNext(Student student){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                student.setId(resultSet.getString("idUser"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setPermission(resultSet.getString("permission"));
                student.setStudentNumber(resultSet.getString("number"));
                student.setIdGroupPromotion(resultSet.getString("id_group_promotionS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

}
