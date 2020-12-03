package model.dao;

import model.Teacher;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public interface TeacherDaoInterface {

    // Création/Suppresion d'un professeur
    void createTeacher(Teacher teacher);
    void deleteTeacher(String idTeacher);

    // Trouver le professeur
    Teacher findById(String id) throws SQLException, ClassNotFoundException;
    Teacher findByName(String nameTeacher) throws SQLException, ClassNotFoundException;

    // Parcourir les professeurs
    void resultSetByCourse(String nameCourse);
    boolean resultSetByCourseNext(Teacher teacher);

    // Vérifie si le professeur est déjà en cours
    boolean alreadyTeach(int week, Date date, Time startTime, Time endTime, String idTeacher) throws SQLException;

    // Vérifie si le professeur exitse
    boolean alreadyExist(String nameTeacher) throws SQLException;
}
