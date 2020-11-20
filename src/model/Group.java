package model;

import java.util.List;

//import com.mysql.cj.
public class Group {

    protected String IdGroup="";
    private String NameGroup="";
    private List<Course>GroupCours;
    private List<Student>GroupStudent;

    public Group(String idGroup, String nameGroup, List<Course> groupCours, List<Student> groupStudent) {
        IdGroup = idGroup;
        NameGroup = nameGroup;
        GroupCours = groupCours;
        GroupStudent = groupStudent;
    }

    public String getNameGroup() {
        return NameGroup;
    }

    public void setNameGroup(String nameGroup) {
        NameGroup = nameGroup;
    }

    public String getIdGroup() {
        return IdGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "IdGroup='" + IdGroup + '\'' +
                ", NameGroup='" + NameGroup + '\'' +
                ", GroupCours=" + GroupCours +
                ", GroupStudent=" + GroupStudent +
                '}';
    }
}
