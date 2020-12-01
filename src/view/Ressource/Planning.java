package view.Ressource;

import controller.ControllerAdmin;
import controller.ControllerStudent;
import controller.ControllerTeacher;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Planning extends JPanel {

    public String addChar(String str, char ch, int position) {
            int len = str.length();
            char[] updatedArr = new char[len + 1];
            str.getChars(0, position, updatedArr, 0);
            updatedArr[position] = ch;
            str.getChars(position, len, updatedArr, position + 1);
            return new String(updatedArr);
        }

    public void setSettings(Frame frame) {
        ArrayList<String> heure = new ArrayList<>();
        heure.add("8h00");
        heure.add("9h30");
        heure.add("11h00");
        heure.add("11h15");
        heure.add("12h45");
        heure.add("14h15");
        heure.add("14h30");
        heure.add("16h00");
        heure.add("17h30");
        heure.add("17h45");
        heure.add("19h15");
        heure.add("20h45");
        heure.add("21h00");

        ArrayList<String> Day = new ArrayList<>();
        Day.add("Lundi");
        Day.add("Mardi");
        Day.add("Mercredi");
        Day.add("Jeudi");
        Day.add("Vendredi");
        Day.add("Samedi" );

        int y = 114;
        JLabel label_id_8h00 = new JLabel(heure.get(0));
        label_id_8h00.setBounds(5, y, 45, 80);
        frame.add(label_id_8h00);

        JLabel label_id2_9h30 = new JLabel(heure.get(1));
        label_id2_9h30.setBounds(5, y+55, 45, 80);
        frame.add(label_id2_9h30);

        JLabel label_id_11h00 = new JLabel(heure.get(2));
        label_id_11h00.setBounds(5, y+2*55, 45, 80);
        frame.add(label_id_11h00);

        JLabel label_id_11h15= new JLabel(heure.get(3));
        label_id_11h15.setBounds(5, y+2*55+15, 45, 80);
        frame.add(label_id_11h15);

        JLabel label_id5_12h45 = new JLabel(heure.get(4));
        label_id5_12h45.setBounds(5, y+3*55+20, 45, 80);
        frame.add(label_id5_12h45);

        JLabel label_id_14h15 = new JLabel(heure.get(5));
        label_id_14h15.setBounds(5, y+4*55+15, 45, 80);
        frame.add(label_id_14h15);

        JLabel label_id_14h30= new JLabel(heure.get(6));
        label_id_14h30.setBounds(5, y+4*55+30, 45, 80);
        frame.add(label_id_14h30);

        JLabel label_id_16h00 = new JLabel(heure.get(7));
        label_id_16h00.setBounds(5, y+6*55-10, 45, 80);
        frame.add(label_id_16h00);

        JLabel label_id_17h30 = new JLabel(heure.get(8));
        label_id_17h30.setBounds(5, y+7*55-9, 45, 80);
        frame.add(label_id_17h30);

        JLabel label_id_17h45 = new JLabel(heure.get(9));
        label_id_17h45.setBounds(5, y+7*55+6, 45, 80);
        frame.add(label_id_17h45);

        JLabel label_id_19h15 = new JLabel(heure.get(10));
        label_id_19h15.setBounds(5, y+8*55+3, 45, 80);
        frame.add(label_id_19h15);

        JLabel label_id_20h45 = new JLabel(heure.get(11));
        label_id_20h45.setBounds(5, y+9*55+8, 45, 80);
        frame.add(label_id_20h45);

        JLabel label_id_21h00 = new JLabel(heure.get(12));
        label_id_21h00.setBounds(5, y+9*55+21, 45, 80);
        frame.add(label_id_21h00);


        int xDate = 75;
        int yDate = 92;
        for (int j = 0; j < 6; ++j){
            JLabel label_id = new JLabel(Day.get(j));
            label_id.setBounds(xDate, yDate, 200, 100);
            frame.add(label_id);
            xDate+=188;
        }
        JPanel ListWeek = new JPanel();
        ListWeek.setBounds(150,80,1000,25);
        JPanel ListMonth = new JPanel();
        ListMonth.setBounds(150,105,1000,15);

        ListMonth.setBackground(Color.black);
        ListMonth.setLayout(new GridLayout(1,12));
        ListMonth.setOpaque(false);

        ListWeek.setBackground(Color.black);
        ListWeek.setOpaque(false);
        ListWeek.setLayout(new GridLayout(1,51));
        ListWeek.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        for(int z =0;z<12;z++){
            switch (z){
                case 0 :
                    JButton Month = new JButton("août");
                    Month.setBackground(Color.white);
                    Month.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month.setOpaque(true);
                    ListMonth.add(Month);
                    break;

                case 1 :
                    JButton Month1 = new JButton("septembre");
                    Month1.setBackground(Color.white);
                    Month1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month1.setOpaque(true);
                    ListMonth.add(Month1);
                    break;
                case 2 :
                    JButton Month2 = new JButton("octobre");
                    Month2.setBackground(Color.white);
                    Month2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month2.setOpaque(true);
                    ListMonth.add(Month2);
                    break;


                case 3 :
                    JButton Month3 = new JButton("novembre");
                    Month3.setBackground(Color.white);
                    Month3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month3.setOpaque(true);
                    ListMonth.add(Month3);
                    break;
                case 4 :
                    JButton Month4 = new JButton("decembre");
                    Month4.setBackground(Color.white);
                    Month4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month4.setOpaque(true);
                    ListMonth.add(Month4);
                    break;
                case 5 :
                    JButton Month5 = new JButton("janvier");
                    Month5.setBackground(Color.white);
                    Month5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month5.setOpaque(true);
                    ListMonth.add(Month5);
                    break;
                case 6 :
                    JButton Month6 = new JButton("fevrier");
                    Month6.setBackground(Color.white);
                    Month6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month6.setOpaque(true);
                    ListMonth.add(Month6);
                    break;
                case 7 :
                    JButton Month7 = new JButton("mars");
                    Month7.setBackground(Color.white);
                    Month7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month7.setOpaque(true);
                    ListMonth.add(Month7);
                    break;
                case 8 :
                    JButton Month8 = new JButton("avril");
                    Month8.setBackground(Color.white);
                    Month8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month8.setOpaque(true);
                    ListMonth.add(Month8);
                case 9 :
                    JButton Month9 = new JButton("mai");
                    Month9.setBackground(Color.white);
                    Month9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month9.setOpaque(true);
                    ListMonth.add(Month9);
                    break;

                case 10 :
                    JButton Month10 = new JButton("juin");
                    Month10.setBackground(Color.white);
                    Month10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month10.setOpaque(true);
                    ListMonth.add(Month10);
                    break;

                case 11 :
                    JButton Month11 = new JButton("juillet");
                    Month11.setBackground(Color.white);
                    Month11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    Month11.setOpaque(true);
                    ListMonth.add(Month11);
                    break;
            }
        }

        int cnt =32;
        for(int i =32; i < 54;++i){
            JButton Week = new JButton("" + i);
            Week.setBackground(Color.GRAY);
            Week.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            Week.setOpaque(true);
            ListWeek.add(Week);
        }
        for(int i =1; i < 31;++i){
            JButton Week = new JButton("" + i );
            Week.setBackground(Color.GRAY);
            Week.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            Week.setOpaque(true);
            ListWeek.add(Week);
        }
        frame.add(ListWeek);
        frame.add(ListMonth);
    }

    public void DrawStudentPlanningForAdmin(Frame frame, String idGroupe, int week) throws SQLException, ClassNotFoundException{
        ControllerAdmin controller = new ControllerAdmin();
        ArrayList<Session> sessions = controller.getAllSession1(idGroupe);
        ArrayList<Session> myWeekSession= new ArrayList<>();

        for(int i = 0;i< sessions.size();++i){
            if(sessions.get(i).getWeek() == week){
                myWeekSession.add(sessions.get(i));
            }
        }

        ArrayList<Date> listDate = new ArrayList<>();
        for(int i=0;i<myWeekSession.size();++i){

            Date date = myWeekSession.get(i).getDate();
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            int nameDay = date.getDay();

            Time startTime = myWeekSession.get(i).getStartTime();
            Time endTime = myWeekSession.get(i).getEndTime();

            String heureDebutString = dateFormat.format(startTime);
            String heureFinString = dateFormat.format(endTime);

            String heure = heureDebutString+heureFinString;
            heure = addChar(heure,'-',8);

            int y = 174;
            int x = 50;
            if (nameDay == 1){ // equals("lundi")
            }
            if (nameDay == 2){ // equals("mardi")
                x+= 190;
            }
            if (nameDay == 3){ // equals("mercredi"))
                x+= 190*2;
            }
            if (nameDay == 4){ // equals("jeudi")
                x+= 190*3;
            }
            if (nameDay == 5){ // equals("vendredi")
                x+= 190*4;
            }
            if (nameDay == 6){ // equals("samedi"))
                x+= 190*5;
            }
            if(heureDebutString.equals("09:00:00")){}
            if(heureDebutString.equals("10:30:00")){
                y+=57;
            }
            if(heureDebutString.equals("12:15:00")){
                y+=57*2+10;
            }
            if(heureDebutString.equals("01:45:00")){
                y+=57*3+10;
            }
            if(heureDebutString.equals("03:30:00")){
                y+=57*4+25;
            }
            if(heureDebutString.equals("05:00:00")){
                y+=57*5+25;
            }
            if(heureDebutString.equals("06:45:00")){
                y+=57*6+35;
            }
            if(heureDebutString.equals("08:15:00")){
                y+=57*7+35;
            }

            String nameRoom = myWeekSession.get(i).getRoom().getNameRoom();
            String nameCourse = myWeekSession.get(i).getIdCourse();
            String typeCourse = myWeekSession.get(i).getType();
            String nameTeacher = myWeekSession.get(i).getTeacherName();

            JPanel textPanel = new JPanel();
            textPanel.setLayout(null);
            JTextArea courseInfo = new JTextArea(nameCourse + "-" + typeCourse + "-M." + nameTeacher + "\n"  + " " + nameRoom);
            courseInfo.setEditable(false);
            courseInfo.setBounds(5, 10, 178, 30);
            courseInfo.setBackground(Color.yellow);
            textPanel.setBackground(Color.yellow);
            textPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            textPanel.add(courseInfo);
            textPanel.setBounds(x,y,185,55);
            textPanel.setOpaque(true);
            frame.add(textPanel);
            frame.repaint();
        }
    }

    public void DrawStudentPlanningForStudent(Frame frame, String idGroupe, String idUser, int week) throws SQLException, ClassNotFoundException{
        ControllerStudent controller = new ControllerStudent(idUser);
        ArrayList<Session> sessions = controller.getAllSession(idGroupe);
        ArrayList<Session> myWeekSession= new ArrayList<>();

        for(int i = 0;i< sessions.size();++i){
            if(sessions.get(i).getWeek() == week){
                myWeekSession.add(sessions.get(i));
            }
        }

        ArrayList<Date> listDate = new ArrayList<>();
        for(int i=0;i<myWeekSession.size();++i){

            Date date = myWeekSession.get(i).getDate();
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            int nameDay = date.getDay();

            Time startTime = myWeekSession.get(i).getStartTime();
            Time endTime = myWeekSession.get(i).getEndTime();

            String heureDebutString = dateFormat.format(startTime);
            String heureFinString = dateFormat.format(endTime);

            String heure = heureDebutString+heureFinString;
            heure = addChar(heure,'-',8);

            int y = 174;
            int x = 50;
            if (nameDay == 1){ // equals("lundi")
            }
            if (nameDay == 2){ // equals("mardi")
                x+= 190;
            }
            if (nameDay == 3){ // equals("mercredi"))
                x+= 190*2;
            }
            if (nameDay == 4){ // equals("jeudi")
                x+= 190*3;
            }
            if (nameDay == 5){ // equals("vendredi")
                x+= 190*4;
            }
            if (nameDay == 6){ // equals("samedi"))
                x+= 190*5;
            }
            if(heureDebutString.equals("09:00:00")){}
            if(heureDebutString.equals("10:30:00")){
                y+=57;
            }
            if(heureDebutString.equals("12:15:00")){
                y+=57*2+10;
            }
            if(heureDebutString.equals("01:45:00")){
                y+=57*3+10;
            }
            if(heureDebutString.equals("03:30:00")){
                y+=57*4+25;
            }
            if(heureDebutString.equals("05:00:00")){
                y+=57*5+25;
            }
            if(heureDebutString.equals("06:45:00")){
                y+=57*6+35;
            }
            if(heureDebutString.equals("08:15:00")){
                y+=57*7+35;
            }

            String nameRoom = myWeekSession.get(i).getRoom().getNameRoom();
            String nameCourse = myWeekSession.get(i).getIdCourse();
            String typeCourse = myWeekSession.get(i).getType();
            String nameTeacher = myWeekSession.get(i).getTeacherName();

            JPanel textPanel = new JPanel();
            textPanel.setLayout(null);
            JTextArea testInfo = new JTextArea(nameCourse + "-" + typeCourse + "-M." + nameTeacher + "\n"  + " " + nameRoom);
            testInfo.setEditable(false);
            testInfo.setBounds(5, 10, 178, 30);
            testInfo.setBackground(Color.yellow);
            textPanel.setBackground(Color.yellow);
            textPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            textPanel.add(testInfo);
            textPanel.setBounds(x,y,185,55);
            textPanel.setOpaque(true);
            frame.add(textPanel);
        }
    }

    public void DrawTeacherPlanningForTeacher(Frame frame, String idUser, int week) throws SQLException, ClassNotFoundException{
        ControllerTeacher controller = new ControllerTeacher(idUser);
        ArrayList<Session> sessions = controller.getAllSession(idUser);
        ArrayList<Session> myWeekSession= new ArrayList<>();

        for(int i = 0;i< sessions.size();++i){
            if(sessions.get(i).getWeek() == week){
                myWeekSession.add(sessions.get(i));
            }
        }

        ArrayList<Date> listDate = new ArrayList<>();
        for(int i=0;i<myWeekSession.size();++i){

            Date date = myWeekSession.get(i).getDate();
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            int nameDay = date.getDay();

            Time startTime = myWeekSession.get(i).getStartTime();
            Time endTime = myWeekSession.get(i).getEndTime();

            String heureDebutString = dateFormat.format(startTime);
            String heureFinString = dateFormat.format(endTime);

            String heure = heureDebutString+heureFinString;
            heure = addChar(heure,'-',8);

            int y = 174;
            int x = 50;
            if (nameDay == 1){ // equals("lundi")
            }
            if (nameDay == 2){ // equals("mardi")
                x+= 190;
            }
            if (nameDay == 3){ // equals("mercredi"))
                x+= 190*2;
            }
            if (nameDay == 4){ // equals("jeudi")
                x+= 190*3;
            }
            if (nameDay == 5){ // equals("vendredi")
                x+= 190*4;
            }
            if (nameDay == 6){ // equals("samedi"))
                x+= 190*5;
            }
            if(heureDebutString.equals("09:00:00")){}
            if(heureDebutString.equals("10:30:00")){
                y+=57;
            }
            if(heureDebutString.equals("12:15:00")){
                y+=57*2+10;
            }
            if(heureDebutString.equals("01:45:00")){
                y+=57*3+10;
            }
            if(heureDebutString.equals("03:30:00")){
                y+=57*4+25;
            }
            if(heureDebutString.equals("05:00:00")){
                y+=57*5+25;
            }
            if(heureDebutString.equals("06:45:00")){
                y+=57*6+35;
            }
            if(heureDebutString.equals("08:15:00")){
                y+=57*7+35;
            }

            String nameRoom = myWeekSession.get(i).getRoom().getNameRoom();
            String nameCourse = myWeekSession.get(i).getIdCourse();
            String typeCourse = myWeekSession.get(i).getType();
            String nameGroup = myWeekSession.get(i).getIdGroupSession();

            JPanel textPanel = new JPanel();
            textPanel.setLayout(null);
            JTextArea courseInfo = new JTextArea(nameCourse + "-" + typeCourse + "-" + nameGroup + "\n"  + " " + nameRoom);
            courseInfo.setEditable(false);
            courseInfo.setBounds(5, 10, 178, 30);
            courseInfo.setBackground(Color.yellow);
            textPanel.setBackground(Color.yellow);
            textPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            textPanel.add(courseInfo);
            textPanel.setBounds(x,y,185,55);
            textPanel.setOpaque(true);
            frame.add(textPanel);
        }
    }

    public void setEmploiDuTemps(Graphics g2) {
        g2.setColor(Color.gray);
        int x = 50;
        int y = 220;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 13; ++j) {

                 JLabel panel = new JLabel();
                 panel.setBounds(x, y, 185, 38);
                 setBackground(Color.GRAY);
                 g2.fillRect(x, y, 185, 38); // fill new rectangle with color blue

                y += 40;
            }
            y = 220;
            x += 190;
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        // clear the previous painting
        super.paintComponent(g);
        // cast Graphics to Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        setEmploiDuTemps(g2);

    }

}



