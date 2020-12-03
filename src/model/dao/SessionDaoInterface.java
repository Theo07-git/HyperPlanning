package model.dao;

import model.Session;
import model.Teacher;
import java.sql.SQLException;

public interface SessionDaoInterface {

    // Création/Suppression du cours
    void createSession(Session session, Teacher teacher);
    void deleteSession(String idSession);

    // Parcourir tous les cours
    void resultSetSessionByIdGroup(String idGroup);
    boolean resultSetSessionByIdGroupNext(Session session);
    void resultSetSessionForTeacher(String idTeacher);
    boolean resultSetSessionForTeacherNext(Session session);

    // Trouve le professeur d'un cours
    Teacher findTeacherSession(String idSession) throws SQLException, ClassNotFoundException;

    boolean alreadyExist(String id) throws SQLException;

    // Donne le nombre de cours selon la matière
    int getNumberSessionByCourse(String idGroupPromotion, String idCourse);
}
