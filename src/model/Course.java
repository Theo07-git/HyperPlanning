package model;

import model.dao.CourseDao;
import model.dao.DAOFactory;

import java.sql.SQLException;
import java.util.List;

public class Course {

    private CourseDao courseDao;
    private String idCourse = "";
    private String nameCourse = "";

    public Course(String idCourse, String nameCourse) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
    }

    public Course() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        courseDao = DAOInstance.getCourseDao();
    }

    public Course findById(String id) throws SQLException, ClassNotFoundException {
        return courseDao.findById(id);
    }

    public Course findByName(String name) throws SQLException, ClassNotFoundException {
        return courseDao.findByName(name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + idCourse + '\'' +
                ", Name='" + nameCourse + '\'' +
                '}';
    }
}
