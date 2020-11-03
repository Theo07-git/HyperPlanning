package Controller;

import java.sql.Time;
import java.util.List;

public class Session {

    protected String IdSession="";
    private int Week;
    private String Date ="";
    private Time StartTime;
    private Time EndTime;
    public enum State {ANNULE,REPORTER}; // Statu à completer
    private List<Teacher>SessionTeacher;

    public Session(String idSession, int week, String date, Time startTime, Time endTime, List<Teacher> sessionTeacher) {
        IdSession = idSession;
        Week = week;
        Date = date;
        StartTime = startTime;
        EndTime = endTime;
        SessionTeacher = sessionTeacher;
    }
}
