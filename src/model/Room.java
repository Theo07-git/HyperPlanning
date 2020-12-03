package model;

import model.dao.DAOFactory;
import model.dao.RoomDao;

import java.sql.SQLException;

public class Room {

    RoomDao roomDao;
    private String idRoom;
    private int capacity;
    private String nameRoom;
    private String site;

    public Room(String idRoom, int capacity, String nameRoom, String site) throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        roomDao = DAOInstance.getRoomDao();
        this.idRoom = idRoom;
        this.capacity = capacity;
        this.nameRoom = nameRoom;
        this.site = site;
    }

    public Room() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        roomDao = DAOInstance.getRoomDao();
    }

    public Room findByName(String nameRoom) throws SQLException, ClassNotFoundException{
        return roomDao.findByName(nameRoom);
    }

    public String getIdRoom() {
        return idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public boolean alreadyExist(String nameRoom) throws SQLException{
        return roomDao.alreadyExist(nameRoom);
    }

    public void resultSetRoom(String nameSite){
        roomDao.resultSetRoomBySite(nameSite);
    }

    public boolean resultSetRoomNext(){
        return roomDao.resultSetRoomBySiteNext(this);
    }

    public void createRoom() throws SQLException {
        roomDao.createRoom(this);
    }

    public void deleteRoom(String nameRoom) throws SQLException {
        roomDao.deleteRoom(nameRoom);
    }
}
