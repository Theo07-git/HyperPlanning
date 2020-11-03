package Controller;

import java.util.List;

public class Teacher extends User {

    private List<Course> myCourses;


    public Teacher(String id, String name, String lastName, String email, int permission, List<Course> myCourses) {
        super(id, name, lastName, email, permission);
        this.myCourses = myCourses;
    }

    public void addCourse() {
    // appelle methode dans TeacherDAO
    }


    public void removeCourse() {
        // appelle methode dans TeacherDAO
    }
}
