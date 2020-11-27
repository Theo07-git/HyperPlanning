package controller;

import model.Course;
import model.Group;
import model.Promotion;
import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdmin {

    private List<Promotion> promotions;
    private List<Group> groupsPromotion;
    private List<Course> courses;
    private List<Student> students;

    public ControllerAdmin(){
        promotions = new ArrayList<>();
        groupsPromotion = new ArrayList<>();
        courses = new ArrayList<>();
        students = new ArrayList<>();
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

    public ArrayList<String> getAllIdGroup(String idPromotion) throws SQLException, ClassNotFoundException {
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

    public ArrayList<ArrayList<String>> getAllStudent(String idGroupPromotion) throws SQLException, ClassNotFoundException {
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
}
