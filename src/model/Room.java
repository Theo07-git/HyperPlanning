package model;

import model.dao.DAOFactory;
import model.dao.RoomDao;

import java.sql.SQLException;

public class Room {

    RoomDao roomDao;

    private String IdRoom;
    private int Capacity;
    private String NameRoom;

    public Room(String idRoom, int capacity, String nameRoom) {
        IdRoom = idRoom;
        Capacity = capacity;
        NameRoom = nameRoom;
    }

    public Room() throws ClassNotFoundException, SQLException {
        DAOFactory DAOInstance = new DAOFactory();
        roomDao = DAOInstance.getRoomDao();
    }

    public String getNameRoom() {
        return NameRoom;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public void setNameRoom(String nameRoom) {
        NameRoom = nameRoom;
    }

    public void setIdRoom(String idRoom) {
        IdRoom = idRoom;
    }
}
