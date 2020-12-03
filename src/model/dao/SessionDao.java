package model.dao;

import model.Session;
import model.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionDao implements SessionDaoInterface {

    private final Connection connect ;
    private ResultSet resultSet;

    // Constructeur
    public SessionDao(Connection connect){ this.connect = connect; }

    /**
     * Retourne un professeur trouvé par son Id qui enseigne dans cette session
     * @param idSession
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Teacher findTeacherSession(String idSession) throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user JOIN teacher JOIN teachers_session JOIN session ON user.idUser = teacher.id_UserT AND teacher.id_UserT = teachers_session.id_TeacherTS AND teachers_session.id_SessionTS = session.idSession WHERE session.idSession = '" + idSession + "'");
            if(result.first()) {
                teacher = new Teacher(
                        result.getString("idUser"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"),
                        result.getString("id_CourseT")
                );
            }
            else System.out.println("Erreur identification eleve non trouve");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return teacher;
    }

    /**
     * Requête sql : insertion
     * Créée la session, la teacher_session, la room_session et la group_session
     * @param session
     * @param teacher
     */
    public void createSession(Session session, Teacher teacher) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO session VALUES('" + session.getIdSession() + "', '" + session.getWeek() + "', '" + session.getDate() + "', '" + session.getStartTime() + "', '" + session.getEndTime() + "', 'VALIDATED', '" + session.getIdCourse() + "', '" + session.getType() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO teachers_session VALUES('" + session.getIdSession() + "', '" + teacher.getId() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO rooms_session VALUES('" + session.getIdSession() + "', '" + session.getRoom().getIdRoom() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO groups_session VALUES('" + session.getIdSession() + "', '" + session.getIdGroupSession() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requête sql : suppression
     * Supprime la sesssion à l'aide de son id
     * @param idSession
     */
    public void deleteSession(String idSession) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM teachers_session WHERE (id_SessionTS = '" + idSession + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM rooms_session WHERE (id_SessionRS = '" + idSession + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM groups_session WHERE (id_SessionGS = '" + idSession + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM session WHERE idSession = '" + idSession + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne true si le resultSet contient un élément
     * --> si la session existe
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String id) throws SQLException {
        try {
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session WHERE idSession = " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resultSet.first()){
            return true;
        }else return false;
    }

    /**
     * Remplit le resultSet avec la requête sql
     * en fonction de l'id d'un groupe
     * @param idGroup
     */
    public void resultSetSessionByIdGroup(String idGroup)  {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session JOIN groups_session JOIN group_promotion JOIN room JOIN rooms_session \n" +
                    "ON session.idSession = groups_session.id_SessionGS\n" +
                    "AND groups_session.id_GroupGS = group_promotion.idGroupPromotion\n" +
                    "AND room.idRoom = rooms_session.id_RoomRS\n" +
                    "AND session.idSession = rooms_session.id_SessionRS\n" +
                    "WHERE group_promotion.idGroupPromotion ='" + idGroup + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplit une session en fonction de l'id d'un groupe et retourne true tant qu'il y a une session dans le resultSet
     * @param session
     * @return
     */
    public boolean resultSetSessionByIdGroupNext(Session session){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                session.setIdSession(resultSet.getString("idSession"));
                session.setWeek(resultSet.getInt("week"));
                session.setDate(resultSet.getDate("date"));
                session.setStartTime(resultSet.getTime("start_time"));
                session.setEndTime(resultSet.getTime("end_time"));
                session.setType(resultSet.getString("id_type"));
                session.setIdCourse(resultSet.getString("id_course"));
                session.setRoom(resultSet.getString("idRoom"),resultSet.getInt("capacity"),resultSet.getString("room.name"));
                session.setTeacherName(session.findTeacherSession().getLastName());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    /**
     * Remplit le resultSet avec la requête sql
     * en fonction de l'id d'un professeur
     * @param idTeacher
     */
    public void resultSetSessionForTeacher(String idTeacher){
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session \n" +
                    "JOIN teachers_session \n" +
                    "    ON teachers_session.id_SessionTS = session.idSession\n" +
                    "JOIN teacher\n" +
                    "    ON teacher.id_UserT = teachers_session.id_TeacherTS\n" +
                    "JOIN rooms_session \n" +
                    "    ON session.idSession = rooms_session.id_SessionRS\n" +
                    "JOIN room\n" +
                    "    ON room.idRoom = rooms_session.id_RoomRS\n" +
                    "JOIN groups_session\n" +
                    "    ON groups_session.id_SessionGS = session.idSession\n" +
                    "WHERE teacher.id_UserT ='" + idTeacher  + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplit une session en fonction de l'id d'un professeur et retourne true tant qu'il y a une session dans le resultSet
     * @param session
     * @return
     */
    public boolean resultSetSessionForTeacherNext(Session session){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                session.setIdSession(resultSet.getString("idSession"));
                session.setWeek(resultSet.getInt("week"));
                session.setDate(resultSet.getDate("date"));
                session.setStartTime(resultSet.getTime("start_time"));
                session.setEndTime(resultSet.getTime("end_time"));
                session.setType(resultSet.getString("id_type"));
                session.setIdCourse(resultSet.getString("id_course"));
                session.setRoom(resultSet.getString("idRoom"),resultSet.getInt("capacity"),resultSet.getString("room.name"));
                session.setIdGroupSession(resultSet.getString("id_GroupGS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    /**
     * Retourne le nombre de session par cours d'un groupe
     * @param idGroupPromotion
     * @param idCourse
     * @return
     */
    public int getNumberSessionByCourse(String idGroupPromotion, String idCourse) {
        int nbStudents = 0;
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM session\n" +
                    "JOIN groups_session \n" +
                    "ON session.idSession = groups_session.id_SessionGS\n" +
                    "JOIN group_promotion\n" +
                    "ON groups_session.id_GroupGS = group_promotion.idGroupPromotion\n" +
                    "WHERE group_promotion.idGroupPromotion = '" + idGroupPromotion + "'\n" +
                    "AND session.id_course = '" + idCourse + "'");
            if(resultSet.first()){
                nbStudents = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nbStudents;
    }
}

