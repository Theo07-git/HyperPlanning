package model.dao;

import model.Course;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao implements CourseDaoInterface{

    private final Connection connect;
    private ResultSet resultSet;

    // Constructeur
    public CourseDao(Connection connect){ this.connect = connect; }

    /**
     * Retourne un cours trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Course findById(String id) throws SQLException, ClassNotFoundException {
        Course course = new Course();
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course WHERE idCourse = '" + id + "'");
            if(resultSet.first()) {
                course = new Course(
                        id,
                        resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    /**
     * Retourne un cours trouvé par son nom
     * @param name
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Course findByName(String name) throws SQLException, ClassNotFoundException {
        Course course = new Course();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course WHERE name = '" + name + "'");
            if(result.first()) {
                course = new Course(
                        result.getString("idCourse"),
                        name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    // Parcourir toutes les matières

    /**
     * Rempli le resultSet avec la requête sql
     */
    public void resultSetByIdCourse() {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM course");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplie un cours et retourne true tant qu'il y a un cours dans le resultSet
     * @param course
     * @return
     */
    public boolean resultSetByIdCourseNext(Course course) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                course.setIdCourse(resultSet.getString("idCourse"));
                course.setNameCourse(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
}
