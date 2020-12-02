package model;

import model.dao.DAOFactory;
import model.dao.SessionDao;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Session {

    SessionDao sessionDao;
    private String IdSession="";
    private int Week;
    private Date date;
    private Time StartTime;
    private Time EndTime;
    private String type;
    private Room room;
    private String idCourse;
    private String teacherName;
    private String idGroupSession;

    public Session(String idSession, int week, Date date, Time startTime, Time endTime, String type, String idCourse, Room room, String teacherName, String idGroupSession) throws SQLException, ClassNotFoundException {
        DAOFactory DAOInstance = new DAOFactory();
        sessionDao = DAOInstance.getSessionDao();
        IdSession = idSession;
        Week = week;
        this.date = date;
        StartTime = startTime;
        EndTime = endTime;
        this.type = type;
        this.room = room;
        this.idCourse = idCourse;
        this.teacherName = teacherName;
        this.idGroupSession = idGroupSession;
    }

    public Session() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        sessionDao = DAOInstance.getSessionDao();
        this.room = new Room();
    }

    public Room getRoom(){
        return room;
    }

    public String getTeacherName(){
        return teacherName;
    }

    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }

    public String getIdGroupSession() {
        return idGroupSession;
    }

    public void setIdGroupSession(String idGroupSession) {
        this.idGroupSession = idGroupSession;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdSession() {
        return IdSession;
    }

    public int getWeek() {
        return Week;
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return StartTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public String getType() {
        return type;
    }

    public void setRoom(String id, int capacity, String nameRoom) {
        this.room.setIdRoom(id);
        this.room.setCapacity(capacity);
        this.room.setNameRoom(nameRoom);
    }

    public void setIdSession(String idSession) {
        IdSession = idSession;
    }

    public void setWeek(int week) {
        Week = week;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartTime(Time startTime) {
        StartTime = startTime;
    }

    public void setEndTime(Time endTime) {
        EndTime = endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void resultSetSessionByIdGroup(String idGroup){
        sessionDao.resultSetSessionByIdGroup(idGroup);
    }
    public boolean resultSetSessionByIdGroupNext(){
        return (sessionDao.resultSetSessionByIdGroupNext(this));
    }

    public void resultSetSessionForTeacher(String idTeacher){
        sessionDao.resultSetSessionForTeacher(idTeacher);
    }

    public boolean resultSetSessionForTeacherNext(){
        return (sessionDao.resultSetSessionForTeacherNext(this));
    }

    public Teacher findTeacherSession() throws SQLException, ClassNotFoundException{
        return sessionDao.findTeacherSession(this.IdSession);
    }

    public void createSession(Teacher teacher){
        sessionDao.createSession(this, teacher);
    }

    public void deleteSession(String idSession) throws SQLException{
        sessionDao.deleteSession(idSession);
    }

    public boolean alreadyExist(String id) throws SQLException{
        return sessionDao.alreadyExist(id);
    }

    @Override
    public String toString() {
        return "Session{" +
                "IdSession='" + IdSession + '\'' +
                ", Week=" + Week +
                ", date=" + date +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", type='" + type + '\'' +
                ", room=" + room +
                ", idCourse='" + idCourse + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", idGroupSession='" + idGroupSession + '\'' +
                '}';
    }
}
