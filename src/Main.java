import controller.TestConnection;
import model.User;
import view.ConnectionViewV2;

import javax.swing.*;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        User actualUser = new User();

        TestConnection testConnection = new TestConnection(actualUser);

        JFrame id_root = new JFrame();
        id_root.setSize(905,690);
        id_root.setLocationRelativeTo(null);
        ConnectionViewV2 ID = new ConnectionViewV2(testConnection,id_root);
        id_root.setContentPane(ID.getPanel1());
        id_root.pack();
        id_root.setVisible(true);
        while (!testConnection.isConnect){

        }
        id_root.dispose();
    }
}
