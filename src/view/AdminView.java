package view;

import controller.ControllerAdmin;
import controller.TestConnection;
import model.*;
import view.ressource.AdminHomePage;
import view.ressource.AlertePopUp;
import view.ressource.Planning;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends JFrame{

    public AdminView(TestConnection testConnection, boolean isAdmin) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame();

        interfaceAdmin(frame, testConnection, isAdmin);
        frame.setTitle(testConnection.getUser().getFirstName() + " " + testConnection.getUser().getLastName());
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setLocation(50, 0);
        frame.setOpacity(1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void interfaceAdmin(JFrame jFrame, TestConnection testConnection, boolean isAdmin) throws SQLException, ClassNotFoundException {
        ControllerAdmin controllerAdmin = new ControllerAdmin();
        ControllerAdmin controllerAdminPersonalInfos = new ControllerAdmin(testConnection.getUser().getId());

        // Création de la barre menu
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        // Création des menus
        JMenu menuHome = new JMenu("Accueil");
        JMenu menuStudent = new JMenu("Etudiant");
        JMenu menuTeacher = new JMenu("Professeur");
        JMenu menuRoom = new JMenu("Salle");
        JMenu menuPersonalInfo = new JMenu("Informations personnelles");
        JMenu menuUpdate = new JMenu("Mise a jour des donnees");

        // Ajout des menus dans la barre de menu
        menuBar.add(menuHome);
        menuBar.add(menuStudent);
        menuBar.add(menuTeacher);
        menuBar.add(menuRoom);
        menuBar.add(menuPersonalInfo);
        if(isAdmin){
            menuBar.add(menuUpdate);
        }

        // Création des items student
        JMenuItem miHome = new JMenuItem("Accueil");

        // Création des items student
        JMenuItem miStudentList = new JMenuItem("Liste des etudiants");
        JMenuItem miStudentPlanning = new JMenuItem("Recapitulatif des cours");

        // Création des items teachers
        JMenuItem miTeacherList = new JMenuItem("Liste des enseignants");
        JMenuItem miTeacherPlanning = new JMenuItem("Recapitulatif des cours");

        // Création des items teachers
        JMenuItem miRoom = new JMenuItem("Liste des Salles");

        // Creation des sous menus et items "mise à jour données"
        JMenu mAdd = new JMenu("Ajouter...");
        JMenu mSupp = new JMenu("Supprimer...");

        JMenuItem miSessionAdd  = new JMenuItem("Session");
        JMenuItem miSessionSupp = new JMenuItem("Session");
        JMenuItem miTeacherAdd = new JMenuItem("Professeurs");
        JMenuItem miTeacherSupp = new JMenuItem("Professeurs");
        JMenuItem miStudentAdd = new JMenuItem("Etudiants");
        JMenuItem miStudentSupp = new JMenuItem("Etudiants");
        JMenuItem miRoomAdd = new JMenuItem("Salles");
        JMenuItem miRoomSupp = new JMenuItem("Salles");

        // Création de l'item Info personnelles
        JMenuItem miAccount = new JMenuItem("Compte");

        // Item du menu actif
        miHome.setEnabled(true);
        miStudentList.setEnabled(true);
        miStudentPlanning.setEnabled(true);
        miTeacherList.setEnabled(true);
        miTeacherPlanning.setEnabled(true);
        miRoom.setEnabled(true);
        mAdd.setEnabled(true);
        mSupp.setEnabled(true);
        miAccount.setEnabled(true);

        // Ajout des items au menu
        menuHome.add(miHome);
        menuStudent.add(miStudentList);
        menuStudent.add(miStudentPlanning);
        menuTeacher.add(miTeacherList);
        menuTeacher.add(miTeacherPlanning);
        menuRoom.add(miRoom);
        menuUpdate.add(mAdd);
        menuUpdate.add(mSupp);
        mAdd.add(miSessionAdd);
        mAdd.add(miTeacherAdd);
        mAdd.add(miStudentAdd);
        mSupp.add(miSessionSupp);
        mSupp.add(miTeacherSupp);
        mSupp.add(miStudentSupp);
        mAdd.add(miRoomAdd);
        mSupp.add(miRoomSupp);
        menuPersonalInfo.add(miAccount);
        AdminHomePage adminHomePage = new AdminHomePage(testConnection);
        jFrame.setContentPane(adminHomePage.panel1);

        // Action sélection item
        miHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    interfaceAdmin(jFrame,testConnection,isAdmin);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        miStudentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createStudentList(jFrame, controllerAdmin);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        miStudentPlanning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createStudentPlanning(jFrame, controllerAdmin);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        miTeacherList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createTeacherList(jFrame, controllerAdmin);
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
                try {
                    createTeacherPlanning(jFrame, controllerAdmin);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        miRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createRoomList(jFrame, controllerAdmin);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        if(isAdmin){
            miSessionAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    try {
                        addSessionWindow(controllerAdmin);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
            miStudentAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    try {
                        addStudentWindow(controllerAdmin);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
            miTeacherAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    try {
                        addTeacherWindow(controllerAdmin);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
            miRoomAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        addRoomWindow(controllerAdmin);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
            miSessionSupp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    suppSessionWindow();
                }
            });
            miTeacherSupp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    suppTeacherWindow();
                }
            });
            miStudentSupp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.getContentPane().removeAll();
                    suppStudentWindow();
                }
            });
            miRoomSupp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    suppRoomWindow();
                }
            });
        }

        miAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createPersonalInfos(jFrame, controllerAdminPersonalInfos);
            }
        });

        jFrame.setVisible(true);
    }

    // Affichage des infos étudiants et professeurs
    public void createStudentList(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        createPromotionChoice(jFrame, controllerAdmin, "StudentList");
    }
    public void createStudentPlanning(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        createPromotionChoice(jFrame, controllerAdmin, "StudentPlanning");
    }
    public void createTeacherList(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        createCourseChoice(jFrame, controllerAdmin, "TeacherList");
    }
    public void createTeacherPlanning(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        createCourseChoice(jFrame, controllerAdmin, "TeacherPlanning");
    }
    public void createRoomList(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        createSiteChoice(jFrame, controllerAdmin);
    }

    // Affichage combobox choix Student
    public void createPromotionChoice(JFrame jFrame, ControllerAdmin controllerAdmin, String choiceView) throws SQLException, ClassNotFoundException {
        jFrame.setLayout(null);
        JLabel jLabelSelectPromo = new JLabel("Selectionner une promotion et un groupe :");
        jLabelSelectPromo.setBounds(40, 10, 300, 28);
        jFrame.add(jLabelSelectPromo);
        ArrayList<String> promotions = controllerAdmin.getAllIdPromotion();
        String[] strPromo = new String[promotions.size()];
        for (int j = 0; j < promotions.size(); j++) {
            strPromo[j] = promotions.get(j);
        }
        JComboBox jComboBoxSelectPromotion = new JComboBox(strPromo);
        jComboBoxSelectPromotion.setBounds(40, 40, 100, 28);

        jComboBoxSelectPromotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < strPromo.length; i++) {
                    if(strPromo[i].equals(jComboBoxSelectPromotion.getSelectedItem())){
                        jFrame.getContentPane().removeAll();
                        jFrame.add(jComboBoxSelectPromotion);
                        jFrame.add(jLabelSelectPromo);
                        try {
                            createGroupChoice(jFrame, jComboBoxSelectPromotion, controllerAdmin, Objects.requireNonNull(jComboBoxSelectPromotion.getSelectedItem()).toString(), choiceView);
                        } catch (SQLException | ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        jFrame.add(jComboBoxSelectPromotion);
        jFrame.setVisible(true);
    }
    public void createGroupChoice(JFrame jFrame, JComboBox jComboBox, ControllerAdmin controllerAdmin, String idPromotion, final String choiceView) throws SQLException, ClassNotFoundException {
        ArrayList<String> groups = controllerAdmin.getAllIdGroupByIdPromo(idPromotion);
        String[] strGroup = new String[groups.size()];
        for (int j = 0; j < groups.size(); j++) {
            strGroup[j] = groups.get(j);
        }
        JComboBox jComboBoxSelectGroup = new JComboBox(strGroup);
        jComboBoxSelectGroup.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choiceView.equals("StudentList")){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBox);
                    jFrame.add(jComboBoxSelectGroup);
                    try {
                        createStudentListViewByGroup(jFrame, controllerAdmin, Objects.requireNonNull(jComboBoxSelectGroup.getSelectedItem()).toString());
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else if(choiceView.equals("StudentPlanning")){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBox);
                    jFrame.add(jComboBoxSelectGroup);
                    try {
                        createStudentPlanningView(jFrame, Objects.requireNonNull(jComboBoxSelectGroup.getSelectedItem()).toString(),jComboBox,jComboBoxSelectGroup);
                        jFrame.repaint();
                    } catch (SQLException | ClassNotFoundException | ParseException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectGroup);
        jFrame.setVisible(true);
    }
    // Affichage combobox choix Teacher
    public void createCourseChoice(JFrame jFrame, ControllerAdmin controllerAdmin, String choiceView) throws SQLException, ClassNotFoundException {
        JLabel jLabelSelectCourse = new JLabel("Selectionner une matière :");
        jLabelSelectCourse.setBounds(40, 10, 300, 28);
        jFrame.add(jLabelSelectCourse);

        ArrayList<String> promotions = controllerAdmin.getAllNameCourse();
        String[] strCourse = new String[promotions.size()];
        for (int j = 0; j < promotions.size(); j++) {
            strCourse[j] = promotions.get(j);
        }
        JComboBox jComboBoxSelectCourse = new JComboBox(strCourse);
        jComboBoxSelectCourse.setBounds(40, 40, 200, 28);

        jComboBoxSelectCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choiceView.equals("TeacherList")){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectCourse);
                    jFrame.add(jLabelSelectCourse);
                    try {
                        createTeacherListViewByCourse(jFrame, controllerAdmin, Objects.requireNonNull(jComboBoxSelectCourse.getSelectedItem()).toString());
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else if(choiceView.equals("TeacherPlanning")){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectCourse);
                    jFrame.add(jLabelSelectCourse);
                    try {
                        createTeacherChoice(jFrame, jComboBoxSelectCourse, controllerAdmin, Objects.requireNonNull(jComboBoxSelectCourse.getSelectedItem()).toString());
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectCourse);
        jFrame.setVisible(true);
    }
    public void createTeacherChoice(JFrame jFrame, JComboBox jComboBoxCourse, ControllerAdmin controllerAdmin, String courseChoiced) throws SQLException, ClassNotFoundException {
        ArrayList<ArrayList<String>> teachers = controllerAdmin.getAllTeachers(courseChoiced);
        String[] strTeacherId = new String[teachers.size()];
        for (int i = 0; i < teachers.size(); i++) {
            strTeacherId[i] = teachers.get(i).get(0);
        }
        String[] strTeacherName = new String[teachers.size()];
        for (int i = 0; i < teachers.size(); i++) {
            strTeacherName[i] = "M." + teachers.get(i).get(1);
        }
        JComboBox jComboBoxSelectteacher = new JComboBox(strTeacherName);
        jComboBoxSelectteacher.setBounds(250, 40, 200, 28);

        jComboBoxSelectteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < strTeacherName.length; i++) {
                    if (strTeacherName[i].equals(jComboBoxSelectteacher.getSelectedItem())) {
                        jFrame.getContentPane().removeAll();
                        jFrame.add(jComboBoxCourse);
                        jFrame.add(jComboBoxSelectteacher);
                        try {
                            createTeacherPlanningView(jFrame, strTeacherId[i], jComboBoxCourse, jComboBoxSelectteacher);
                        } catch (SQLException | ClassNotFoundException | ParseException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectteacher);
        jFrame.setVisible(true);
    }
    // Affichage combobox choix Site
    public void createSiteChoice(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        JLabel jLabelSelectCourse = new JLabel("Selectionner un site :");
        jLabelSelectCourse.setBounds(40, 10, 300, 28);

        ArrayList<String> site = controllerAdmin.getAllNameSite();
        String[] strSite = new String[site.size()];
        for (int j = 0; j < site.size(); j++) {
            strSite[j] = site.get(j);
        }
        JComboBox jComboBoxSelectSite = new JComboBox(strSite);
        jComboBoxSelectSite.setBounds(40, 40, 200, 28);

        jComboBoxSelectSite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createRoomListViewBySite(jFrame, controllerAdmin, Objects.requireNonNull(jComboBoxSelectSite.getSelectedItem()).toString());
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        jFrame.add(jLabelSelectCourse);
        jFrame.add(jComboBoxSelectSite);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    // Affichage tableaux des élèves par groupe
    public void createStudentListViewByGroup(JFrame jFrame, ControllerAdmin controllerAdmin, String groupChoiced) throws SQLException, ClassNotFoundException {
        ArrayList<ArrayList<String>> students = controllerAdmin.getAllStudents(groupChoiced);
        System.out.println(students);
        String[] tableTitle = {"ID", "Nom", "Prenom", "Email", "Permission", "Numero d'etudiant"};
        String[][] mt = new String[students.size()][tableTitle.length];
        for(int i = 0 ; i < students.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = students.get(i).get(j);
            }
        }
        jFrame.setLayout(null);
        JTable jTableStudentList = new JTable(mt, tableTitle);
        JScrollPane jScrollPane = new JScrollPane();
        JPanel jPanelStudentList = new JPanel();
        jScrollPane.getViewport().add(jTableStudentList);
        jPanelStudentList.setBounds(0, 80, 500, 200);
        jPanelStudentList.add(jScrollPane);
        jFrame.add(jPanelStudentList);
        jFrame.setVisible(true);
    }
    public void createStudentPlanningView(JFrame jFrame, String GroupChoiced, JComboBox jComboBoxPromo, JComboBox jComboBoxGroupe) throws SQLException, ClassNotFoundException, ParseException {
        String[] week = new String[53];
        for (int i = 0; i < 52; i++) {
            week[i] = String.valueOf(i+1);
        }
        JComboBox jComboBoxSelectWeek = new JComboBox(week);
        jComboBoxSelectWeek.setBounds(380, 40, 80, 28);
        Planning planning = new Planning();
        planning.setSettings(jFrame);
        jComboBoxSelectWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.add(jComboBoxPromo);
                jFrame.add(jComboBoxGroupe);
                jFrame.add(jComboBoxSelectWeek);
                for(int i = 0; i < week.length; i++) {
                    if(jComboBoxSelectWeek.getSelectedIndex() == i){
                        try {
                            planning.DrawStudentPlanningForAdmin(jFrame, GroupChoiced, i+1);
                        } catch (SQLException | ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                planning.repaint();
                planning.setSettings(jFrame);
                jFrame.add(planning);
            }
        });
        jFrame.add(planning);
        jFrame.add(jComboBoxSelectWeek);
        jFrame.setOpacity(1);
        jFrame.setVisible(true);
    }

    // Affichage tableaux professeurs par matière
    public void createTeacherListViewByCourse(JFrame jFrame, ControllerAdmin controllerAdmin, String courseChoice) throws SQLException, ClassNotFoundException {
        ArrayList<ArrayList<String>> teachers = controllerAdmin.getAllTeachers(courseChoice);
        String[] tableTitle = {"ID", "Nom", "Prenom", "Email", "Permission"};
        String[][] mt = new String[teachers.size()][tableTitle.length];
        for(int i = 0 ; i < teachers.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = teachers.get(i).get(j);
            }
        }
        jFrame.setLayout(null);
        JTable jTableTeacherList = new JTable(mt, tableTitle);
        JScrollPane jScrollPane = new JScrollPane();
        JPanel jPanelTeacherList = new JPanel();
        jScrollPane.getViewport().add(jTableTeacherList);
        jPanelTeacherList.setBounds(0, 80, 500, 200);
        jPanelTeacherList.add(jScrollPane);
        jFrame.add(jPanelTeacherList);
        jFrame.setVisible(true);
    }
    public void createTeacherPlanningView(JFrame jFrame, String idUser, JComboBox jComboBoxCourse, JComboBox jComboBoxTeacherChoice) throws SQLException, ClassNotFoundException, ParseException {
        String[] week = new String[53];
        for (int i = 0; i < 52; i++) {
            week[i] = String.valueOf(i+1);
        }
        JComboBox jComboBoxSelectWeek = new JComboBox(week);
        jComboBoxSelectWeek.setBounds(460, 40, 80, 28);
        Planning planning = new Planning();
        planning.setSettings(jFrame);
        jComboBoxSelectWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.add(jComboBoxCourse);
                jFrame.add(jComboBoxTeacherChoice);
                jFrame.add(jComboBoxSelectWeek);
                for(int i = 0; i < week.length; i++) {
                    if(jComboBoxSelectWeek.getSelectedIndex() == i){
                        try {
                            planning.DrawTeacherPlanningForTeacher(jFrame, idUser, i+1);
                        } catch (SQLException | ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                planning.repaint();
                planning.setSettings(jFrame);
                jFrame.add(planning);
            }
        });
        jFrame.add(planning);
        jFrame.add(jComboBoxSelectWeek);
        jFrame.setOpacity(1);
        jFrame.setVisible(true);
    }

    // Affichage tableaux des salles par site
    public void createRoomListViewBySite(JFrame jFrame, ControllerAdmin controllerAdmin, String siteChoice) throws SQLException, ClassNotFoundException {
        ArrayList<ArrayList<String>> rooms = controllerAdmin.getAllRoom(siteChoice);
        String[] tableTitle = {"ID", "Nom", "Capacite"};
        String[][] mt = new String[rooms.size()][tableTitle.length];
        for(int i = 0 ; i < rooms.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = rooms.get(i).get(j);
            }
        }
        jFrame.setLayout(null);
        JTable jTableRoomList = new JTable(mt, tableTitle);
        JScrollPane jScrollPane = new JScrollPane();
        JPanel jPanelRoomList = new JPanel();
        jScrollPane.getViewport().add(jTableRoomList);
        jPanelRoomList.setBounds(0, 80, 500, 200);
        jPanelRoomList.add(jScrollPane);
        jFrame.add(jPanelRoomList);
        jFrame.setVisible(true);
    }

    // Affichage mini fenêtres mise à jours
    public void addSessionWindow(ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 290, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 290, 100, 28);

        JLabel jLabelIdSession = new JLabel("Saissisez l'ID de la session à créer : ");
        jLabelIdSession.setBounds(20, 20, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelWeek = new JLabel("Saissisez la semaine de la session : ");
        jLabelWeek.setBounds(20, 48, 250, 28);

        JTextField jTextFieldWeek = new JTextField();
        jTextFieldWeek.setBounds(280, 48, 200, 28);

        JLabel jLabelSelectDate = new JLabel("Selectionner une date :");
        jLabelSelectDate.setBounds(20, 80, 250, 28);

        String[] day = new String[31];
        for (int i = 0; i < 31; i++) {
            day[i] = String.valueOf(i+1);
        }
        JComboBox jComboBoxSelectDay = new JComboBox(day);
        jComboBoxSelectDay.setBounds(280, 80, 70, 28);

        jComboBoxSelectDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < day.length; i++) {
                    if(jComboBoxSelectDay.getSelectedIndex() == i){
                        System.out.println(i+1);
                    }
                }
            }
        });

        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox jComboBoxSelectMonth = new JComboBox(month);
        jComboBoxSelectMonth.setBounds(350, 80, 70, 28);

        jComboBoxSelectMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < month.length; i++) {
                    if(jComboBoxSelectMonth.getSelectedIndex() == i){
                        System.out.println(i+1);
                    }
                }
            }
        });

        String[] years = {"2019", "2020", "2021"};
        JComboBox jComboBoxSelectYear = new JComboBox(years);
        jComboBoxSelectYear.setBounds(420, 80, 130, 28);

        JLabel jLabelStartHour = new JLabel("Selectionner une heure de début :");
        jLabelStartHour.setBounds(20, 108, 250, 28);

        String[] StartHours = {"08:00:00", "09:30:00", "11:15:00", "12:45:00", "14:30:00", "16:00:00", "17:45:00"};
        JComboBox jComboBoxSelectStartHour = new JComboBox(StartHours);
        jComboBoxSelectStartHour.setBounds(280, 108, 100, 28);

        final Time[] endTime = {null};
        jComboBoxSelectStartHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = Objects.requireNonNull(jComboBoxSelectStartHour.getSelectedItem());
                if ("08:00:00".equals(o)) {
                    endTime[0] = Time.valueOf("09:30:00");
                } else if ("09:30:00".equals(o)) {
                    endTime[0] = Time.valueOf("11:00:00");
                } else if ("11:15:00".equals(o)) {
                    endTime[0] = Time.valueOf("12:45:00");
                } else if ("12:45:00".equals(o)) {
                    endTime[0] = Time.valueOf("14:15:00");
                } else if ("14:30:00".equals(o)) {
                    endTime[0] = Time.valueOf("16:00:00");
                } else if ("16:00:00".equals(o)) {
                    endTime[0] = Time.valueOf("17:30:00");
                } else if ("17:45:00".equals(o)) {
                    endTime[0] = Time.valueOf("19:15:00");
                } else if ("19:15:00".equals(o)) {
                    endTime[0] = Time.valueOf("20:45:00");
                }
            }
        });

        JLabel jLabelTeacher = new JLabel("Selectionner un Enseignant :");
        jLabelTeacher.setBounds(20, 140, 250, 28);

        ArrayList<String> promotions = controllerAdmin.getAllIdCourse();
        String[] strCourse = new String[promotions.size()];
        for (int j = 0; j < promotions.size(); j++) {
            strCourse[j] = promotions.get(j);
        }
        JComboBox jComboBoxSelectCourse = new JComboBox(strCourse);
        jComboBoxSelectCourse.setBounds(280, 140, 100, 28);

        JTextField jTextFieldTeacher = new JTextField();
        jTextFieldTeacher.setBounds(390, 140, 100, 28);

        JLabel jLabelRoom = new JLabel("Selectionner une salle :");
        jLabelRoom.setBounds(20, 170, 250, 28);

        JTextField jTextFieldRoom = new JTextField();
        jTextFieldRoom.setBounds(280, 170, 100, 28);

        JLabel jLabelCourseType = new JLabel("Selectionner le type du cours :");
        jLabelCourseType.setBounds(20, 200, 250, 28);

        String[] courseType = {"DW", "LE", "OC", "PA", "PW", "SD"};
        JComboBox jComboBoxSelectCourseType = new JComboBox(courseType);
        jComboBoxSelectCourseType.setBounds(280, 200, 100, 28);

        JLabel jLabelIdGroup = new JLabel("Selectionner l'ID du groupe :");
        jLabelIdGroup.setBounds(20, 230, 250, 28);

        ArrayList<String> groups = controllerAdmin.getAllIdGroup();

        String[] strGroup = new String[groups.size()];
        for (int j = 0; j < groups.size(); j++) {
            strGroup[j] = groups.get(j);
        }
        JComboBox jComboBoxSelectGroup = new JComboBox(strGroup);
        jComboBoxSelectGroup.setBounds(280, 230, 150, 28);


        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);
        addFrame.add(jLabelIdSession);
        addFrame.add(jTextFieldId);
        addFrame.add(jLabelWeek);
        addFrame.add(jTextFieldWeek);
        addFrame.add(jLabelSelectDate);
        addFrame.add(jComboBoxSelectDay);
        addFrame.add(jComboBoxSelectMonth);
        addFrame.add(jComboBoxSelectYear);
        addFrame.add(jLabelStartHour);
        addFrame.add(jComboBoxSelectStartHour);
        addFrame.add(jLabelTeacher);
        addFrame.add(jComboBoxSelectCourse);
        addFrame.add(jTextFieldTeacher);
        addFrame.add(jLabelRoom);
        addFrame.add(jTextFieldRoom);
        addFrame.add(jLabelCourseType);
        addFrame.add(jComboBoxSelectCourseType);
        addFrame.add(jLabelIdGroup);
        addFrame.add(jComboBoxSelectGroup);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room room = new Room();
                    String strDtae = Objects.requireNonNull(jComboBoxSelectYear.getSelectedItem()).toString() + "-" + Objects.requireNonNull(jComboBoxSelectMonth.getSelectedItem()).toString() + "-" + Objects.requireNonNull(jComboBoxSelectDay.getSelectedItem()).toString();
                    Date date = Date.valueOf(strDtae);
                    Session session1 = new Session();
                    Teacher teacher = new Teacher();
                    teacher = teacher.findByName(jTextFieldTeacher.getText());

                    if (!jTextFieldId.getText().equals("") && !jTextFieldWeek.getText().equals("") && jTextFieldTeacher.getText() != "" && jTextFieldRoom.getText() != "") {
                        if (!session1.alreadyExist(jTextFieldId.getText()) && teacher.alreadyExist(jTextFieldTeacher.getText())
                                && !teacher.alreadyTeach(Integer.parseInt(jTextFieldWeek.getText()), date, Time.valueOf(Objects.requireNonNull(jComboBoxSelectStartHour.getSelectedItem()).toString()), endTime[0], teacher.getId())
                                && room.alreadyExist(jTextFieldRoom.getText()) ) {
                            Session session = new Session(jTextFieldId.getText(),
                                    Integer.parseInt(jTextFieldWeek.getText()),
                                    date,
                                    Time.valueOf(Objects.requireNonNull(jComboBoxSelectStartHour.getSelectedItem()).toString()),
                                    endTime[0],
                                    Objects.requireNonNull(jComboBoxSelectCourseType.getSelectedItem()).toString(),
                                    Objects.requireNonNull(jComboBoxSelectCourse.getSelectedItem()).toString(),
                                    room.findByName(jTextFieldRoom.getText()),
                                    jTextFieldTeacher.getText(),
                                    Objects.requireNonNull(jComboBoxSelectGroup.getSelectedItem()).toString());
                            session.createSession(teacher);
                        }
                    }
                    else {
                        System.out.println("Erreur dans la saisie des informations Id déja utiliser/Professeur inexistant/professeur occupé/Salle inexistant");
                        addSessionWindow(controllerAdmin);
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.AddFailId.setVisible(true);
                    }
                } catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Ajout d'un cours");
        addFrame.setSize(600,350);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void addTeacherWindow(ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 240, 100, 28);

        JLabel jLabelIdStudent = new JLabel("Saissisez l'ID du professeur à créer : ");
        jLabelIdStudent.setBounds(20, 20, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelEmail = new JLabel("Saissisez l'Email du professeur : ");
        jLabelEmail.setBounds(20, 48, 250, 28);

        JTextField jTextFielEmailPart1 = new JTextField();
        jTextFielEmailPart1.setBounds(280, 48, 100, 28);
        JTextField jTextFielEmailPart2 = new JTextField("@ece.fr");
        jTextFielEmailPart2.setBounds(380, 48, 100, 28);

        JLabel jLabelPassword = new JLabel("Saissisez le mot de passe du professeur : ");
        jLabelPassword.setBounds(20, 80, 280, 28);

        JTextField jTextFieldPassword = new JTextField();
        jTextFieldPassword.setBounds(280, 80, 200, 28);

        JLabel jLabelLastName = new JLabel("Saissisez le nom du professeur : ");
        jLabelLastName.setBounds(20, 108, 250, 28);

        JTextField jTextFieldLastName = new JTextField();
        jTextFieldLastName.setBounds(280, 108, 200, 28);

        JLabel jLabelFirstName = new JLabel("Saissisez le prénom du professeur : ");
        jLabelFirstName.setBounds(20, 140, 250, 28);

        JTextField jTextFieldFirstName = new JTextField();
        jTextFieldFirstName.setBounds(280, 140, 200, 28);

        JLabel jLabelSelectPromo = new JLabel("Selectionner une matière :");
        jLabelSelectPromo.setBounds(20, 170, 250, 28);

        ArrayList<String> promotions = controllerAdmin.getAllIdCourse();
        String[] strCourse = new String[promotions.size()];
        for (int j = 0; j < promotions.size(); j++) {
            strCourse[j] = promotions.get(j);
        }
        JComboBox jComboBoxSelectCourse = new JComboBox(strCourse);
        jComboBoxSelectCourse.setBounds(280, 170, 100, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);
        addFrame.add(jLabelIdStudent);
        addFrame.add(jTextFieldId);
        addFrame.add(jLabelEmail);
        addFrame.add(jTextFielEmailPart1);
        addFrame.add(jTextFielEmailPart2);
        addFrame.add(jLabelPassword);
        addFrame.add(jTextFieldPassword);
        addFrame.add(jLabelLastName);
        addFrame.add(jTextFieldLastName);
        addFrame.add(jLabelFirstName);
        addFrame.add(jTextFieldFirstName);
        addFrame.add(jLabelSelectPromo);
        addFrame.add(jComboBoxSelectCourse);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User();
                    if (!jTextFieldId.getText().equals("") && !jTextFielEmailPart1.getText().equals("") && !jTextFieldFirstName.getText().equals("") && !jTextFieldLastName.getText().equals("")){
                    if(!user.alreadyExist(jTextFieldId.getText())){
                        Teacher teacher = new Teacher(jTextFieldId.getText(), jTextFielEmailPart1.getText() + jTextFielEmailPart2.getText(), jTextFieldPassword.getText(), jTextFieldLastName.getText(), jTextFieldFirstName.getText(), "TEACHER", Objects.requireNonNull(jComboBoxSelectCourse.getSelectedItem()).toString());
                        teacher.createTeacher();
                    }}
                    else {
                        addTeacherWindow(controllerAdmin);
                        System.out.println("Erreur Id deja utilise");
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.AddFailId.setVisible(true);

                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Ajout d'un professeur");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void addStudentWindow(ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 240, 100, 28);

        JLabel jLabelIdStudent = new JLabel("Saissisez l'ID de l'étudiant à créer : ");
        jLabelIdStudent.setBounds(20, 20, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelEmail = new JLabel("Saissisez l'Email de l'étudiant : ");
        jLabelEmail.setBounds(20, 48, 250, 28);

        JTextField jTextFielEmailPart1 = new JTextField();
        jTextFielEmailPart1.setBounds(280, 48, 100, 28);
        JTextField jTextFielEmailPart2 = new JTextField("@ece.fr");
        jTextFielEmailPart2.setBounds(380, 48, 100, 28);

        JLabel jLabelPassword = new JLabel("Saissisez le mot de passe de l'étudiant : ");
        jLabelPassword.setBounds(20, 80, 280, 28);

        JTextField jTextFieldPassword = new JTextField();
        jTextFieldPassword.setBounds(280, 80, 200, 28);

        JLabel jLabelLastName = new JLabel("Saissisez le nom de l'étudiant : ");
        jLabelLastName.setBounds(20, 108, 250, 28);

        JTextField jTextFieldLastName = new JTextField();
        jTextFieldLastName.setBounds(280, 108, 200, 28);

        JLabel jLabelFirstName = new JLabel("Saissisez le prénom de l'étudiant : ");
        jLabelFirstName.setBounds(20, 140, 250, 28);

        JTextField jTextFieldFirstName = new JTextField();
        jTextFieldFirstName.setBounds(280, 140, 200, 28);

        JLabel jLabelNumber = new JLabel("Saissisez le numéro de l'étudiant : ");
        jLabelNumber.setBounds(20, 170, 250, 28);

        JTextField jTextFieldNumber = new JTextField();
        jTextFieldNumber.setBounds(280, 170, 200, 28);

        JLabel jLabelSelectPromo = new JLabel("Selectionner une promotion et un groupe :");
        jLabelSelectPromo.setBounds(20, 200, 300, 28);

        ArrayList<String> groups = controllerAdmin.getAllIdGroup();

        String[] strGroup = new String[groups.size()];
        for (int j = 0; j < groups.size(); j++) {
            strGroup[j] = groups.get(j);
        }
        JComboBox jComboBoxSelectGroup = new JComboBox(strGroup);
        jComboBoxSelectGroup.setBounds(300, 200, 150, 28);

        jTextFielEmailPart2.setEditable(false);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);
        addFrame.add(jLabelIdStudent);
        addFrame.add(jTextFieldId);
        addFrame.add(jLabelEmail);
        addFrame.add(jTextFielEmailPart1);
        addFrame.add(jTextFielEmailPart2);
        addFrame.add(jLabelPassword);
        addFrame.add(jTextFieldPassword);
        addFrame.add(jLabelLastName);
        addFrame.add(jTextFieldLastName);
        addFrame.add(jLabelFirstName);
        addFrame.add(jTextFieldFirstName);
        addFrame.add(jLabelNumber);
        addFrame.add(jTextFieldNumber);
        addFrame.add(jLabelSelectPromo);
        addFrame.add(jComboBoxSelectGroup);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Student std = new Student();
                    if (!jTextFieldId.getText().equals("") && !jTextFielEmailPart1.getText().equals("") && !jTextFieldFirstName.getText().equals("") && !jTextFieldLastName.getText().equals("") && !jTextFieldNumber.getText().equals("")){
                        if(!std.alreadyExist(jTextFieldId.getText())){
                        Student student = new Student(jTextFieldId.getText(), jTextFielEmailPart1.getText() + jTextFielEmailPart2.getText(), jTextFieldPassword.getText(), jTextFieldLastName.getText(), jTextFieldFirstName.getText(), "STUDENT", jTextFieldNumber.getText(), Objects.requireNonNull(jComboBoxSelectGroup.getSelectedItem()).toString());
                        student.createStudent();
                    }}
                    else {
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.AddFailId.setVisible(true);
                        System.out.println("Erreur Id deja utilise");
                        addStudentWindow(controllerAdmin);
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Ajout d'un étudiant");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void addRoomWindow(ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 140, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 140, 100, 28);

        JLabel jLabelIdSite = new JLabel("Selectionner le site où ajouter la salle à créer : ");
        jLabelIdSite.setBounds(20, 20, 250, 28);

        ArrayList<String> site = controllerAdmin.getAllNameSite();
        String[] strSite = new String[site.size()];
        for (int j = 0; j < site.size(); j++) {
            strSite[j] = site.get(j);
        }
        JComboBox jComboBoxSelectSite = new JComboBox(strSite);
        jComboBoxSelectSite.setBounds(280, 20, 200, 28);

        JLabel jLabelIdRoom = new JLabel("Saissisez l'ID de la salle : ");
        jLabelIdRoom.setBounds(20, 48, 250, 28);

        JTextField jTextFiedlIdRoom = new JTextField();
        jTextFiedlIdRoom.setBounds(280, 48, 200, 28);

        JLabel jLabelName = new JLabel("Saissisez le nom de la salle : ");
        jLabelName.setBounds(20, 80, 280, 28);

        JTextField jTextFiedldName = new JTextField();
        jTextFiedldName.setBounds(280, 80, 200, 28);

        JLabel jLabelCapacity = new JLabel("Saissisez la capacite de la salle : ");
        jLabelCapacity.setBounds(20, 108, 250, 28);

        JTextField jTextFiedldCapacity = new JTextField();
        jTextFiedldCapacity.setBounds(280, 108, 200, 28);

        addFrame.add(jLabelIdSite);
        addFrame.add(jComboBoxSelectSite);
        addFrame.add(jLabelIdRoom);
        addFrame.add(jTextFiedlIdRoom);
        addFrame.add(jLabelName);
        addFrame.add(jTextFiedldName);
        addFrame.add(jLabelCapacity);
        addFrame.add(jTextFiedldCapacity);
        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room rm = new Room();
                    Site site = new Site();
                    assert rm != null;
                    if(!jTextFiedldName.getText().equals("") && !jTextFiedldCapacity.getText().equals("")){
                    if(!rm.alreadyExist(jTextFiedlIdRoom.getText())){
                        Room room = new Room(jTextFiedlIdRoom.getText(), Integer.parseInt(jTextFiedldCapacity.getText()), jTextFiedldName.getText(), site.findByName(Objects.requireNonNull(jComboBoxSelectSite.getSelectedItem()).toString()).getIdSite());
                        room.createRoom();
                        addFrame.dispose();
                    }}
                    else {
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.AddFailId.setVisible(true);
                        System.out.println("Erreur de saisie des informations");
                        addRoomWindow(controllerAdmin);
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        addFrame.setTitle("Ajout d'une salle");
        addFrame.setSize(600,200);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void suppSessionWindow(){
        JFrame suppFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID du cours à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 50, 200, 28);

        suppFrame.add(jButtonCanceled);
        suppFrame.add(jButtonSupp);
        suppFrame.add(jLabelIdCourse);
        suppFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suppFrame.dispose();
            }
        });
        jButtonSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Session session = new Session();
                    if(session.alreadyExist(jTextFieldId.getText())){
                        session.deleteSession(jTextFieldId.getText());
                    }
                    else {
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.DeleteFail.setVisible(true);
                        System.out.println("Erreur l'Id saisie n'existe pas");}
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                suppFrame.dispose();
            }
        });

        suppFrame.setTitle("Suppression d'un cours");
        suppFrame.setSize(600,180);
        suppFrame.setLocation(200, 100);
        suppFrame.setLayout(null);
        suppFrame.setVisible(true);
    }
    public void suppTeacherWindow(){
        JFrame suppFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID du professeur à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 270, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(300, 50, 200, 28);

        suppFrame.add(jButtonCanceled);
        suppFrame.add(jButtonSupp);
        suppFrame.add(jLabelIdCourse);
        suppFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suppFrame.dispose();
            }
        });

        jButtonSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Teacher teacher = new Teacher();
                    if(teacher.alreadyExist(jTextFieldId.getText())){
                        teacher.deleteTeacher(jTextFieldId.getText());
                    }
                    else {
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.DeleteFail.setVisible(true);
                        System.out.println("Erreur l'Id saisie n'existe pas");}
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                suppFrame.dispose();
            }
        });

        suppFrame.setTitle("Suppression d'un professeur");
        suppFrame.setSize(600,180);
        suppFrame.setLocation(200, 100);
        suppFrame.setLayout(null);
        suppFrame.setVisible(true);
    }
    public void suppStudentWindow(){
        JFrame suppFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID de l'étudiant à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 280, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(310, 50, 200, 28);

        suppFrame.add(jButtonCanceled);
        suppFrame.add(jButtonSupp);
        suppFrame.add(jLabelIdCourse);
        suppFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suppFrame.dispose();
            }
        });
        jButtonSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Student student = new Student();
                    if(student.alreadyExist(jTextFieldId.getText())){
                        student.deleteStudent(jTextFieldId.getText());
                    }
                    else{
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.DeleteFail.setVisible(true);
                        System.out.println("Erreur l'Id saisie n'existe pas");}
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                suppFrame.dispose();
            }
        });

        suppFrame.setTitle("Suppression d'un étudiant");
        suppFrame.setSize(600,180);
        suppFrame.setLocation(200, 100);
        suppFrame.setLayout(null);
        suppFrame.setVisible(true);
    }
    public void suppRoomWindow(){
        JFrame suppFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdRoom = new JLabel("Saissisez le nom de la salle à supprimer : ");
        jLabelIdRoom.setBounds(20, 50, 260, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(290, 50, 200, 28);

        suppFrame.add(jButtonCanceled);
        suppFrame.add(jButtonSupp);
        suppFrame.add(jLabelIdRoom);
        suppFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suppFrame.dispose();
            }
        });
        jButtonSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room room = new Room();
                    if(room.alreadyExist(jTextFieldId.getText())){
                        room.deleteRoom(jTextFieldId.getText());
                    }
                    else {
                        AlertePopUp alertePopUp = new AlertePopUp();
                        alertePopUp.DeleteFail.setVisible(true);
                        System.out.println("Erreur l'Id saisie n'existe pas");}
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                suppFrame.dispose();
            }
        });

        suppFrame.setTitle("Suppression d'une salle");
        suppFrame.setSize(600,180);
        suppFrame.setLocation(200, 100);
        suppFrame.setLayout(null);
        suppFrame.setVisible(true);
    }

    // Affichage informations personnelles
    public void createPersonalInfos(JFrame jFrame, ControllerAdmin controllerAdminPersonalInfos){
        JLabel jLabelAcount = new JLabel("Compte");
        jLabelAcount.setBounds(20, 20, 100, 28);

        JLabel jLabelId = new JLabel("Identifiant :");
        jLabelId.setBounds(40, 50, 300, 28);
        JTextField jTextFieldId = new JTextField(controllerAdminPersonalInfos.getUser().getId());
        jTextFieldId.setBounds(40, 80, 300, 28);

        JLabel jLabelLastName = new JLabel("Nom :");
        jLabelLastName.setBounds(40, 110, 300, 28);
        JTextField jTextFieldLastName = new JTextField(controllerAdminPersonalInfos.getUser().getLastName());
        jTextFieldLastName.setBounds(40, 140, 300, 28);

        JLabel jLabelFirstName = new JLabel("Prenom :");
        jLabelFirstName.setBounds(40, 170, 300, 28);
        JTextField jTextFieldFirstName = new JTextField(controllerAdminPersonalInfos.getUser().getFirstName());
        jTextFieldFirstName.setBounds(40, 200, 300, 28);

        JLabel jLabelEmail = new JLabel("Email :");
        jLabelEmail.setBounds(40, 230, 300, 28);
        JTextField jTextFieldEmail = new JTextField(controllerAdminPersonalInfos.getUser().getEmail());
        jTextFieldEmail.setBounds(40, 260, 300, 28);

        JLabel jLabelPassword = new JLabel("Mot de passe :");
        jLabelPassword.setBounds(40, 290, 300, 28);
        JPasswordField jPasswordFieldPassword = new JPasswordField(controllerAdminPersonalInfos.getUser().getPassword());
        jPasswordFieldPassword.setBounds(40, 320, 300, 28);

        JButton jButtonModifPassword = new JButton("Modifier le mot de passe");
        jButtonModifPassword.setBounds(350, 320, 200, 28);

        //set editabilite
        jTextFieldId.setEditable(false);
        jTextFieldLastName.setEditable(false);
        jTextFieldFirstName.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jPasswordFieldPassword.setEditable(false);

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
        jFrame.add(jButtonModifPassword);
        jFrame.add(jPasswordFieldPassword);

        jButtonModifPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createModifPassword(jFrame, controllerAdminPersonalInfos);
                jFrame.repaint();
            }
        });

        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    public void createModifPassword(JFrame jFrame, ControllerAdmin controllerAdminPersonalInfos){
        JLabel jLabelModifPassword = new JLabel("Entrer le nouveau mot de passe :");
        jLabelModifPassword.setBounds(560, 290, 300, 28);
        JTextField jTextFieldNewPassword = new JTextField(controllerAdminPersonalInfos.getUser().getPassword());
        jTextFieldNewPassword.setBounds(560, 320, 200, 28);
        JButton jButtonCancel = new JButton("Annuler");
        jButtonCancel.setBounds(560, 350, 100, 28);
        JButton jButtonOk = new JButton("Valider");
        jButtonOk.setBounds(660, 350, 100, 28);

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
                    controllerAdminPersonalInfos.getUser().updatePassword(jTextFieldNewPassword.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        jFrame.setVisible(true);
    }
}
