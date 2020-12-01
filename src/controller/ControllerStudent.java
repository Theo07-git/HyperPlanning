package controller;

import model.Session;
import model.Student;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerStudent {

    private Student student;

    public ControllerStudent(String idUser) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        this.student = student.findById(idUser);
    }

    public Student getStudent() {
        return student;
    }

    public ArrayList<Session> getAllSession(String idGroup) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        ArrayList<Session> allSession = new ArrayList<>();
        while(session.resultSetSessionByIdGroupNext()){
            allSession.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return allSession;
    }
}
