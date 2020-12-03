package model;

import model.dao.DAOFactory;
import model.dao.TeacherDao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class Teacher extends User {

    private TeacherDao teacherDao;
    private String idCourse;

    // Constructeurs
    public Teacher() throws SQLException, ClassNotFoundException {
        DAOFactory DAOInstance = new DAOFactory();
        teacherDao = DAOInstance.getTeacherDao();
    }
    public Teacher(String id, String email, String password, String lastName, String firstName, String permission, String idCourse) throws SQLException, ClassNotFoundException {
        super(id, email, password, lastName, firstName, permission);
        DAOFactory DAOInstance = new DAOFactory();
        teacherDao = DAOInstance.getTeacherDao();
        this.idCourse = idCourse;
    }

    // Getters
    public String getIdCourse() {
        return idCourse;
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
    public void setIdCourse(String idCourse){ this.idCourse = idCourse; }

    /**
     * Retourne un professeur trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Teacher findById(String id) throws SQLException, ClassNotFoundException {
        return teacherDao.findById(id);
    }

    /**
     * Retourne un professeur trouvé par son nom
     * @param nameTeacher
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Teacher findByName(String nameTeacher) throws SQLException, ClassNotFoundException {
        return teacherDao.findByName(nameTeacher);
    }

    /**
     * Créée un professeur
     */
    public void createTeacher(){
        teacherDao.createTeacher(this);
    }

    /**
     * Supprime un professeur à l'aide se son id
     * @param idTeacher
     */
    public void deleteTeacher(String idTeacher) {
        teacherDao.deleteTeacher(idTeacher);
    }

    /**
     * Retourne true si le resultSet contient un élément
     * --> si le professeur donne un cours à cette date et heure
     * @param week
     * @param date
     * @param startTime
     * @param endTime
     * @param idTeacher
     * @return
     * @throws SQLException
     */
    public boolean alreadyTeach(int week, Date date, Time startTime, Time endTime, String idTeacher) throws SQLException {
        return teacherDao.alreadyTeach(week, date, startTime, endTime, idTeacher);
    }

    /**
     * Retourne true si le resultSet contient un élément
     * --> si le professeur de ce nom existe
     * @param nameTeacher
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String nameTeacher) throws SQLException{
        return teacherDao.alreadyExist(nameTeacher);
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec le teacherDao)
     * @param nameCourse
     */
    public void resultSetByCourse(String nameCourse){
        teacherDao.resultSetByCourse(nameCourse);
    }

    /**
     * Remplit un professeur et retourne true tant qu'il y a un professeur dans le resultSet
     * (en lien avec le teacherDao)
     * @return
     */
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
