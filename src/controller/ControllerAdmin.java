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

    public ControllerAdmin(){
        promotions = new ArrayList<>();
        groupsPromotion = new ArrayList<>();
        courses = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();
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
}
