package model.dao;

import model.Room;
import model.Site;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDao {
    private Connection connect = null;
    ResultSet resultSet;

    public RoomDao(Connection connect){ this.connect = connect; }

    public Room findByName(String nameRoom) throws SQLException, ClassNotFoundException {
        Room room = new Room();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM room WHERE name = '" + nameRoom + "'");
            if(result.first())
                room = new Room(
                        result.getString("idRoom"),
                        result.getInt("capacity"),
                        nameRoom,
                        result.getString("id_site"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return room;
    }

    public boolean alreadyExist(String nameRoom) throws SQLException {
        try {
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM room WHERE name = '" + nameRoom + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resultSet.first()){
            return true;
        }else return false;
    }

    public void resultSetRoomBySite(String nameSite)  {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM room JOIN site\n" +
                    "ON room.id_site = site.idSite\n" +
                    "WHERE site.name ='" + nameSite + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean resultSetRoomBySiteNext(Room room){
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                room.setIdRoom(resultSet.getString("idRoom"));
                room.setNameRoom(resultSet.getString("room.name"));
                room.setCapacity(resultSet.getInt("capacity"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }

    public void createRoom(Room room){
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                "INSERT INTO room VALUES('" + room.getIdRoom() + "', '" + room.getNameRoom() + "', '" + room.getCapacity() + "', '" + room.getSite() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(String nameRoom){
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM room WHERE (name = '" + nameRoom + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
