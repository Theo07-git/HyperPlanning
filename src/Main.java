import controller.TestConnection;
import model.*;
import view.AdminView;
import view.IdentificationView;
import view.MainView;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        User actualUser = new User();

        TestConnection testConnection = new TestConnection(actualUser);

        IdentificationView idView = new IdentificationView(testConnection);

        actualUser.addObserver(idView);




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
