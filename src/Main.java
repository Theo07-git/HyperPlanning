import controller.ControllerConnection;
import model.User;
import view.ConnectionView;
import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        User actualUser = new User();

        ControllerConnection controllerConnection = new ControllerConnection(actualUser);

        // Création de la fenêtre
        JFrame jFrame = new JFrame();
        jFrame.setSize(905,690);
        jFrame.setLocationRelativeTo(null);

        // Création de le View
        ConnectionView ID = new ConnectionView(controllerConnection, jFrame);

        // Actions sur la frame avec la View
        jFrame.setContentPane(ID.getPanel1());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        while (!controllerConnection.isConnect){}

        // Fermeture de la fenêtre
        jFrame.dispose();
    }
}
