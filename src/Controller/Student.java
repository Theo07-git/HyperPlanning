package Controller;

public class Student extends User {


    private int number;

    public Student(String id, String name, String lastName, String email, int permission, int number) {
        super(id, name, lastName, email, permission);
        this.number = number;
    }

    public void addCourse() {
        // appelle methode dans TeacherDAO

    }

    public void removeCourse() {

    }
}
