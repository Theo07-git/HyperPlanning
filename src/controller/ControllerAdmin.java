package controller;

import model.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdmin {

    private List<Promotion> promotions;
    private List<Group> groupsPromotion;
    private List<Course> courses;
    private List<Student> students;
    private List<Teacher> teachers;
    private User user;
    private Site site;

    //private List<Session> sessions;

    public ControllerAdmin() throws SQLException, ClassNotFoundException {
        promotions = new ArrayList<>();
        groupsPromotion = new ArrayList<>();
        courses = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        site = new Site();
        //sessions = new ArrayList<>();
    }

    public ControllerAdmin(String idUser) throws SQLException, ClassNotFoundException {
        //User user = new User();
        this.user = new User();
        this.user = user.findById(idUser);
    }

    public User getUser() {
        return user;
    }

    public Group getGroupById(String idGroup) throws SQLException, ClassNotFoundException {
        Group grp = new Group();
        Group grp2 = new Group();
        grp2 = grp.findById(idGroup);
        return grp2;
    }

    public ArrayList<String> getAllIdPromotion() throws SQLException, ClassNotFoundException {
        Promotion promotion = new Promotion();
        promotion.resultSetByIdPromotion();
        promotions.add(promotion);
        ArrayList<String> allIdPromotion = new ArrayList<>();
        while(promotion.resultSetByIdPromotionNext()){
            promotions.add(promotion);
            assert allIdPromotion != null;
            allIdPromotion.add(promotion.getIdPromotion());
        }
        return allIdPromotion;
    }

    public ArrayList<String> getAllIdGroupByIdPromo(String idPromotion) throws SQLException, ClassNotFoundException {
        Group group = new Group();
        group.resultSetByIdGroup(idPromotion);
        groupsPromotion.add(group);
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(group.resultSetByIdGroupNext()){
            groupsPromotion.add(group);
            assert allIdGroup != null;
            allIdGroup.add(group.getIdGroup());
        }
        return allIdGroup;
    }
    public ArrayList<String> getAllIdGroup() throws SQLException, ClassNotFoundException {
        Group group = new Group();
        group.resultSetIdGroup();
        groupsPromotion.add(group);
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(group.resultSetIdGroupNext()){
            groupsPromotion.add(group);
            assert allIdGroup != null;
            allIdGroup.add(group.getIdGroup());
        }
        return allIdGroup;
    }

    public ArrayList<String> getAllIdCourse() throws SQLException, ClassNotFoundException {
        Course course = new Course();
        course.resultSetByIdCourse();
        courses.add(course);
        ArrayList<String> allIdGroup = new ArrayList<>();
        while(course.resultSetByIdCourseNext()){
            courses.add(course);
            assert allIdGroup != null;
            allIdGroup.add(course.getIdCourse());
        }
        return allIdGroup;
    }

    public ArrayList<String> getAllNameCourse() throws SQLException, ClassNotFoundException {
        Course course = new Course();
        course.resultSetByIdCourse();
        courses.add(course);
        ArrayList<String> allNameGroup = new ArrayList<>();
        while(course.resultSetByIdCourseNext()){
            courses.add(course);
            assert allNameGroup != null;
            allNameGroup.add(course.getNameCourse());
        }
        return allNameGroup;
    }

    public ArrayList<ArrayList<String>> getAllStudents(String idGroupPromotion) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.resultSetByGroupPromotion(idGroupPromotion);
        students.add(student);
        ArrayList<ArrayList<String>> allStudent = new ArrayList<>();

        while(student.resultSetByGroupPromotionNext()){
            ArrayList<String> buffer = new ArrayList<>();
            students.add(student);
            assert allStudent != null;
            buffer.add(student.getId());
            buffer.add(student.getLastName());
            buffer.add(student.getFirstName());
            buffer.add(student.getEmail());
            buffer.add(student.getPermission());
            buffer.add(student.getStudentNumber());
            allStudent.add(buffer);
        }

        return allStudent;
    }

    public ArrayList<ArrayList<String>> getAllTeachers(String nameCourse) throws SQLException, ClassNotFoundException{
        Teacher teacher = new Teacher();
        teacher.resultSetByCourse(nameCourse);
        teachers.add(teacher);
        ArrayList<ArrayList<String>> allTeachers = new ArrayList<>();

        while(teacher.resultSetByCourseNext()){
            ArrayList<String> buffer = new ArrayList<>();
            teachers.add(teacher);
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

    public ArrayList<ArrayList<String>> getAllUser() throws SQLException, ClassNotFoundException{
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

    public ArrayList<ArrayList<String>> getAllSession(String idGroup) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        ArrayList<ArrayList<String>> allSession = new ArrayList<>();

        while(session.resultSetSessionByIdGroupNext()){
            ArrayList<String> buffer = new ArrayList<>();
            assert allSession != null;
            buffer.add(session.getIdSession());
            buffer.add(String.valueOf(session.getWeek()));
            buffer.add(String.valueOf(session.getDate()));
            buffer.add(String.valueOf(session.getStartTime()));
            buffer.add(String.valueOf(session.getEndTime()));
            buffer.add(session.getType());
            buffer.add(String.valueOf(session.getRoom()));
            allSession.add(buffer);
        }
        return allSession;
    }

    public ArrayList<Session> getAllSession1(String idGroup) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        ArrayList<Session> allSession = new ArrayList<>();
        while(session.resultSetSessionByIdGroupNext()){
            allSession.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return allSession;
    }

    public ArrayList<String> getAllNameSite() throws SQLException, ClassNotFoundException {
        Site site = new Site();
        site.resultSetSiteName();
        ArrayList<String> allNameSite = new ArrayList<>();
        while(site.resultSetSiteNameNext()){
            assert allNameSite != null;
            allNameSite.add(site.getNameSite());
        }
        return allNameSite;
    }

    public ArrayList<Site> getAllSite() throws SQLException, ClassNotFoundException {
        Site site = new Site();
        site.resultSetSiteName();
        ArrayList<Site> allSite = new ArrayList<>();
        while(site.resultSetSiteNameNext()){
            assert allSite != null;
            allSite.add(new Site(site.getIdSite(),site.getNameSite()));
        }
        return allSite;
    }

    public ArrayList<ArrayList<String>> getAllRoom(String nameSite) throws SQLException, ClassNotFoundException {
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

    public List<Group> getGroupsPromotion() {
        return groupsPromotion;
    }
}
