package Controller;

public class Student extends User {

    private int StudentNumber;

    public Student(String id, String email, String password, String lastName, String firstName, String permission, int studentNumber) {
        super(id, email, password, lastName, firstName, permission);
        StudentNumber = studentNumber;
    }

    public Student(){}

    public void addCourse() {
        // appelle methode dans TeacherDAO

    }

    public void removeCourse() {

    }
}
