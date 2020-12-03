package model;

import model.dao.DAOFactory;
import model.dao.StudentDao;
import java.sql.SQLException;

public class Student extends User{

    private StudentDao studentDao;
    private String studentNumber;
    private String idGroupPromotion;

    // Constructeurs
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

    // Getters
    public String getStudentNumber() {
        return studentNumber;
    }
    public String getIdGroupPromotion() {
        return idGroupPromotion;
    }

    // Setters
    public void setId(String id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public void setIdGroupPromotion(String idGroupPromotion) {
        this.idGroupPromotion = idGroupPromotion;
    }

    /**
     * Retourne un étudiant trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Student findById(String id) throws SQLException, ClassNotFoundException{
        return studentDao.findById(id);
    }

    /**
     * Créée l'étudiant
     */
    public void createStudent(){
        studentDao.createStudent(this);
    }

    /**
     * Supprime l'étudiant à l'aide de son id
     * @param idStudent
     */
    public void deleteStudent(String idStudent) {
        studentDao.deleteStudent(idStudent);
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec le studentDao)
     * @param idGroupPromotion
     */
    public void resultSetByGroupPromotion(String idGroupPromotion){
        studentDao.resultSetByGroupPromotion(idGroupPromotion);
    }

    /**
     * Remplit un étudiant et retourne true tant qu'il y a un étudiant dans le resultSet
     * (en lien avec le studentDao)
     * @return
     */
    public boolean resultSetByGroupPromotionNext(){
        return (studentDao.resultSetByGroupPromotionNext(this));
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
