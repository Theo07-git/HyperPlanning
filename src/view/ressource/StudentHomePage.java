package view.Ressource;

import controller.ControllerStudent;
import controller.TestConnection;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/*
panel1 = new JPanel();
        label1 = new JLabel();
        Sites = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        MyGroup = new JPanel();
        scrollPane2 = new JScrollPane();
        //userTab = new JTable();
        label3 = new JLabel();
        panel2 = new JPanel();
        Background = new JLabel();

        ArrayList<ArrayList<String>> students = controllerStudent.getAllStudents(controllerStudent.getStudent().getIdGroupPromotion());
        String[] tableTitle = {"Nom", "Prenom", "Email"};
        String[][] mt = new String[students.size()][tableTitle.length];
        for(int i = 0 ; i < students.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = students.get(i).get(j);
            }
        }
        userTab = new JTable(mt, tableTitle);

        int [] myTot = controllerStudent.numberSessionOfCourse(controllerStudent.getAllSession(controllerStudent.getStudent().getIdGroupPromotion()));

        String[] tableTitle2 = {"Matières", "Total séances"};
        String[][] mt2 = new String[myTot.length][tableTitle2.length];
        for(int i = 0 ; i < myTot.length; i++){
            for (int j = 0; j < tableTitle2.length; j++) {
                if (i==0){
                    mt2[i][0] = String.valueOf(myTot[i]);
                    mt2[i][1] = "Mathématiques";}
                if(i==1){
                    mt2[i][0] = String.valueOf(myTot[i]);
                    mt2[i][1] = "Informatique";}
                if(i==2){
                    mt2[i][0] = String.valueOf(myTot[i]);
                    mt2[i][1] = "Physique";}
                }
            }

        table1 = new JTable(mt2, tableTitle2);

 */


public class StudentHomePage {

    public TestConnection testConnection;

    public ControllerStudent controllerStudent;
    public StudentHomePage(TestConnection testConnection) throws SQLException, ClassNotFoundException {
        this.testConnection = testConnection;
        this.controllerStudent = new ControllerStudent(testConnection.getUser().getId());
        initComponents();
    }

    private void initComponents() throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - biollay
        panel1 = new JPanel();
        label1 = new JLabel();
        Sites = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        MyGroup = new JPanel();
        scrollPane2 = new JScrollPane();
        //userTab = new JTable();
        label3 = new JLabel();
        panel2 = new JPanel();
        Background = new JLabel();

        ArrayList<ArrayList<String>> students = controllerStudent.getAllStudents(controllerStudent.getStudent().getIdGroupPromotion());
        String[] tableTitle = {"Nom", "Prenom", "Email"};
        String[][] mt = new String[students.size()][tableTitle.length];
        for(int i = 0 ; i < students.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = students.get(i).get(j);
            }
        }
        userTab = new JTable(mt, tableTitle);

        int [] myTot = controllerStudent.numberSessionOfCourse(controllerStudent.getAllSession(controllerStudent.getStudent().getIdGroupPromotion()));

        String[] tableTitle2 = {"Matières", "Total séances"};
        String[][] mt2 = new String[myTot.length][tableTitle2.length];
        for(int i = 0 ; i < myTot.length; i++){
            for (int j = 0; j < tableTitle2.length; j++) {
                if (i==0){
                    mt2[i][1] = String.valueOf(myTot[i]*1.5)+"h";
                    mt2[i][0] = "Mathématiques";}
                if(i==1){
                    mt2[i][1] = String.valueOf(myTot[i]*1.5)+"h";
                    mt2[i][0] = "Informatique";}
                if(i==2){
                    mt2[i][1] = String.valueOf(myTot[i]*1.5)+"h";
                    mt2[i][0] = "Physique";}
                }
            }

        table1 = new JTable(mt2, tableTitle2);







        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("Vue Globale");
            label1.setBackground(Color.white);
            label1.setForeground(Color.black);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 12f));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setBorder(new BevelBorder(BevelBorder.LOWERED));
            panel1.add(label1);
            label1.setBounds(440, 10, 330, 66);

            //======== Sites ========
            {
                Sites.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                Sites.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 375, 90);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Sites.getComponentCount(); i++) {
                        Rectangle bounds = Sites.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Sites.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Sites.setMinimumSize(preferredSize);
                    Sites.setPreferredSize(preferredSize);
                }
            }
            panel1.add(Sites);
            Sites.setBounds(15, 200, 370, 90);

            //---- label2 ----
            label2.setText("Mes cours");
            label2.setForeground(Color.black);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 7f));
            panel1.add(label2);
            label2.setBounds(10, 155, 140, 31);

            //======== MyGroup ========
            {
                MyGroup.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(userTab);
                }
                MyGroup.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 570, 300);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < MyGroup.getComponentCount(); i++) {
                        Rectangle bounds = MyGroup.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = MyGroup.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    MyGroup.setMinimumSize(preferredSize);
                    MyGroup.setPreferredSize(preferredSize);
                }
            }
            panel1.add(MyGroup);
            MyGroup.setBounds(15, 380, 570, 300);

            //---- label3 ----
            label3.setText("Mon groupe");
            label3.setForeground(Color.black);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 7f));
            panel1.add(label3);
            label3.setBounds(5, 335, 160, 31);

            //======== panel2 ========
            {
                panel2.setLayout(null);

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
            panel2.setBounds(830, 190, 300, 340);

            //---- Background ----
            Background.setText(" ");
            Background.setIcon(new ImageIcon(getClass().getResource("/view/Ressource/Mt. Fuji.jpg")));
            Background.setBorder(UIManager.getBorder("MenuBar.border"));
            panel1.add(Background);
            Background.setBounds(0, 0, 1200, 745);

            panel1.setPreferredSize(new Dimension(1200, 800));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - biollay
    public JPanel panel1;
    private JLabel label1;
    public JPanel Sites;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    public JPanel MyGroup;
    private JScrollPane scrollPane2;
    private JTable userTab;
    private JLabel label3;
    public JPanel panel2;
    private JLabel Background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
