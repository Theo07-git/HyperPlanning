package controller;

import model.Session;
import model.Student;

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

    public int[] numberSessionOfCourse(ArrayList<Session> allSession ) {

        int[] totSession = new int[3];
        int cntMath =0;
        int cntPhys =0;
        int cntCosc =0;

        for (int i =0;i<allSession.size();++i){
            if(allSession.get(i).getIdCourse().equals("MATH")){
                cntMath+=1;
            }
            if(allSession.get(i).getIdCourse().equals("COSC")){
                cntCosc+=1;
            }
            if(allSession.get(i).getIdCourse().equals("PHYS")){
                cntPhys+=1;
            } }
        totSession[0] = cntMath;
        totSession[1] = cntCosc;
        totSession[2] = cntPhys;

        return totSession;
    }

    public ArrayList<ArrayList<String>> getAllStudents(String idGroupPromotion) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.resultSetByGroupPromotion(idGroupPromotion);
        ArrayList<ArrayList<String>> allStudent = new ArrayList<>();

        while(student.resultSetByGroupPromotionNext()){
            ArrayList<String> buffer = new ArrayList<>();

            assert allStudent != null;
            buffer.add(student.getLastName());
            buffer.add(student.getFirstName());
            buffer.add(student.getEmail());
            allStudent.add(buffer);
        }

        return allStudent;
    }


}
