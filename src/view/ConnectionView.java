package view;

import controller.ControllerConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


/**
 * From JFormDesigner
 */
public class ConnectionView {

    protected ControllerConnection controllerConnection;
    protected JFrame root;
    private String firstName;

    public ConnectionView(ControllerConnection controllerConnection, JFrame root) {
        initComponents();
        this.root = root;
        this.controllerConnection = controllerConnection;
        this.firstName = this.controllerConnection.firstName;
    }

    /**
     * Bouton "entrer" interface de connection, test de l'indientifiant et du mot de passe
     * @param e
     * @throws InterruptedException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void button1ActionPerformed(ActionEvent e) throws InterruptedException, SQLException, ClassNotFoundException {
        // TODO add your code here
        try {
            controllerConnection.isConnected(textField1.getText(), passwordField1.getText());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (controllerConnection.getIsConnect()) {
            try {
                controllerConnection.updateUser(getEmailActualUser());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            int permission = controllerConnection.testPermission();
            switch (permission) {
                case 0 -> System.out.println("Erreur - Permission non reconnu");
                case 1 -> {
                    root.setVisible(false);
                    AdminView adminView = new AdminView(controllerConnection, true);
                }
                case 2 -> {
                    root.setVisible(false);

                    AdminView adminView = new AdminView(controllerConnection, false);
                }
                case 3 -> {
                    root.setVisible(false);

                    TeacherView teacherView = new TeacherView(controllerConnection);}
                case 4 ->{
                    root.setVisible(false);
                    StudentView studentView = new StudentView(controllerConnection);}
            }
        }

        if(controllerConnection.getIsIdFaild()){
            IdFail.setVisible(true);
            controllerConnection.idFailed =false;
        }
    }

    /**
     * Fermer PopUp de type JDialog
     * @param e
     */
    private void buttonOkJDialogActionPerformed(ActionEvent e) {
        IdFail.dispose();
    }

    /**
     * Initialisation des composants du modèle
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - biollay
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        mail = new JLabel();
        password = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        button1 = new JButton();
        Background = new JLabel();
        IdFail = new JDialog();
        label5 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button2 = new JButton();
        transition = new JDialog();
        label6 = new JLabel();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setLayout(null);

                //---- label1 ----
                label1.setText(" ");
                label1.setIcon(new ImageIcon(getClass().getResource("/view/ressource/Image/ECE_Paris_Lyon (1).png")));
                panel2.add(label1);
                label1.setBounds(-45, -20, 315, 370);

                //---- mail ----
                mail.setText("Email :");
                mail.setFont(mail.getFont().deriveFont(mail.getFont().getStyle() | Font.BOLD, mail.getFont().getSize() + 2f));
                mail.setForeground(Color.black);
                panel2.add(mail);
                mail.setBounds(285, 105, 60, 21);

                //---- password ----
                password.setText("Password :");
                password.setFont(password.getFont().deriveFont(password.getFont().getStyle() | Font.BOLD, password.getFont().getSize() + 2f));
                password.setForeground(Color.black);
                panel2.add(password);
                password.setBounds(285, 145, 85, 26);
                panel2.add(textField1);
                textField1.setBounds(370, 100, 100, 30);
                panel2.add(passwordField1);
                passwordField1.setBounds(370, 140, 100, 30);

                //---- label4 ----
                label4.setText("Sign In");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 16f));
                label4.setForeground(Color.black);
                panel2.add(label4);
                label4.setBounds(335, 15, 105, 36);

                //---- button1 ----
                button1.setText("Entry");
                button1.setBackground(Color.black);
                button1.setForeground(Color.black);
                button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 1f));
                button1.setAutoscrolls(true);
                button1.setBorder(UIManager.getBorder("Spinner.border"));
                button1.addActionListener(e -> {
                    try {
                        button1ActionPerformed(e);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                });
                panel2.add(button1);
                button1.setBounds(440, 260, 65, 30);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(270, 220, 515, 305);

            //---- Background ----
            Background.setIcon(new ImageIcon(getClass().getResource("/view/ressource/Image/Mt. Fuji.jpg")));
            panel1.add(Background);
            Background.setBounds(-660, 0, 1770, 905);

            panel1.setPreferredSize(new Dimension(1015, 715));
        }

        //======== IdFail ========
        {
            var IdFailContentPane = IdFail.getContentPane();
            IdFailContentPane.setLayout(null);

            //---- label5 ----
            label5.setText("Please Try Again");
            IdFailContentPane.add(label5);
            label5.setBounds(20, 110, 160, 30);

            //---- label2 ----
            label2.setText("Connection Fail !");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 3f));
            label2.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
            IdFailContentPane.add(label2);
            label2.setBounds(25, 5, 215, 65);

            //---- label3 ----
            label3.setText("Incorrect Email or Password");
            IdFailContentPane.add(label3);
            label3.setBounds(20, 80, 270, 31);

            //---- button2 ----
            button2.setText("Ok");
            button2.addActionListener(e -> buttonOkJDialogActionPerformed(e));
            IdFailContentPane.add(button2);
            button2.setBounds(new Rectangle(new Point(190, 140), button2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < IdFailContentPane.getComponentCount(); i++) {
                    Rectangle bounds = IdFailContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = IdFailContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                IdFailContentPane.setMinimumSize(preferredSize);
                IdFailContentPane.setPreferredSize(preferredSize);
            }
            IdFail.pack();
            IdFail.setLocationRelativeTo(IdFail.getOwner());
        }

        //======== transition ========
        {
            transition.setBackground(Color.white);
            transition.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
            var transitionContentPane = transition.getContentPane();
            transitionContentPane.setLayout(null);

            //---- label6 ----
            label6.setText("Successful Connection");
            label6.setForeground(Color.black);
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 11f));
            transitionContentPane.add(label6);
            label6.setBounds(35, 20, 300, 75);

            transitionContentPane.setPreferredSize(new Dimension(395, 270));
            transition.pack();
            transition.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    /**
     * Récupération email dans jTextField
     * @return
     */
    public String getEmailActualUser() {
        String result = "";
        try {
            result = textField1.getText();
        } catch (NumberFormatException e) {
            System.out.println("Erreur avec l'entrée de l'Email");
        }
        return result;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - biollay
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel mail;
    private JLabel password;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JButton button1;
    private JLabel Background;
    private JDialog IdFail;
    private JLabel label5;
    private JLabel label2;
    private JLabel label3;
    private JButton button2;
    private JDialog transition;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JPanel getPanel1() {
        return panel1;
    }

}
