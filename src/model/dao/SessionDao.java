package model.dao;

import model.Session;
import model.Student;
import model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionDao {

    private final Connection connect ;
    private ResultSet resultSet;

    public SessionDao(Connection connect){ this.connect = connect; }

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
}

