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

    // Constructeurs
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

    // Getters
    public String getIdRoom() {
        return idRoom;
    }
    public String getNameRoom() {
        return nameRoom;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getSite() {
        return site;
    }

    //Setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }
    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * Retourne une salle trouvé par son nom
     * @param nameRoom
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Room findByName(String nameRoom) throws SQLException, ClassNotFoundException{
        return roomDao.findByName(nameRoom);
    }

    /**
     * Creee la salle
     * @throws SQLException
     */
    public void createRoom() throws SQLException {
        roomDao.createRoom(this);
    }

    /**
     * Supprime la salle à l'aide de son id
     * @param nameRoom
     * @throws SQLException
     */
    public void deleteRoom(String nameRoom) throws SQLException {
        roomDao.deleteRoom(nameRoom);
    }

    /**
     * Retourne true si la salle existe en fonction de son nom
     * @param nameRoom
     * @return
     * @throws SQLException
     */
    public boolean alreadyExist(String nameRoom) throws SQLException{
        return roomDao.alreadyExist(nameRoom);
    }

    /**
     * Rempli le resultSet avec la requête sql
     * (en lien avec roomDao)
     * @param nameSite
     */
    public void resultSetRoom(String nameSite){
        roomDao.resultSetRoomBySite(nameSite);
    }

    /**
     * Remplie une salle et retourne true tant qu'il y a une salle dans le resultSet
     * (en lien avec roomDao)
     * @return
     */
    public boolean resultSetRoomNext(){
        return roomDao.resultSetRoomBySiteNext(this);
    }
}
