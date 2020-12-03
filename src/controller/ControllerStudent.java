package controller;

import model.Course;
import model.Session;
import model.Student;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerStudent {

    private Student student;

    // Constructeur
    public ControllerStudent(String idUser) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        this.student = student.findById(idUser);
    }

    // Getter
    public Student getStudent()
    {
        return student;
    }

    /**
     * Retourne une liste de Session contenant les sessions d'un groupe en particulier
     * @param idGroup
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Session> getAllSession(String idGroup) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        ArrayList<Session> allSession = new ArrayList<>();
        while(session.resultSetSessionByIdGroupNext()){
            allSession.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return allSession;
    }

    /**
     * retourne tableau de int contenant les compteurs de session par matière
     * @param allSession
     * @return
     */
    public int[] numberSessionOfCourse(ArrayList<Session> allSession) {
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
            }
        }
        totSession[0] = cntMath;
        totSession[1] = cntCosc;
        totSession[2] = cntPhys;

        return totSession;
    }

    /**
     * Retourne une liste de liste de String contenant les information des étudiants en fonction de leur groupe
     * @param idGroupPromotion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Retourne un ChartPanel donnant les informations du nombre d'heure de cours (matières) pour l'éleve connecté
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ChartPanel getSessionCoursesByStudent() throws SQLException, ClassNotFoundException {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        Course course = new Course();
        Session session = new Session();
        ArrayList<Session> sessions = session.getAllSessions(student.getIdGroupPromotion());
        for(Session isession : sessions){
                dataset.setValue(course.findById(isession.getIdCourse()).getNameCourse(), isession.getNumberSessionsByCourse(student.getIdGroupPromotion(), isession.getIdCourse()));
        }

        final JFreeChart pieChart = ChartFactory.createPieChart("Nombre de sessions par matière", dataset);
        final ChartPanel chartPanel = new ChartPanel(pieChart);
        return chartPanel;
    }
}
