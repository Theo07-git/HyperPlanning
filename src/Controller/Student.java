package Controller;

public class Student extends User {


    private int StudentNumber;

    public Student(String id, String name, String lastName, String email, String password, String permission, int studentNumber) {
        super(id, name, lastName, email, password, permission);
        StudentNumber = studentNumber;
    }

    public Student(){}

    public void addCourse() {
        // appelle methode dans TeacherDAO

    }

    public void removeCourse() {

    }
}
