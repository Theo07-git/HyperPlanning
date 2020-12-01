package view;

import controller.TestConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ConnectionView  {
    public JPanel panel1;
    protected  TestConnection testConnection;

    public ConnectionView(TestConnection TestConnection) {
        panel1 = initComponents();
        this.testConnection = TestConnection;
    }


    private void EntryActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        // TODO add your code here
        try {
            testConnection.isConnected(textField1.getText(), passwordField1.getText());

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
                case 3 -> {
                    TeacherView teacherView = new TeacherView(testConnection);
                }
                case 4 -> {
                    StudentView studentView = new StudentView(testConnection);
                }
            }
            testConnection.getActualUser();
        }
    }

    private JPanel initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        var panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        textField1 = new JTextField();
        Entry = new JButton();
        var BackGround = new JLabel();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("Email :");
            label2.setForeground(Color.white);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 1f));
            panel1.add(label2);
            label2.setBounds(305, 375, 65, 26);

            //---- label3 ----
            label3.setText("Password :");
            label3.setForeground(Color.white);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 1f));
            panel1.add(label3);
            label3.setBounds(305, 410, 80, 26);
            panel1.add(passwordField1);
            passwordField1.setBounds(400, 415, 95, 25);
            panel1.add(textField1);
            textField1.setBounds(400, 375, 95, 25);

            //---- Entry ----
            Entry.setText("Sign In");
            Entry.setForeground(new Color(0, 111, 240));
            Entry.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
            Entry.setSelectedIcon(null);
            Entry.setActionCommand("Log In");
            Entry.addActionListener(e -> {
                try {
                    EntryActionPerformed(e);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            });
            panel1.add(Entry);
            Entry.setBounds(520, 395, 85, 25);

            //---- BackGround ----
            BackGround.setIcon(new ImageIcon(getClass().getResource("/view/Ressource/Blue Pond.jpg")));
            BackGround.setText(" ");
            BackGround.setForeground(Color.white);
            BackGround.setFont(BackGround.getFont().deriveFont(BackGround.getFont().getStyle() & ~Font.ITALIC));
            panel1.add(BackGround);
            BackGround.setBounds(0, 0, 905, 690);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        return panel1;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton Entry;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public String getEmailActualUser() {
        String result = "";
        try {
            result = textField1.getText();
        } catch (NumberFormatException e) {
            System.out.println("Erreur avec l'entrée de l'Email");
        }
        return result;
    }

    public String getPasswordActualUser() {
        String result = "";
        try {
            result = passwordField1.getText();
        } catch (NumberFormatException e) {
            System.out.println("Erreur avec l'entrée du mot de passe");
        }
        return result;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
