package model.dao;

import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface{
    private final Connection connect;

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
            if(result.first())
                student = new Student(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"),
                        result.getInt("number"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

}
