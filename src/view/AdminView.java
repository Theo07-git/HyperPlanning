package view;

import controller.ControllerAdmin;
import controller.TestConnection;
import model.Student;
import model.Teacher;
import model.User;
import view.Ressource.Planning;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends JFrame{

    public AdminView(TestConnection testConnection) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame();

        interfaceAdmin(frame, testConnection);
        frame.setTitle(testConnection.getUser().getFirstName() + " " + testConnection.getUser().getLastName());
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setLocation(50, 0);
        frame.setOpacity(1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void interfaceAdmin(JFrame jFrame, TestConnection testConnection) throws SQLException, ClassNotFoundException {
        ControllerAdmin controllerAdmin = new ControllerAdmin();
        ControllerAdmin controllerAdminPersonalInfos = new ControllerAdmin(testConnection.getUser().getId());

        // Création de la barre menu
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        // Création des menus
        JMenu menuHome = new JMenu("Accueil");
        JMenu menuStudent = new JMenu("Etudiant");
        JMenu menuTeacher = new JMenu("Professeur");
        JMenu menuRoom = new JMenu("Salles");
        JMenu menuUpdate = new JMenu("Mise a jour des donnees");
        JMenu menuPersonalInfo = new JMenu("Informations personnelles");

        // Ajout des menus dans la barre de menu
        menuBar.add(menuHome);
        menuBar.add(menuStudent);
        menuBar.add(menuTeacher);
        menuBar.add(menuRoom);
        menuBar.add(menuUpdate);
        menuBar.add(menuPersonalInfo);

        // Création des items student
        JMenuItem miHome = new JMenuItem("Accueil");

        // Création des items student
        JMenuItem miStudentList = new JMenuItem("Liste des etudiants");
        JMenuItem miStudentPlanning = new JMenuItem("Recapitulatif des cours");

        // Création des items teachers
        JMenuItem miTeacherList = new JMenuItem("Liste des enseignants");
        JMenuItem miTeacherPlanning = new JMenuItem("Recapitulatif des cours");

        // Creation des sous menus et items "mise à jour données"
        JMenu mAdd = new JMenu("Ajouter...");
        JMenu mSupp = new JMenu("Supprimer...");
        JMenu mMod = new JMenu("Modifier...");

        JMenuItem miCourse1  = new JMenuItem("Cours");
        JMenuItem miCourse2 = new JMenuItem("Cours");
        JMenuItem miCourse3 = new JMenuItem("Cours");
        JMenuItem miTeacher1 = new JMenuItem("Professeurs");
        JMenuItem miTeacher2 = new JMenuItem("Professeurs");
        JMenuItem miTeacher3 = new JMenuItem("Professeurs");
        JMenuItem miStudent1 = new JMenuItem("Etudiants");
        JMenuItem miStudent2 = new JMenuItem("Etudiants");
        JMenuItem miStudent3 = new JMenuItem("Etudiants");

        // Création de l'item Info personnelles
        JMenuItem miAccount = new JMenuItem("Compte");

        // Item du menu actif
        miHome.setEnabled(true);
        miStudentList.setEnabled(true);
        miStudentPlanning.setEnabled(true);
        miTeacherList.setEnabled(true);
        miTeacherPlanning.setEnabled(true);
        mAdd.setEnabled(true);
        mSupp.setEnabled(true);
        mMod.setEnabled(true);
        miAccount.setEnabled(true);

        // Ajout des items au menu
        menuHome.add(miHome);
        menuStudent.add(miStudentList);
        menuStudent.add(miStudentPlanning);
        menuTeacher.add(miTeacherList);
        menuTeacher.add(miTeacherPlanning);
        menuUpdate.add(mAdd);
        menuUpdate.add(mSupp);
        menuUpdate.add(mMod);
        mAdd.add(miCourse1);
        mAdd.add(miTeacher1);
        mAdd.add(miStudent1);
        mSupp.add(miCourse2);
        mSupp.add(miTeacher2);
        mSupp.add(miStudent2);
        mMod.add(miCourse3);
        mMod.add(miTeacher3);
        mMod.add(miStudent3);
        menuPersonalInfo.add(miAccount);

        // Action sélection item
        miHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        miCourse1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                addCourseWindow();
            }
        });
        miStudent1.addActionListener(new ActionListener() {
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
        miTeacher1.addActionListener(new ActionListener() {
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
        miCourse2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppCourseWindow();
            }
        });
        miTeacher2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppTeacherWindow();
            }
        });
        miStudent2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppStudentWindow();
            }
        });
        miCourse3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modCourseWindow();
            }
        });
        miTeacher3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modTeacherWindow();
            }
        });
        miStudent3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modStudentWindow();
            }
        });
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
        Integer[] week = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
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
        Integer[] week = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
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

    // Affichage mini fenêtres mise à jours
    public void addCourseWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 240, 100, 28);

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

        Integer[] day = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
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

        String[] years = {"2019-2020", "2020-2021", "2021-2022"};
        JComboBox jComboBoxSelectYear = new JComboBox(years);
        jComboBoxSelectYear.setBounds(420, 80, 130, 28);

        JLabel jLabelStartHour = new JLabel("Selectionner une heure de début :");
        jLabelStartHour.setBounds(20, 108, 250, 28);

        String[] StartHours = {"08h00", "09h30", "11h15", "12h45", "14h30", "16H00", "17h45"};
        JComboBox jComboBoxSelectStartHour = new JComboBox(StartHours);
        jComboBoxSelectStartHour.setBounds(280, 108, 100, 28);

        JLabel jLabelEndHour = new JLabel("Selectionner une heure de fin :");
        jLabelEndHour.setBounds(20, 140, 250, 28);

        String[] EndHours = {"09h30", "11h00", "12h45", "14h15", "16H00", "17h30", "19h15"};
        JComboBox jComboBoxSelectEndHour = new JComboBox(EndHours);
        jComboBoxSelectEndHour.setBounds(280, 140, 100, 28);

        JLabel jLabelTeacher = new JLabel("Selectionner un Enseignant :");
        jLabelTeacher.setBounds(20, 170, 250, 28);

        String[] subject = {"MATH", "PHYS", "COSC"};
        JComboBox jComboBoxSelectSubject = new JComboBox(subject);
        jComboBoxSelectSubject.setBounds(280, 170, 100, 28);

        JTextField jTextFieldTeacher = new JTextField();
        jTextFieldTeacher.setBounds(390, 170, 195, 28);

        JLabel jLabelRoom = new JLabel("Selectionner une salle :");
        jLabelRoom.setBounds(20,  200, 250, 28);

        JTextField jTextFieldRoom = new JTextField();
        jTextFieldRoom.setBounds(280, 200, 200, 28);

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
        addFrame.add(jLabelEndHour);
        addFrame.add(jComboBoxSelectEndHour);
        addFrame.add(jLabelTeacher);
        addFrame.add(jComboBoxSelectSubject);
        addFrame.add(jTextFieldTeacher);
        addFrame.add(jLabelRoom);
        addFrame.add(jTextFieldRoom);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addFrame.dispose();
            }
        });

        addFrame.setTitle("Ajout d'un cours");
        addFrame.setSize(600,300);
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
                    if(!user.alreadyExist(jTextFieldId.getText())){
                        Teacher teacher = new Teacher(jTextFieldId.getText(), jTextFielEmailPart1.getText() + jTextFielEmailPart2.getText(), jTextFieldPassword.getText(), jTextFieldLastName.getText(), jTextFieldFirstName.getText(), "TEACHER", Objects.requireNonNull(jComboBoxSelectCourse.getSelectedItem()).toString());
                        teacher.createTeacher();
                    }
                    else System.out.println("Erreur Id deja utilise");
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
                    if(!std.alreadyExist(jTextFieldId.getText())){
                        Student student = new Student(jTextFieldId.getText(), jTextFielEmailPart1.getText() + jTextFielEmailPart2.getText(), jTextFieldPassword.getText(), jTextFieldLastName.getText(), jTextFieldFirstName.getText(), "STUDENT", jTextFieldNumber.getText(), Objects.requireNonNull(jComboBoxSelectGroup.getSelectedItem()).toString());
                        student.createStudent();
                    }
                    else System.out.println("Erreur Id deja utilise");
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
    public void suppCourseWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID du cours à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 50, 200, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonSupp);
        addFrame.add(jLabelIdCourse);
        addFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Suppression d'un cours");
        addFrame.setSize(600,180);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void suppTeacherWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID du professeur à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 270, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(300, 50, 200, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonSupp);
        addFrame.add(jLabelIdCourse);
        addFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Suppression d'un professeur");
        addFrame.setSize(600,180);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void suppStudentWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 120, 100, 28);
        JButton jButtonSupp = new JButton("Supprimer");
        jButtonSupp.setBounds(490, 120, 100, 28);

        JLabel jLabelIdCourse = new JLabel("Saissisez l'ID de l'étudiant à supprimer : ");
        jLabelIdCourse.setBounds(20, 50, 260, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(290, 50, 200, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonSupp);
        addFrame.add(jLabelIdCourse);
        addFrame.add(jTextFieldId);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Suppression d'un étudiant");
        addFrame.setSize(600,180);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void modCourseWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Modifier");
        jButtonAdd.setBounds(490, 240, 100, 28);

        JLabel jLabelIdSession = new JLabel("Saissisez l'ID de la session à modifier : ");
        jLabelIdSession.setBounds(20, 20, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelWeek = new JLabel("Saissisez la semaine de la session : ");
        jLabelWeek.setBounds(20, 48, 250, 28);

        JTextField jTextFieldWeek = new JTextField();
        jTextFieldWeek.setBounds(280, 48, 200, 28);

        JLabel jLabelSelectDate = new JLabel("Selectionner nouvelle une date :");
        jLabelSelectDate.setBounds(20, 80, 250, 28);

        Integer[] day = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
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

        String[] years = {"2019-2020", "2020-2021", "2021-2022"};
        JComboBox jComboBoxSelectYear = new JComboBox(years);
        jComboBoxSelectYear.setBounds(420, 80, 130, 28);

        JLabel jLabelStartHour = new JLabel("Selectionner une heure de début :");
        jLabelStartHour.setBounds(20, 108, 250, 28);

        String[] StartHours = {"08h00", "09h30", "11h15", "12h45", "14h30", "16H00", "17h45"};
        JComboBox jComboBoxSelectStartHour = new JComboBox(StartHours);
        jComboBoxSelectStartHour.setBounds(280, 108, 100, 28);

        JLabel jLabelEndHour = new JLabel("Selectionner une heure de fin :");
        jLabelEndHour.setBounds(20, 140, 250, 28);

        String[] EndHours = {"09h30", "11h00", "12h45", "14h15", "16H00", "17h30", "19h15"};
        JComboBox jComboBoxSelectEndHour = new JComboBox(EndHours);
        jComboBoxSelectEndHour.setBounds(280, 140, 100, 28);

        JLabel jLabelTeacher = new JLabel("Selectionner un Enseignant :");
        jLabelTeacher.setBounds(20, 170, 250, 28);

        String[] subject = {"MATH", "PHYS", "COSC"};
        JComboBox jComboBoxSelectSubject = new JComboBox(subject);
        jComboBoxSelectSubject.setBounds(280, 170, 100, 28);

        JTextField jTextFieldTeacher = new JTextField();
        jTextFieldTeacher.setBounds(390, 170, 195, 28);

        JLabel jLabelRoom = new JLabel("Selectionner une salle :");
        jLabelRoom.setBounds(20,  200, 250, 28);

        JTextField jTextFieldRoom = new JTextField();
        jTextFieldRoom.setBounds(280, 200, 200, 28);

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
        addFrame.add(jLabelEndHour);
        addFrame.add(jComboBoxSelectEndHour);
        addFrame.add(jLabelTeacher);
        addFrame.add(jComboBoxSelectSubject);
        addFrame.add(jTextFieldTeacher);
        addFrame.add(jLabelRoom);
        addFrame.add(jTextFieldRoom);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addFrame.dispose();
            }
        });

        addFrame.setTitle("Modification d'un cours");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void modTeacherWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Modifier");
        jButtonAdd.setBounds(490, 240, 100, 28);

        JLabel jLabelIdStudent = new JLabel("Saissisez l'ID du professeur à modifier : ");
        jLabelIdStudent.setBounds(20, 20, 260, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelEmail = new JLabel("Saissisez l'Email du professeur : ");
        jLabelEmail.setBounds(20, 48, 250, 28);

        JTextField jTextFielEmail = new JTextField();
        jTextFielEmail.setBounds(280, 48, 200, 28);

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

        JLabel jLabelNumber = new JLabel("Saissisez le numéro du professeur : ");
        jLabelNumber.setBounds(20, 170, 250, 28);

        JTextField jTextFieldNumber = new JTextField();
        jTextFieldNumber.setBounds(280, 170, 200, 28);

        JLabel jLabelSelectPromo = new JLabel("Selectionner une matière :");
        jLabelSelectPromo.setBounds(20, 200, 300, 28);

        String[] subject = {"MATH", "PHYS", "COSC"};
        JComboBox jComboBoxSelectSubject = new JComboBox(subject);
        jComboBoxSelectSubject.setBounds(280, 200, 100, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);
        addFrame.add(jLabelIdStudent);
        addFrame.add(jTextFieldId);
        addFrame.add(jLabelEmail);
        addFrame.add(jTextFielEmail);
        addFrame.add(jLabelPassword);
        addFrame.add(jTextFieldPassword);
        addFrame.add(jLabelLastName);
        addFrame.add(jTextFieldLastName);
        addFrame.add(jLabelFirstName);
        addFrame.add(jTextFieldFirstName);
        addFrame.add(jLabelNumber);
        addFrame.add(jTextFieldNumber);
        addFrame.add(jLabelSelectPromo);
        addFrame.add(jComboBoxSelectSubject);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Modification d'un professeur");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }
    public void modStudentWindow(){
        JFrame addFrame = new JFrame();

        JButton jButtonCanceled = new JButton("Annuler");
        jButtonCanceled.setBounds(380, 240, 100, 28);
        JButton jButtonAdd = new JButton("Ajouter");
        jButtonAdd.setBounds(490, 240, 100, 28);

        JLabel jLabelIdStudent = new JLabel("Saissisez l'ID de l'étudiant à modofier : ");
        jLabelIdStudent.setBounds(20, 20, 250, 28);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setBounds(280, 20, 200, 28);

        JLabel jLabelEmail = new JLabel("Saissisez l'Email de l'étudiant : ");
        jLabelEmail.setBounds(20, 48, 250, 28);

        JTextField jTextFielEmail = new JTextField();
        jTextFielEmail.setBounds(280, 48, 200, 28);

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

        String[] promotion = {"ING1", "ING2", "ING3"};
        JComboBox jComboBoxSelectPromotion = new JComboBox(promotion);
        jComboBoxSelectPromotion.setBounds(300, 200, 90, 28);

        String[] groupe = {"Groupe 1", "Groupe 2", "Groupe 3"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(390, 200, 150, 28);

        addFrame.add(jButtonCanceled);
        addFrame.add(jButtonAdd);
        addFrame.add(jLabelIdStudent);
        addFrame.add(jTextFieldId);
        addFrame.add(jLabelEmail);
        addFrame.add(jTextFielEmail);
        addFrame.add(jLabelPassword);
        addFrame.add(jTextFieldPassword);
        addFrame.add(jLabelLastName);
        addFrame.add(jTextFieldLastName);
        addFrame.add(jLabelFirstName);
        addFrame.add(jTextFieldFirstName);
        addFrame.add(jLabelNumber);
        addFrame.add(jTextFieldNumber);
        addFrame.add(jLabelSelectPromo);
        addFrame.add(jComboBoxSelectPromotion);
        addFrame.add(jComboBoxSelectGroupe);

        jButtonCanceled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setTitle("Modification d'un étudiant");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
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
