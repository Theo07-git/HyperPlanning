package model;

import model.dao.CourseDao;
import model.dao.DAOFactory;
import java.sql.SQLException;

public class Course {

    private CourseDao courseDao;
    private String idCourse;
    private String nameCourse;

    // Constructeurs
    public Course(String idCourse, String nameCourse) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
    }
    public Course() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        courseDao = DAOInstance.getCourseDao();
    }

    // Getters
    public String getIdCourse() {
        return idCourse;
    }
    public String getNameCourse() {
        return nameCourse;
    }

    // Setters
    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }
    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    /**
     * Retourne un cours trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Course findById(String id) throws SQLException, ClassNotFoundException {
        return courseDao.findById(id);
    }

    /**
     * Retourne un cours trouvé par son nom
     * @param name
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Course findByName(String name) throws SQLException, ClassNotFoundException {
        return courseDao.findByName(name);
    }

    /**
     * Rempli le resultSet avec la requête sql
     * (en lien avec le courseDao)
     */
    public void resultSetByIdCourse(){
        courseDao.resultSetByIdCourse();
    }

    /**
     * Remplie un cours et retourne true tant qu'il y a un cours dans le resultSet
     * (en lien avec le courseDao)
     * @return
     */
    public boolean resultSetByIdCourseNext(){
        return(courseDao.resultSetByIdCourseNext(this));
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + idCourse + '\'' +
                ", Name='" + nameCourse + '\'' +
                '}';
    }
}
