package view;

import controller.TestConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class IdentificationView extends JFrame{

    public IdentificationView() {}

    public void displayIdentificationView(){
        JFrame frame = new JFrame("Menu Identification");
        frame.setTitle("Menu Identification");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);

        /* Iniatialisation des parametres de base de la pages */

        setLayout(null); // pour permettre placement à la main des composants

        JLabel label_id = new JLabel("Identifiant :");
        JLabel label_mdp = new JLabel("Mot de Passe :");
        JTextField textField_id = new JTextField();
        JPasswordField textField_mdp = new JPasswordField();
        JButton entryButton = new JButton("Entrez");
        JPanel PanelForButtonEntry = new JPanel();

        label_id.setBounds(40, 90, 100, 50);
        textField_id.setBounds(140, 110, 100, 15);
        label_mdp.setBounds(40, 115, 100, 50);
        textField_mdp.setBounds(140, 135, 100, 15);
        PanelForButtonEntry.setBounds(180, 200, 100, 50);

        frame.add(label_id);
        frame.add(label_mdp);
        frame.add(textField_id);
        frame.add(textField_mdp);
        PanelForButtonEntry.add(entryButton);
        frame.getContentPane().add(PanelForButtonEntry);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        entryButton.addActionListener(e -> {
            TestConnection testConnection = new TestConnection();

            try {
                testConnection.isConnected(textField_id.getText(), textField_mdp.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

            if(testConnection.getIsConnect()){
                JFrame frameTest = new JFrame("Menu Identification");
                frameTest.setTitle("Menu Identification");
                frameTest.setSize(300, 300);
                frameTest.setVisible(true);
            }
        });
    }

}
