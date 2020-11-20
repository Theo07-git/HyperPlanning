package model;

import java.util.List;

public class Course {

    protected String IdCourse ="";
    public enum TypeCourse {COURS_INTERACTIF,TP,TD,PROJET,SOUTIEN,DS}
    private String NameCourse ="";
    private List<Session> ListSession;

    public Course(String idCourse, String nameCourse, List<Session> listSession) {
        IdCourse = idCourse;
        NameCourse = nameCourse;
        ListSession = listSession;
    }
}
