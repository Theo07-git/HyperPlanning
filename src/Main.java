import Controller.*;
import Model.DAO;
import Model.DAOFactory;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args ) throws SQLException, ClassNotFoundException {

        System.out.println("Hyper Planning");
        String url ="jdbc:mysql://localhost:3306/hyperplanning?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DAOFactory DAOInstance = new DAOFactory(url, "root", "planning$*");
        DAO<User> UserDao = DAOInstance.getUserDao();
        User user = UserDao.find("0001");
        System.out.println(user.toString());
        System.out.println("End Hyper planning");
    }

}
