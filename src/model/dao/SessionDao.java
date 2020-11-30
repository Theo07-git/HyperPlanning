package model.dao;

import model.Session;

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
                session.setRoom(resultSet.getString("idRoom"),resultSet.getInt("capacity"),resultSet.getString("name"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }


}
