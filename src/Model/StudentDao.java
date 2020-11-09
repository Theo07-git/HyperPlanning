package Model;

import Controller.Student;
import Controller.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends UserDao{
    public StudentDao(Connection connection){
        super(connection);
    }

    public boolean create(Student obj){
        return false;
    }

    public boolean update(Student obj) {
        return false;
    }

    public boolean delete(Student obj) {
        return false;
    }

    public Student find(String id) {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }
}
