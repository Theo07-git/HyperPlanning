package view;

import controller.ControllerTeacher;
import controller.ControllerConnection;
import view.ressource.Planning;
import view.ressource.TeacherHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TeacherView {

    public TeacherView(ControllerConnection controllerConnection) throws SQLException, ClassNotFoundException {
        JFrame jFrame = new JFrame();

        interfaceTeacher(jFrame, controllerConnection.getUser().getId(), controllerConnection);
        jFrame.setTitle(controllerConnection.getUser().getFirstName() + " " + controllerConnection.getUser().getLastName());
        jFrame.setSize(1200,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLocation(50, 0);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * Initialisation & Affichage de l'interface Professeur
     * @param jFrame
     * @param idUser
     * @param controllerConnection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void interfaceTeacher(JFrame jFrame, String idUser, ControllerConnection controllerConnection) throws SQLException, ClassNotFoundException {
        ControllerTeacher controllerTeacher = new ControllerTeacher(idUser);

        // Création de la barre menu
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        // Création des menus
        JMenu menuTeacher = new JMenu("Accueil");
        JMenu menuPersonalInfos = new JMenu("Informations personelles");

        // Ajout des menus dans la barre de menu
        menuBar.add(menuTeacher);
        menuBar.add(menuPersonalInfos);

        // Création des items
        JMenuItem miHome = new JMenuItem("Accueil");
        JMenuItem miTeacherPlanning = new JMenuItem("Emploi du temps");
        JMenuItem miTeacherAccount = new JMenuItem("Compte");

        // Ajout des items dans le menu
        menuTeacher.add(miHome);
        menuTeacher.add(miTeacherPlanning);
        menuPersonalInfos.add(miTeacherAccount);

        TeacherHomePage teacherHomePage = new TeacherHomePage(controllerConnection);
        jFrame.setContentPane(teacherHomePage.panel1);

        // Action sélection item
        miHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    interfaceTeacher(jFrame,idUser, controllerConnection);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        miTeacherPlanning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createTeacherPlanning(jFrame, controllerTeacher);
            }
        });
        miTeacherAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createPersonalInfos(jFrame, controllerTeacher);
            }
        });

        jFrame.setVisible(true);
    }


    /**
     * Création Planning Professeur
     * @param jFrame
     * @param controllerTeacher
     */
    public void createTeacherPlanning(JFrame jFrame, ControllerTeacher controllerTeacher){
        JLabel jLabelWeek = new JLabel("Semaine :");
        jLabelWeek.setBounds(40, 10, 100, 28);
        String[] week = new String[53];
        for (int i = 0; i <= 52; i++) {
            week[i] = String.valueOf(i+1);
        }
        JComboBox jComboBoxSelectWeek = new JComboBox(week);
        jComboBoxSelectWeek.setBounds(40, 40, 80, 28);
        Planning planning = new Planning();
        planning.setSettings(jFrame);
        jComboBoxSelectWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.add(jComboBoxSelectWeek);
                for(int i = 0; i < week.length; i++) {
                    if(jComboBoxSelectWeek.getSelectedIndex() == i){
                        try {
                            planning.DrawTeacherPlanningForTeacher(jFrame, controllerTeacher.getTeacher().getId(), i+1);
                        } catch (SQLException | ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                jFrame.repaint();
                planning.setSettings(jFrame);
                jFrame.add(planning);
            }
        });

        jFrame.add(jLabelWeek);
        jFrame.add(planning);
        jFrame.add(jComboBoxSelectWeek);
        jFrame.setLayout(null);
        jFrame.setOpacity(1);
        jFrame.setVisible(true);
    }

    /**
     * Création onglet Mon Compte contenant les informations personelles
     * @param jFrame
     * @param controllerTeacher
     */
    public void createPersonalInfos(JFrame jFrame, ControllerTeacher controllerTeacher){
        JLabel jLabelAcount = new JLabel("Compte");
        jLabelAcount.setBounds(20, 20, 100, 28);

        JLabel jLabelId = new JLabel("Identifiant :");
        jLabelId.setBounds(40, 50, 300, 28);
        JTextField jTextFieldId = new JTextField(controllerTeacher.getTeacher().getId());
        jTextFieldId.setBounds(40, 80, 300, 28);

        JLabel jLabelLastName = new JLabel("Nom :");
        jLabelLastName.setBounds(40, 110, 300, 28);
        JTextField jTextFieldLastName = new JTextField(controllerTeacher.getTeacher().getLastName());
        jTextFieldLastName.setBounds(40, 140, 300, 28);

        JLabel jLabelFirstName = new JLabel("Prenom :");
        jLabelFirstName.setBounds(40, 170, 300, 28);
        JTextField jTextFieldFirstName = new JTextField(controllerTeacher.getTeacher().getFirstName());
        jTextFieldFirstName.setBounds(40, 200, 300, 28);

        JLabel jLabelEmail = new JLabel("Email :");
        jLabelEmail.setBounds(40, 230, 300, 28);
        JTextField jTextFieldEmail = new JTextField(controllerTeacher.getTeacher().getEmail());
        jTextFieldEmail.setBounds(40, 260, 300, 28);

        JLabel jLabelPassword = new JLabel("Mot de passe :");
        jLabelPassword.setBounds(40, 290, 300, 28);
        JPasswordField jPasswordFieldPassword = new JPasswordField(controllerTeacher.getTeacher().getPassword());
        jPasswordFieldPassword.setBounds(40, 310, 300, 28);

        JButton jButtonChangePassword = new JButton("Modifier le mot de passe");
        jButtonChangePassword.setBounds(350, 310, 200, 28);

        JLabel jLabelCourse = new JLabel("Matiere :");
        jLabelCourse.setBounds(40, 340, 300, 28);
        JTextField jTextFieldCourse = new JTextField(controllerTeacher.getTeacher().getIdCourse());
        jTextFieldCourse.setBounds(40, 370, 300, 28);

        //set editabilite
        jTextFieldId.setEditable(false);
        jTextFieldLastName.setEditable(false);
        jTextFieldFirstName.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jPasswordFieldPassword.setEditable(false);
        jTextFieldCourse.setEditable(false);

        // Ajout des element à la JFrame
        jFrame.add(jLabelAcount);
        jFrame.add(jLabelId);
        jFrame.add(jTextFieldId);
        jFrame.add(jLabelLastName);
        jFrame.add(jTextFieldLastName);
        jFrame.add(jLabelFirstName);
        jFrame.add(jTextFieldFirstName);
        jFrame.add(jLabelEmail);
        jFrame.add(jTextFieldEmail);
        jFrame.add(jLabelPassword);
        jFrame.add(jButtonChangePassword);
        jFrame.add(jPasswordFieldPassword);
        jFrame.add(jLabelCourse);
        jFrame.add(jTextFieldCourse);

        jButtonChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createChangePassword(jFrame, controllerTeacher);
                jFrame.repaint();
            }
        });

        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    /**
     * Modification du mot de passe
     * @param jFrame
     * @param controllerTeacher
     */
    public void createChangePassword(JFrame jFrame, ControllerTeacher controllerTeacher){
        JLabel jLabelModifPassword = new JLabel("Entrer le nouveau mot de passe :");
        jLabelModifPassword.setBounds(560, 290, 300, 28);
        JTextField jTextFieldNewPassword = new JTextField(controllerTeacher.getTeacher().getPassword());
        jTextFieldNewPassword.setBounds(560, 310, 200, 28);
        JButton jButtonCancel = new JButton("Annuler");
        jButtonCancel.setBounds(560, 340, 100, 28);
        JButton jButtonOk = new JButton("Valider");
        jButtonOk.setBounds(660, 340, 100, 28);

        jFrame.add(jLabelModifPassword);
        jFrame.add(jTextFieldNewPassword);
        jFrame.add(jButtonCancel);
        jFrame.add(jButtonOk);

        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().remove(jLabelModifPassword);
                jFrame.getContentPane().remove(jTextFieldNewPassword);
                jFrame.getContentPane().remove(jButtonCancel);
                jFrame.getContentPane().remove(jButtonOk);
                jFrame.repaint();
            }
        });
        jButtonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().remove(jLabelModifPassword);
                jFrame.getContentPane().remove(jTextFieldNewPassword);
                jFrame.getContentPane().remove(jButtonCancel);
                jFrame.getContentPane().remove(jButtonOk);
                jFrame.repaint();
                controllerTeacher.getTeacher().updatePassword(jTextFieldNewPassword.getText());
            }
        });
        jFrame.setVisible(true);
    }
}
