package controller;

import model.Session;
import model.Student;
import model.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerTeacher {
    private Teacher teacher;

    public ControllerTeacher(String idUser) throws SQLException, ClassNotFoundException {
        Teacher thr = new Teacher();
        this.teacher= thr.findById(idUser);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Session> getAllSession(String idTeacher) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionForTeacher(idTeacher);
        ArrayList<Session> allSession = new ArrayList<>();
        while(session.resultSetSessionForTeacherNext()){
            allSession.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return allSession;
    }
}


