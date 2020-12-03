package model.dao;

import model.Room;
import java.sql.SQLException;

public interface RoomDaoInterface {

    // Création/Suppression d'une salle
    void createRoom(Room room);
    void deleteRoom(String nameRoom);

    // Trouver la salle
    Room findByName(String nameRoom) throws SQLException, ClassNotFoundException;

    // Vérification si la salle existe déjà
    boolean alreadyExist(String nameRoom) throws SQLException;

    // Parcourir toutes les salles
    void resultSetRoomBySite(String nameSite);
    boolean resultSetRoomBySiteNext(Room room);
}
