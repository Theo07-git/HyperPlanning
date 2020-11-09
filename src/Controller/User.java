package Controller;

public  class User {

    protected String Id = "";
    protected String Email = "";
    protected String Password = "";
    protected String LastName = "";
    protected String FirstName = "";
    protected String Permission;

    public User(String id, String email, String password, String lastName, String firstName, String permission) {
        Id = id;
        Email = email;
        Password = password;
        LastName = lastName;
        FirstName = firstName;
        Permission = permission;
    }

    public User(){}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
