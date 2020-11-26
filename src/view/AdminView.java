package view;

import controller.ControllerAdmin;
import controller.TestConnection;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminView extends JFrame{

    public AdminView(TestConnection testConnection){
        JFrame frame = new JFrame();

        interfaceAdmin(frame);

        // set the Parameters of the JFrame
        frame.setTitle(testConnection.getUser().getFirstName() + " " + testConnection.getUser().getLastName());
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.red);
        frame.setOpacity(1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void interfaceAdmin(JFrame jFrame){

        ControllerAdmin controllerAdmin = new ControllerAdmin();

        /** Creation du menuBar */
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        /** Creation des menus */
        JMenu menuStudent = new JMenu();
        JMenu menuTeacher = new JMenu();
        JMenu menuRoom = new JMenu();
        JMenu menuUpdate = new JMenu();
        JMenu menuPersonalInfo = new JMenu();

        /**  Ajout des menu dans la barre de menu */
        menuBar.add(menuStudent);
        menuBar.add(menuTeacher);
        menuBar.add(menuRoom);
        menuBar.add(menuUpdate);
        menuBar.add(menuPersonalInfo);

        /**  affecter le texte des menus */
        menuStudent.setText("Etudiant");
        menuTeacher.setText("Professeur");
        menuRoom.setText("Salles");
        menuUpdate.setText("Mise a Jour des Données");
        menuPersonalInfo.setText("Infos Personnel");

        /** Creation des items Student */
        JMenuItem miListStudent = new JMenuItem("Liste des Etudiants");
        JMenuItem miCourseStudent = new JMenuItem("Récapitulatif des Cours");

        /** Creation des items Teacher */
        JMenuItem miListTeacher = new JMenuItem("Liste des Enseignants");
        JMenuItem miCourseTeacher = new JMenuItem("Récapitulatif des Cours");

        /** Creation des sous menus et items MAJ Données */
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

        /** Item de menu actif */
        miListStudent.setEnabled(true);
        miCourseStudent.setEnabled(true);

        miListTeacher.setEnabled(true);
        miCourseTeacher.setEnabled(true);

        mAdd.setEnabled(true);
        mSupp.setEnabled(true);
        mMod.setEnabled(true);

        /** Ajout des items aux menus */
        menuStudent.add(miListStudent);
        menuStudent.add(miCourseStudent);

        menuTeacher.add(miListTeacher);
        menuTeacher.add(miCourseTeacher);

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

        /** Action suite selection Item */
        miListStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createPromotionChoice(jFrame, controllerAdmin);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        /*******************************************************/
        miCourseStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                try {
                    createCourseRecap(jFrame, controllerAdmin);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        /*******************************************************/
        miListTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                createSubjectChoice(jFrame);
            }
        });

        /*******************************************************/
        miCourseTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                selectListTeacher(jFrame);
            }
        });

        /*******************************************************/
        miCourse1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                addCourseWindow();
            }
        });

        /*******************************************************/
        miStudent1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                addStudentWindow();
            }
        });

        /*******************************************************/
        miTeacher1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                addTeacherWindow();
            }
        });

        /*******************************************************/
        miCourse2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppCourseWindow();
            }
        });

        /*******************************************************/
        miTeacher2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppTeacherWindow();
            }
        });

        /*******************************************************/
        miStudent2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                suppStudentWindow();
            }
        });

        /*******************************************************/
        miCourse3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modCourseWindow();
            }
        });

        /*******************************************************/
        miTeacher3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modTeacherWindow();
            }
        });

        /*******************************************************/
        miStudent3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                modStudentWindow();
            }
        });

        /*******************************************************/
        menuPersonalInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.dispose();
                personalInfo(jFrame);
            }
        });

        /*******************************************************/
        jFrame.setVisible(true);
    }

    /*******************************************************/
    public void createPromotionChoice(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        /** Exemple de creation d'un ComboBox */
        JLabel jLabelSelectPromo = new JLabel("Selectionner une Promotion et un groupe :");
        jLabelSelectPromo.setBounds(40, 10, 300, 28);
        jFrame.add(jLabelSelectPromo);

        ArrayList<String> promotions = controllerAdmin.getAllIdPromotion();

        String str[] = new String[promotions.size()];

        for (int j = 0; j < promotions.size(); j++) {
            str[j] = promotions.get(j);
        }

        JComboBox jComboBoxSelectPromotion = new JComboBox(str);
        jComboBoxSelectPromotion.setBounds(40, 40, 100, 28);

        jComboBoxSelectPromotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*for(int i = 0; i < promotions.length; i++) {
                    if(jComboBoxSelectPromotion.getSelectedIndex() == i){
                        System.out.println(i+1);
                    }
                }*/

                if (jComboBoxSelectPromotion.getSelectedItem().equals("ING1")){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice1(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
                else if(jComboBoxSelectPromotion.getSelectedItem() == "ING2"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice2(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
                else if(jComboBoxSelectPromotion.getSelectedItem() == "ING3"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice3(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
            }
        });

        jFrame.add(jComboBoxSelectPromotion);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice1(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){

                    /*DefaultListModel dlm = new DefaultListModel();
                    dlm.addElement("admin");
                    JList liste = new JList(dlm);
                    jFrame.add(liste);
                    jFrame.setVisible(true);*/
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice2(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2", "Groupe 3"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 3"){
                    System.out.println("emploi du temps groupe 3");
                }
            }
        });

        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice3(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
            }
        });

        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    /*******************************************************/
    public void createCourseRecap(JFrame jFrame, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        /** Exemple de creation d'un ComboBox */
        JLabel jLabelSelectPromo = new JLabel("Selectionner une Promotion et un groupe :");
        jLabelSelectPromo.setBounds(40, 10, 300, 28);
        jFrame.add(jLabelSelectPromo);

        ArrayList<String> promotions = controllerAdmin.getAllIdPromotion();

        String str[] = new String[promotions.size()];

        for (int j = 0; j < promotions.size(); j++) {
            str[j] = promotions.get(j);
        }

        JComboBox jComboBoxSelectPromotion = new JComboBox(str);
        jComboBoxSelectPromotion.setBounds(40, 40, 100, 28);

        jComboBoxSelectPromotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectPromotion.getSelectedItem() == "ING1"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice12(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
                else if(jComboBoxSelectPromotion.getSelectedItem() == "ING2"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice22(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
                else if(jComboBoxSelectPromotion.getSelectedItem() == "ING3"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectPromotion);
                    jFrame.add(jLabelSelectPromo);
                    createGroupeChoice32(jFrame);
                    jComboBoxSelectPromotion.setEnabled(true);
                }
            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectPromotion);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice12(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
            }
        });

        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice22(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2", "Groupe 3"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 3"){
                    System.out.println("emploi du temps groupe 3");
                }
            }
        });

        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    public void createGroupeChoice32(JFrame jFrame){
        String[] groupe = {"Groupe 1", "Groupe 2"};
        JComboBox jComboBoxSelectGroupe = new JComboBox(groupe);
        jComboBoxSelectGroupe.setBounds(160, 40, 200, 28);

        jComboBoxSelectGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectGroupe.getSelectedItem() == "Groupe 1"){
                    System.out.println("emploi du temps groupe 1");
                }
                else if(jComboBoxSelectGroupe.getSelectedItem() == "Groupe 2"){
                    System.out.println("emploi du temps groupe 2");
                }
            }
        });

        jFrame.add(jComboBoxSelectGroupe);
        jFrame.setVisible(true);
    }

    /*******************************************************/
    public void createSubjectChoice(JFrame jFrame){
        JLabel jLabelSelectSubject = new JLabel("Selectionner une Matière :");
        jLabelSelectSubject.setBounds(40, 10, 300, 28);
        jFrame.add(jLabelSelectSubject);

        String[] subject = {"MATH", "PHYS", "COSC"};
        JComboBox jComboBoxSelectSubject = new JComboBox(subject);
        jComboBoxSelectSubject.setBounds(40, 40, 100, 28);

        jComboBoxSelectSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jComboBoxSelectSubject.getSelectedItem() == "MATH"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectSubject);
                    jFrame.add(jLabelSelectSubject);
                    createTeacherListMath(jFrame);
                    jComboBoxSelectSubject.setEnabled(true);
                }
                else if(jComboBoxSelectSubject.getSelectedItem() == "PHYS"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectSubject);
                    jFrame.add(jLabelSelectSubject);
                    createTeacherListPhys(jFrame);
                    jComboBoxSelectSubject.setEnabled(true);
                }
                else if(jComboBoxSelectSubject.getSelectedItem() == "COSC"){
                    jFrame.getContentPane().removeAll();
                    jFrame.add(jComboBoxSelectSubject);
                    jFrame.add(jLabelSelectSubject);
                    createTeacherListCosc(jFrame);
                    jComboBoxSelectSubject.setEnabled(true);
                }
            }
        });

        jFrame.setLayout(null);
        jFrame.add(jComboBoxSelectSubject);
        jFrame.setVisible(true);
    }

    public void createTeacherListMath(JFrame jFrame){

    }

    public void createTeacherListPhys(JFrame jFrame){

    }

    public void createTeacherListCosc(JFrame jFrame){

    }

    /*******************************************************/
    public void selectListTeacher(JFrame jFrame){}

    /*******************************************************/
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

    public void addTeacherWindow(){
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

        addFrame.setTitle("Ajout d'un professeur");
        addFrame.setSize(600,300);
        addFrame.setLocation(200, 100);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
    }

    public void addStudentWindow(){
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

    /*******************************************************/
    public void personalInfo(JFrame jFrame){
        JLabel accountLabel = new JLabel("<b/>Compte");
        jFrame.add(accountLabel);
    }
}
