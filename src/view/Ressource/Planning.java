package view.Ressource;

import model.Course;
import model.Group;
import model.Room;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Planning extends JPanel {
    private Group groupe;
    public Planning(Group Groupe, Frame frame) {
        this.groupe = Groupe;
        setSettings(frame);
    }
    public Planning() {
    }

    public Planning(Group groupe, Frame frame, int Week) {
        this.groupe = groupe;
        setSettings(frame);
        DrawWeekCours_Student(frame,groupe,Week);
    }

    public String addChar(String str, char ch, int position) {
            int len = str.length();
            char[] updatedArr = new char[len + 1];
            str.getChars(0, position, updatedArr, 0);
            updatedArr[position] = ch;
            str.getChars(position, len, updatedArr, position + 1);
            return new String(updatedArr);
        }

/*
    public String FindNameDay(String Date){
        int JourACalculer;
        int CodeAnnee;
        int CodeMois;
        int jourTrouver = (JourACalculer%7+CodeAnnee%7+CodeMois)%7;

        if(jourTrouver == 1) {return "lundi";}
        if(jourTrouver == 2) {return "mardi";}
        if(jourTrouver == 3) {return "mercredi";}
        if(jourTrouver == 4) {return "jeudi";}
        if(jourTrouver == 5) {return "vendredi";}
        if(jourTrouver == 6) {return "samedi";}
    }
*/

        public void setCours(Frame frame,String day , String heure , String NameCours , String RoomCours){
            int y = 220;
            int x =50;
            if (day.equals("mardi")){
                x+= 190;
            }
            if (day.equals("mercredi")){
                x+= 190*2;
            }
            if (day.equals("jeudi")){
                x+= 190*3;
            }
            if (day.equals("vendredi")){
                x+= 190*4;
            }
            if (day.equals("samedi")){
                x+= 190*5;
            }

            if(heure.equals("8h00-9h30")){
            }
            if(heure.equals("9h30-11h00")){
                y+=57;
            }
            if(heure.equals("11h15-12h45")){
                y+=57*2+15;
            }
            if(heure.equals("12h45-14h15")){
                y+=57*3+15;
            }
            if(heure.equals("14h30-16h00")){
                y+=57*4+34;
            }
            if(heure.equals("16h00-17h30")){
                y+=57*6-23;
            }
            if(heure.equals("17h45-19h15")){
                y+=57*7;
            }
            if(heure.equals("19h15-20h45")){
                y+=57*8;
            }

            JLabel cours = new JLabel(NameCours,SwingConstants.CENTER);
            JLabel numRoom = new JLabel(RoomCours,SwingConstants.CENTER);

            JPanel textPanel = new JPanel();
            textPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            cours.setBackground(Color.yellow);
            numRoom.setBackground(Color.yellow);
            textPanel.setBackground(Color.yellow);
            //textPanel.setForeground(Color.YELLOW);

            textPanel.add(cours);
            textPanel.add(numRoom);
            textPanel.setBounds(x,y,185,55);

            frame.add(textPanel);
            cours.setOpaque(true);
            textPanel.setOpaque(true);


        }

        public void setSettings(Frame frame) {

            frame.setBackground(Color.red);

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
            Day.add("Lundi+00/00+month");
            Day.add("Mardi+00/00+month");
            Day.add("Mercredi+00/00+month");
            Day.add("Jeudi+00/00+month");
            Day.add("Vendredi+00/00+month");
            Day.add("Samedi+00/00+month" );


            int y = 182;
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
            int yDate = 155;
            for (int j =0;j< 6;++j){
                JLabel label_id = new JLabel(Day.get(j));
                label_id.setBounds(xDate, yDate, 200, 100);
                frame.add(label_id);
                xDate+=188;


            }
            JPanel ListWeek = new JPanel();
            ListWeek.setBounds(150,130,1000,25);
            JPanel ListMonth = new JPanel();
            ListMonth.setBounds(150,155,1000,15);


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
            for(int i =32; i < 54;++i) {
                JButton Week = new JButton("" + i);
                Week.setBackground(Color.GRAY);
                Week.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                Week.setOpaque(true);
                ListWeek.add(Week);


            }
            for(int i =1; i < 31;++i) {
                JButton Week = new JButton("" + i );
                Week.setBackground(Color.GRAY);
                Week.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                Week.setOpaque(true);
                ListWeek.add(Week);


            }
            frame.add(ListWeek);
            frame.add(ListMonth);
        }

        public void DrawWeekCours_Student(Frame frame,Group groupe, int week){

            java.util.List<Course> ListMatiere = groupe.getGroupCours();
            String NameGrp = groupe.getNameGroup();
            java.util.List<java.util.List<Session>> sessionTot = null;
            java.util.List<Session> mySessionTot= null;
            java.util.List<Session> myWeekSession = null;
            for (Course cour : ListMatiere) {
                assert false;
                sessionTot.add(cour.getListSession());
            }
            for(int j =0;j<sessionTot.size();++j){
                for(int i=0;i<sessionTot.get(j).size();i++){
                    mySessionTot.add(sessionTot.get(j).get(i));
                }
            }
            for(int i=0;i<mySessionTot.size();++i){
                if ( mySessionTot.get(i).getWeek() == week ) {
                    myWeekSession.add(mySessionTot.get(i));
                }
            }
            for(int i=0;i<myWeekSession.size();++i){
                String day = myWeekSession.get(i).getDate();
                String heureDebut = myWeekSession.get(i).getStartTime();
                String heureFin = myWeekSession.get(i).getEndTime();
                String heure = heureDebut+heureFin;
                addChar(heure,'-',5);
                Course nameCours = myWeekSession.get(i).getCours();
                String NameCours = nameCours.getNameCourse();
                List<Room> myListRoomThisSession = myWeekSession.get(i).getRoomSession();
                int y = 220;
                int x =50;
                if (day.equals("mardi")){
                    x+= 190;
                }
                if (day.equals("mercredi")){
                    x+= 190*2;
                }
                if (day.equals("jeudi")){
                    x+= 190*3;
                }
                if (day.equals("vendredi")){
                    x+= 190*4;
                }
                if (day.equals("samedi")){
                    x+= 190*5;
                }
                if(heure.equals("08h00-9h30")){
                }
                if(heure.equals("09h30-11h00")){
                    y+=57;
                }
                if(heure.equals("11h15-12h45")){
                    y+=57*2;
                }
                if(heure.equals("12h45-14h15")){
                    y+=57*3;
                }
                if(heure.equals("14h30-16h00")){
                    y+=57*4;
                }
                if(heure.equals("16h00-17h30")){
                    y+=57*5;
                }
                if(heure.equals("17h45-19h15")){
                    y+=57*6;
                }
                if(heure.equals("19h15-20h45")){
                    y+=57*7;
                }
                JLabel name_cours = new JLabel(NameCours,SwingConstants.CENTER);
                JPanel textPanel = new JPanel();
                for (int z =1;z<myListRoomThisSession.size();z++){
                    String a;
                    a=myListRoomThisSession.get(z-1).getNameRoom()+" ; "+myListRoomThisSession.get(z).getNameRoom();

                    JLabel numRoom = new JLabel(a,SwingConstants.CENTER);
                    numRoom.setBackground(Color.yellow);
                    textPanel.add(numRoom);
                }
                JLabel namegrp = new JLabel(NameGrp,SwingConstants.RIGHT);
                textPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                name_cours.setBackground(Color.yellow);
                textPanel.setBackground(Color.yellow);
                textPanel.add(name_cours);
                textPanel.add(namegrp);
                textPanel.setBounds(x,y,185,55);
                frame.add(textPanel);
                name_cours.setOpaque(true);
                textPanel.setOpaque(true);
            }
        }



        public void setEmploiDuTemps(Graphics g2) {
            g2.setColor(Color.gray);
            int x = 50;
            int y = 220;
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 13; ++j) {
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



