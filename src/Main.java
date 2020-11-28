import controller.TestConnection;
import model.User;
import view.ConnectionView;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {



        User actualUser = new User();

        TestConnection testConnection = new TestConnection(actualUser);

        JFrame id_root = new JFrame();
        id_root.setSize(905,690);
        id_root.setLocationRelativeTo(null);
        id_root.setContentPane(new ConnectionView(testConnection).panel1);
        id_root.pack();
        id_root.setVisible(true);
        while (!testConnection.isConnect){
        }
        id_root.dispose();

/*
        User actualUser = new User();

        TestConnection testConnection = new TestConnection(actualUser);

        IdentificationView idView = new IdentificationView(testConnection);

        actualUser.addObserver(idView);

        List<Student> students = new ArrayList<>();

        Student student = new Student();
        student.resultSetByGroupPromotion("ING1GR1");
        students.add(student);

        ArrayList<String> allStudent = new ArrayList<>();
        while(student.resultSetByGroupPromotionNext()){
            students.add(student);
            assert allStudent != null;
            allStudent.add(student.toString());
        }
        System.out.println(allStudent);*/




        /*Student user = new Student();
        user.resultSetByGroupPromotion("ING1GR1");

        while(user.resultSetByGroupPromotionNext()){
            System.out.println(user.toString());
        }*/

        /*User user2 = new User();
        user2.ResultSetByName();

        while(user2.ResultSetByNameNext()){
            System.out.println(user2.toString());
        }*/


        /* System.out.println("Hyper Planning");
        MainView iMainView = new MainView();
        iMainView.Display();
        System.out.println("End Hyper planning");
        System.out.println("tes morts");
        Course course = new Course();
        Course course1 = new Course();
        course = course.findById("MATH");
        course1 = course1.findByName("Physics");

        System.out.println(course.toString());
        System.out.println(course1.toString());

        Group group = new Group();
        Group group1 = new Group();
        group = group.findById("ING1GR1");
        group1 = group1.findByName("Third year group 1");

        System.out.println(group.toString());
        System.out.println(group1.toString());*/

    }

}
