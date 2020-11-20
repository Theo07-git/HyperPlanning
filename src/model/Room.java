package model;

public class Room {

    protected String IdRoom;
    private int Capacity;
    private String NameRoom;

    public Room(String idRoom, int capacity, String nameRoom) {
        IdRoom = idRoom;
        Capacity = capacity;
        NameRoom = nameRoom;
    }
}
