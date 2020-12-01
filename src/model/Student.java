package model;

import model.dao.DAOFactory;
import model.dao.StudentDao;
import java.sql.SQLException;

public class Student extends User{

    private StudentDao studentDao;
    private String studentNumber;
    private String idGroupPromotion;

    public Student() throws SQLException, ClassNotFoundException {
        DAOFactory DAOInstance = new DAOFactory();
        studentDao = DAOInstance.getStudentDao();
    }

    public Student(String id, String email, String password, String lastName, String firstName, String permission, String studentNumber, String idGroupPromotion) throws SQLException, ClassNotFoundException {
        super(id, email, password, lastName, firstName, permission);
        DAOFactory DAOInstance = new DAOFactory();
        studentDao = DAOInstance.getStudentDao();
        this.studentNumber = studentNumber;
        this.idGroupPromotion = idGroupPromotion;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getIdGroupPromotion() {
        return idGroupPromotion;
    }

    public void setIdGroupPromotion(String idGroupPromotion) {
        this.idGroupPromotion = idGroupPromotion;
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

    public Student findById(String id) throws SQLException, ClassNotFoundException{
        return studentDao.findById(id);
    }

    public void resultSetById(){
        studentDao.resultSetById();
    }

    public boolean resultSetByIdNext(){
        return (studentDao.resultSetByIdNext(this));
    }

    public void resultSetByGroupPromotion(String idGroupPromotion){
        studentDao.resultSetByGroupPromotion(idGroupPromotion);
    }

    public boolean resultSetByGroupPromotionNext(){
        return (studentDao.resultSetByGroupPromotionNext(this));
    }

    public void createStudent(){
        studentDao.createStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + id + '\'' +
                ", LastName='" + lastName + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", Email='" + email + '\'' +
                ", Permission='" + permission + '\''+
                ", Number='" + studentNumber + '\''+
                ", Id GroupPromotion='" + idGroupPromotion + '\''+
                '}';
    }
}
