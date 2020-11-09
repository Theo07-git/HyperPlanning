import Controller.*;
import Model.DAO;
import Model.DAOFactory;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hyper Planning");
        DAOFactory DAOInstance = new DAOFactory();
        DAO<User> userDao = DAOInstance.getUserDao();
        DAO<User> userDao1 = DAOInstance.getUserDao();
        DAO<User> userDao2 = DAOInstance.getUserDao();
        DAO<User> userDao3 = DAOInstance.getUserDao();
        //DAO<Student> studentDao = DAOInstance.getStudentDao();
        User user = userDao.findById("0001");
        User user1 = userDao1.findByEmail("re@ece.fr");
        User user2 = userDao2.findById("0012");
        User user3 = userDao3.findByLastName("OIN");
        //Student student = studentDao.find("0012");

        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        //System.out.println(student.toString());
        System.out.println("End Hyper planning");
    }

}
