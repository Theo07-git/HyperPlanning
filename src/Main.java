import controller.TestConnection;
import model.User;
import view.ConnectionView;

import javax.swing.*;
import java.sql.SQLException;


public class Main {



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User actualUser = new User();
        TestConnection testConnection = new TestConnection(actualUser);
        JFrame jFrame = new JFrame();

        jFrame.setSize(905,690);
        jFrame.setLocationRelativeTo(null);
        ConnectionView ID = new ConnectionView(testConnection, jFrame);
        jFrame.setContentPane(ID.getPanel1());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        while (!testConnection.isConnect){
        }
        jFrame.dispose();
    }
    
}
