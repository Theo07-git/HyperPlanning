package Controller;

import java.util.List;

public class Site {

    protected String IdSite;
    private String NameSite="";
    private List<Room> RoomSite;

    public Site(String idSite, String nameSite, List<Room> roomSite) {
        IdSite = idSite;
        NameSite = nameSite;
        RoomSite = roomSite;
    }

    public String getNameSite() {
        return NameSite;
    }

    public String getIdSite() {
        return IdSite;
    }
}
