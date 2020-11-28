package model;

import model.dao.DAOFactory;
import model.dao.TeacherDao;

import java.sql.SQLException;
import java.util.List;

public class Teacher extends User {

    private TeacherDao teacherDao;
    private String idCourse;

    public Teacher() throws SQLException, ClassNotFoundException {
        DAOFactory DAOInstance = new DAOFactory();
        teacherDao = DAOInstance.getTeacherDao();
    }

    public Teacher(String id, String name, String lastName, String email, String password, String permission, String idCourse) throws SQLException, ClassNotFoundException {
        super(id, name, lastName, email, password, permission);
        this.idCourse = idCourse;
    }



    public void setId(String id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setIdCourse(String idCourse){ this.idCourse = idCourse; }

    public void resultSetByCourse(String nameCourse){
        teacherDao.resultSetByCourse(nameCourse);
    }

    public boolean resultSetByCourseNext(){
        return (teacherDao.resultSetByCourseNext(this));
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + id + '\'' +
                ", LastName='" + lastName + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", Email='" + email + '\'' +
                ", Permission='" + permission + '\''+
                ", Course='" + idCourse + '\''+
                '}';
    }
}
