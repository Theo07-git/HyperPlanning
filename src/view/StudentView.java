package view;

import controller.ControllerStudent;
import controller.TestConnection;
import view.ressource.Planning;
import view.ressource.StudentHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

public class StudentView  {

    public StudentView(TestConnection testConnection) throws SQLException, ClassNotFoundException {
        JFrame jFrame = new JFrame();

        interfaceStudent(jFrame, testConnection.getUser().getId(), testConnection);
        jFrame.setTitle(testConnection.getUser().getFirstName() + " " + testConnection.getUser().getLastName());
        jFrame.setSize(1200,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLocation(50, 0);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void interfaceStudent(JFrame jFrame, String idUser, TestConnection testConnection) throws SQLException, ClassNotFoundException {
        ControllerStudent controllerStudent = new ControllerStudent(idUser);

        // Création de la barre menu
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        // Création des menus
        JMenu menuStudent = new JMenu("Accueil");
        JMenu menuPersonalInfos = new JMenu("Informations personelles");

        // Ajout des menus dans la barre de menu
        menuBar.add(menuStudent);
        menuBar.add(menuPersonalInfos);

        // Création des items
        JMenuItem miHome = new JMenuItem("Accueil");
        JMenuItem miStudentPlanning = new JMenuItem("Emploi du temps");
        JMenuItem miStudentAccount = new JMenuItem("Compte");

        // Ajout des items dans le menu
        menuStudent.add(miHome);
        menuStudent.add(miStudentPlanning);
        menuPersonalInfos.add(miStudentAccount);


        StudentHomePage studentHomePage = new StudentHomePage(testConnection);
        jFrame.add(studentHomePage.panel1);

        // Action sélection item

        miHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                jFrame.add(studentHomePage.panel1);
                jFrame.setVisible(true);

            }
        });
        miStudentPlanning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createStudentPlanning(jFrame, controllerStudent);
            }
        });
        miStudentAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createPersonalInfos(jFrame, controllerStudent);
            }
        });

        //createStudentPlanning(jFrame, controllerStudent);
        jFrame.setVisible(true);
    }

    public void createStudentPlanning(JFrame jFrame, ControllerStudent controllerStudent){
        JLabel jLabelWeek = new JLabel("Choisis ta semaine :");
        jLabelWeek.setBounds(20, 10, 250, 28);
        String[] week = new String[53];
        for (int i = 0; i < 52; i++) {
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
                            planning.DrawStudentPlanningForStudent(jFrame, controllerStudent.getStudent().getIdGroupPromotion(), controllerStudent.getStudent().getId(), Integer.parseInt(Objects.requireNonNull(jComboBoxSelectWeek.getSelectedItem()).toString()));
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

    public void createPersonalInfos(JFrame jFrame, ControllerStudent controllerStudent){
        JLabel jLabelAcount = new JLabel("Compte");
        jLabelAcount.setBounds(20, 20, 100, 28);

        JLabel jLabelId = new JLabel("Identifiant :");
        jLabelId.setBounds(40, 50, 300, 28);
        JTextField jTextFieldId = new JTextField(controllerStudent.getStudent().getId());
        jTextFieldId.setBounds(40, 80, 300, 28);

        JLabel jLabelLastName = new JLabel("Nom :");
        jLabelLastName.setBounds(40, 110, 300, 28);
        JTextField jTextFieldLastName = new JTextField(controllerStudent.getStudent().getLastName());
        jTextFieldLastName.setBounds(40, 140, 300, 28);

        JLabel jLabelFirstName = new JLabel("Prenom :");
        jLabelFirstName.setBounds(40, 170, 300, 28);
        JTextField jTextFieldFirstName = new JTextField(controllerStudent.getStudent().getFirstName());
        jTextFieldFirstName.setBounds(40, 200, 300, 28);

        JLabel jLabelEmail = new JLabel("Email :");
        jLabelEmail.setBounds(40, 230, 300, 28);
        JTextField jTextFieldEmail = new JTextField(controllerStudent.getStudent().getEmail());
        jTextFieldEmail.setBounds(40, 260, 300, 28);

        JLabel jLabelPassword = new JLabel("Mot de passe :");
        jLabelPassword.setBounds(40, 290, 300, 28);
        JPasswordField jPasswordFieldPassword = new JPasswordField(controllerStudent.getStudent().getPassword());
        jPasswordFieldPassword.setBounds(40, 310, 300, 28);

        JButton jButtonModifPassword = new JButton("Modifier le mot de passe");
        jButtonModifPassword.setBounds(350, 310, 200, 28);

        JLabel jLabelNumber = new JLabel("Numero :");
        jLabelNumber.setBounds(40, 340, 300, 28);
        JTextField jTextFieldNumber = new JTextField(controllerStudent.getStudent().getStudentNumber());
        jTextFieldNumber.setBounds(40, 370, 300, 28);

        JLabel jLabelIdGroup = new JLabel("Groupe de l'eleve :");
        jLabelIdGroup.setBounds(40, 400, 300, 28);
        JTextField jTextFielIdGroup = new JTextField(controllerStudent.getStudent().getIdGroupPromotion());
        jTextFielIdGroup.setBounds(40, 430, 300, 28);

        //set editabilite
        jTextFieldId.setEditable(false);
        jTextFieldLastName.setEditable(false);
        jTextFieldFirstName.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jPasswordFieldPassword.setEditable(false);
        jTextFieldNumber.setEditable(false);
        jTextFielIdGroup.setEditable(false);

        // Ajout des element à la JFrame
        jFrame.add(jLabelId);
        jFrame.add(jTextFieldId);
        jFrame.add(jLabelLastName);
        jFrame.add(jTextFieldLastName);
        jFrame.add(jLabelFirstName);
        jFrame.add(jTextFieldFirstName);
        jFrame.add(jLabelEmail);
        jFrame.add(jTextFieldEmail);
        jFrame.add(jLabelPassword);
        jFrame.add(jButtonModifPassword);
        jFrame.add(jPasswordFieldPassword);
        jFrame.add(jLabelNumber);
        jFrame.add(jTextFieldNumber);
        jFrame.add(jLabelIdGroup);
        jFrame.add(jTextFielIdGroup);

        jButtonModifPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createModifPassword(jFrame, controllerStudent);
                jFrame.repaint();
            }
        });

        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void createModifPassword(JFrame jFrame, ControllerStudent controllerStudent){
        JLabel jLabelModifPassword = new JLabel("Entrer le nouveau mot de passe :");
        jLabelModifPassword.setBounds(560, 290, 300, 28);
        JTextField jTextFieldNewPassword = new JTextField(controllerStudent.getStudent().getPassword());
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
                try {
                    controllerStudent.getStudent().updatePassword(jTextFieldNewPassword.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        jFrame.setVisible(true);

    }
}
