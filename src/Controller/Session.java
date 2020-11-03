package Controller;

import java.sql.Time;
import java.util.List;

public class Session {

    protected String IdSession="";
    private int Week;
    private String Date ="";
    private String StartTime; // mettre type en Time, mais bug syntaxe non reconnu
    private String EndTime;  // pareil ici
    public enum State {ANNULE,REPORTER}; // Statut à completer
    private List<Teacher>SessionTeacher;

    public Session(String idSession, int week, String date, String startTime, String endTime, List<Teacher> sessionTeacher) {
        IdSession = idSession;
        Week = week;
        Date = date;
        StartTime = startTime;
        EndTime = endTime;
        SessionTeacher = sessionTeacher;
    }
}
