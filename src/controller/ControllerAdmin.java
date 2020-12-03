package controller;

import model.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdmin {

    private User user;

    // Constructeurs
    public ControllerAdmin() {}
    public ControllerAdmin(String idUser) throws SQLException, ClassNotFoundException {
        this.user = new User();
        this.user = user.findById(idUser);
    }

    // Getter
    public User getUser() {
        return user;
    }

    // Récupération des infos pour les combobox
    public ArrayList<String> getAllIdPromotion() throws SQLException, ClassNotFoundException {
        Promotion promotion = new Promotion();
        promotion.resultSetByIdPromotion();
        ArrayList<String> allIdPromotion = new ArrayList<>();
        while(promotion.resultSetByIdPromotionNext()){
            assert allIdPromotion != null;
            allIdPromotion.add(promotion.getIdPromotion());
        }
        return allIdPromotion;
    }
    public ArrayList<String> getAllIdGroupByIdPromo(String idPromotion) throws SQLException, ClassNotFoundException {
        Group group = new Group();
        group.resultSetByIdGroup(idPromotion);
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(group.resultSetByIdGroupNext()){
            assert allIdGroup != null;
            allIdGroup.add(group.getIdGroup());
        }
        return allIdGroup;
    }
    public ArrayList<String> getAllIdGroup() throws SQLException, ClassNotFoundException {
        Group group = new Group();
        group.resultSetIdGroup();
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(group.resultSetIdGroupNext()){
            assert allIdGroup != null;
            allIdGroup.add(group.getIdGroup());
        }
        return allIdGroup;
    }
    public ArrayList<String> getAllIdCourse() throws SQLException, ClassNotFoundException {
        Course course = new Course();
        course.resultSetByIdCourse();
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(course.resultSetByIdCourseNext()){
            assert allIdGroup != null;
            allIdGroup.add(course.getIdCourse());
        }
        return allIdGroup;
    }
    public ArrayList<String> getAllNameCourse() throws SQLException, ClassNotFoundException {
        Course course = new Course();
        course.resultSetByIdCourse();
        ArrayList<String> allNameGroup = new ArrayList<>();
        while(course.resultSetByIdCourseNext()){
            assert allNameGroup != null;
            allNameGroup.add(course.getNameCourse());
        }
        return allNameGroup;
    }

    // Récupération des infos pour remplir les tableaux et les emplois du temps
    public ArrayList<ArrayList<String>> getAllStudents(String idGroupPromotion) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.resultSetByGroupPromotion(idGroupPromotion);
        ArrayList<ArrayList<String>> allStudents = new ArrayList<>();
        while(student.resultSetByGroupPromotionNext()){
            ArrayList<String> buffer = new ArrayList<>();
            assert allStudents != null;
            buffer.add(student.getId());
            buffer.add(student.getLastName());
            buffer.add(student.getFirstName());
            buffer.add(student.getEmail());
            buffer.add(student.getPermission());
            buffer.add(student.getStudentNumber());
            allStudents.add(buffer);
        }
        return allStudents;
    }
    public ArrayList<ArrayList<String>> getAllTeachers(String nameCourse) throws SQLException, ClassNotFoundException{
        Teacher teacher = new Teacher();
        teacher.resultSetByCourse(nameCourse);
        ArrayList<ArrayList<String>> allTeachers = new ArrayList<>();
        while(teacher.resultSetByCourseNext()){
            ArrayList<String> buffer = new ArrayList<>();
            assert allTeachers != null;
            buffer.add(teacher.getId());
            buffer.add(teacher.getLastName());
            buffer.add(teacher.getFirstName());
            buffer.add(teacher.getEmail());
            buffer.add(teacher.getPermission());
            allTeachers.add(buffer);
        }
        return allTeachers;
    }
    public ArrayList<ArrayList<String>> getAllUsers() throws SQLException, ClassNotFoundException{
        User user = new User();
        user.ResultSetAll();
        ArrayList<ArrayList<String>> allUsers = new ArrayList<>();
        while(user.ResultSetAllNext()){
            ArrayList<String> buffer = new ArrayList<>();
            assert allUsers != null;
            buffer.add(user.getId());
            buffer.add(user.getLastName());
            buffer.add(user.getFirstName());
            buffer.add(user.getEmail());
            buffer.add(user.getPermission());
            allUsers.add(buffer);
        }
        return allUsers;
    }
    public ArrayList<Session> getAllSessions(String idGroup) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        ArrayList<Session> allSession = new ArrayList<>();
        while(session.resultSetSessionByIdGroupNext()){
            allSession.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return allSession;
    }
    public ArrayList<String> getAllNamesSite() throws SQLException, ClassNotFoundException {
        Site site = new Site();
        site.resultSetSiteName();
        ArrayList<String> allNameSite = new ArrayList<>();
        while(site.resultSetSiteNameNext()){
            assert allNameSite != null;
            allNameSite.add(site.getNameSite());
        }
        return allNameSite;
    }
    public ArrayList<Site> getAllSites() throws SQLException, ClassNotFoundException {
        Site site = new Site();
        site.resultSetSiteName();
        ArrayList<Site> allSite = new ArrayList<>();
        while(site.resultSetSiteNameNext()){
            assert allSite != null;
            allSite.add(new Site(site.getIdSite(),site.getNameSite()));
        }
        return allSite;
    }
    public ArrayList<ArrayList<String>> getAllRooms(String nameSite) throws SQLException, ClassNotFoundException {
        Room room = new Room();
        room.resultSetRoom(nameSite);
        ArrayList<ArrayList<String>> allRoom = new ArrayList<>();
        while(room.resultSetRoomNext()){
            ArrayList<String> buffer = new ArrayList<>();
            assert allRoom != null;
            buffer.add(room.getIdRoom());
            buffer.add(room.getNameRoom());
            buffer.add(String.valueOf(room.getCapacity()));
            allRoom.add(buffer);
        }
        return allRoom;
    }

    // Diagramme circulaire montrant le nombre d'élèves par promo
    public ChartPanel getChartStudentByPromotion() throws SQLException, ClassNotFoundException {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        Promotion promotion = new Promotion();
        ArrayList<Promotion> promotions = promotion.getAllPromotions();
        for(Promotion ipromotion : promotions){
            dataset.setValue(ipromotion.getNamePromotion(), ipromotion.getNumberStudentsByPromotion());
        }
        final JFreeChart pieChart = ChartFactory.createPieChart("Nombre d'élèves par promotion", dataset);
        final ChartPanel chartPanel = new ChartPanel(pieChart);
        return chartPanel;
    }
}
