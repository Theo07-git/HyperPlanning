package model;

import model.dao.DAOFactory;
import model.dao.SessionDao;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
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

    // Constructeurs
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

    // Getters
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
    public Room getRoom(){
        return room;
    }
    public String getIdCourse() {
        return idCourse;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public String getIdGroupSession() {
        return idGroupSession;
    }

    // Setters
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
    public void setRoom(String id, int capacity, String nameRoom) {
        this.room.setIdRoom(id);
        this.room.setCapacity(capacity);
        this.room.setNameRoom(nameRoom);
    }
    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }
    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }
    public void setIdGroupSession(String idGroupSession) {
        this.idGroupSession = idGroupSession;
    }

    /**
     * Retourne un professeur trouvé par son Id qui enseigne dans cette session
     */
    public Teacher findTeacherSession() throws SQLException, ClassNotFoundException{
        return sessionDao.findTeacherSession(this.IdSession);
    }

    /**
     * Créée la session
     * @param teacher
     */
    public void createSession(Teacher teacher) {
        sessionDao.createSession(this, teacher);
    }

    /**
     * Supprime la sesssion à l'aide de son id
     * @param idSession
     */
    public void deleteSession(String idSession) {
        sessionDao.deleteSession(idSession);
    }

    /**
     * Retourne true si le resultSet contient un élément
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String id) throws SQLException{
        return sessionDao.alreadyExist(id);
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec la sessionDao)
     * @param idGroup
     */
    public void resultSetSessionByIdGroup(String idGroup){
        sessionDao.resultSetSessionByIdGroup(idGroup);
    }

    /**
     * Remplit une session et retourne true tant qu'il y a une session dans le resultSet
     * (en lien avec la sessionDao)
     * @return
     */
    public boolean resultSetSessionByIdGroupNext(){
        return (sessionDao.resultSetSessionByIdGroupNext(this));
    }

    /**
     * Remplit le resultSet avec la requête sql
     * (en lien avec la sessionDao)
     * @param idTeacher
     */
    public void resultSetSessionForTeacher(String idTeacher){
        sessionDao.resultSetSessionForTeacher(idTeacher);
    }

    /**
     * Remplit une session et retourne true tant qu'il y a une session dans le resultSet
     * (en lien avec la sessionDao)
     * @return
     */
    public boolean resultSetSessionForTeacherNext(){
        return (sessionDao.resultSetSessionForTeacherNext(this));
    }

    /**
     * Retourne une liste de toutes les session
     * @param idGroup
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Session> getAllSessions(String idGroup) throws SQLException, ClassNotFoundException {
        ArrayList<Session> sessions = new ArrayList<>();
        Session session = new Session();
        session.resultSetSessionByIdGroup(idGroup);
        sessions.add(session);
        while(session.resultSetSessionByIdGroupNext()){
            sessions.add(new Session(session.getIdSession(),session.getWeek(),session.getDate(),session.getStartTime(),session.getEndTime(),session.getType(),session.getIdCourse(), session.getRoom(), session.getTeacherName(), session.getIdGroupSession()));
        }
        return sessions;
    }

    /**
     * Retourne le nombre de session par cours d'un groupe
     * @param idGroupPromotion
     * @param idCourse
     * @return
     * @throws SQLException
     */
    public int getNumberSessionsByCourse(String idGroupPromotion, String idCourse) throws SQLException {
        return sessionDao.getNumberSessionByCourse(idGroupPromotion, idCourse);
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
