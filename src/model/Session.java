package model;

import java.util.List;

public class Session {

    protected String IdSession="";
    private int Week;
    private String Date ="";
    private String StartTime; // mettre type en Time, mais bug syntaxe non reconnu
    private String EndTime;  // pareil ici
    public enum State {ANNULE,REPORTER}; // Statut à completer
    private List<Teacher>SessionTeacher;
    private List<Room> RoomSession;
    private Course cours;

    public Session(String idSession, int week, String date, String startTime, String endTime, List<Teacher> sessionTeacher) {
        IdSession = idSession;
        Week = week;
        Date = date;
        StartTime = startTime;
        EndTime = endTime;
        SessionTeacher = sessionTeacher;
    }

    public Session(String idSession, int week, String date, String startTime, String endTime, List<Teacher> sessionTeacher, List<Room> roomSession, Course cours) {
        IdSession = idSession;
        Week = week;
        Date = date;
        StartTime = startTime;
        EndTime = endTime;
        SessionTeacher = sessionTeacher;
        RoomSession = roomSession;
        this.cours = cours;
    }

    public int getWeek() {
        return Week;
    }

    public String getDate() {
        return Date;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public List<Teacher> getSessionTeacher() {
        return SessionTeacher;
    }

    public List<Room> getRoomSession() {
        return RoomSession;
    }

    public Course getCours() {
        return cours;
    }
}
