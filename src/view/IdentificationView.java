package view;

import controller.TestConnection;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class IdentificationView extends JFrame implements Observer {

    private JTextField textFieldId;
    private JPasswordField textFieldPassword;

    public IdentificationView(TestConnection testConnection){
        JFrame frame = new JFrame("Menu Identification");
        frame.setTitle("Menu Identification");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);

        /* Iniatialisation des parametres de base de la pages */

        setLayout(null);

        JLabel label_id = new JLabel("Identifiant :");
        JLabel label_mdp = new JLabel("Mot de Passe :");
        textFieldId = new JTextField();
        textFieldPassword = new JPasswordField();
        JButton entryButton = new JButton("Entrez");
        JPanel PanelForButtonEntry = new JPanel();

        label_id.setBounds(40, 90, 100, 50);
        textFieldId.setBounds(140, 110, 100, 15);
        label_mdp.setBounds(40, 115, 100, 50);
        textFieldPassword.setBounds(140, 135, 100, 15);
        PanelForButtonEntry.setBounds(180, 200, 100, 50);

        frame.add(label_id);
        frame.add(label_mdp);
        frame.add(textFieldId);
        frame.add(textFieldPassword);
        PanelForButtonEntry.add(entryButton);
        frame.getContentPane().add(PanelForButtonEntry);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        entryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    testConnection.isConnected(textFieldId.getText(), textFieldPassword.getText());

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                if (testConnection.getIsConnect()) {
                    try {
                        testConnection.updateUser(getEmailActualUser(), getPasswordActualUser());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                    int permission = testConnection.testPermission();
                    System.out.println(permission);
                    switch (permission) {
                        case 0 -> System.out.println("Erreur - Permission non reconnu");
                        case 1 -> {
                            AdminView adminView = new AdminView(testConnection);
                        }
                        case 2 -> System.out.println("2");
                        case 3 -> System.out.println("3");
                        case 4 -> System.out.println("4");
                    }
                    testConnection.getActualUser();
                    frame.dispose();
                }
            }
        });
    }

    public String getEmailActualUser() {
        String result = "";
        try {
            result = textFieldId.getText();
        } catch (NumberFormatException e) {
            System.out.println("Erreur avec l'entrée de l'Email");
        }
        return result;
    }

    public String getPasswordActualUser() {
        String result = "";
        try {
            result = textFieldPassword.getText();
        } catch (NumberFormatException e) {
            System.out.println("Erreur avec l'entrée du mot de passe");
        }
        return result;
    }

    @Override
    public void update(Observable o, Object arg) {
        display("" + ((User) arg).getEmail());
    }

    public void display(String email) {
        this.textFieldId.setText(email);
    }
}
