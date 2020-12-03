package model.dao;

import model.Course;
import java.sql.SQLException;

public interface CourseDaoInterface{

    // Trouver la matière
    Course findById(String id) throws SQLException, ClassNotFoundException;
    Course findByName(String name) throws SQLException, ClassNotFoundException;

    // Parcourir toutes les matières
    void resultSetByIdCourse();
    boolean resultSetByIdCourseNext(Course course);
}
