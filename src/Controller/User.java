package Controller;

public  class User {

    protected String Id = "";
    private String Name = "";
    private String LastName = "";
    private String Email = "";
    private String Password ="";
    private int Permission; // ou enum ?

    public User(String id, String name, String lastName, String email, String password, int permission) {
        Id = id;
        Name = name;
        LastName = lastName;
        Email = email;
        Password = password;
        Permission = permission;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int permission) {
        Permission = permission;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
