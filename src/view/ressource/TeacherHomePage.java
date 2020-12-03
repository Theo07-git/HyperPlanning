package view.ressource;

import controller.ControllerTeacher;
import controller.ControllerConnection;
import model.Session;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class TeacherHomePage {
    public ControllerConnection controllerConnection;
    public ControllerTeacher controllerTeacher;
    public TeacherHomePage(ControllerConnection controllerConnection) throws SQLException, ClassNotFoundException {
        this.controllerConnection = controllerConnection;
        this.controllerTeacher = new ControllerTeacher(controllerConnection.getUser().getId());
        initComponents();
    }

    /**
     * Initialisation des composants du modéle
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void initComponents() throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - biollay
        panel1 = new JPanel();
        label1 = new JLabel();
        Members = new JPanel();
        scrollPane2 = new JScrollPane();
        TeacherTab = new JTable();
        label3 = new JLabel();
        Background = new JLabel();




        ArrayList<Session> sessionTeacher = controllerTeacher.getAllSession(controllerTeacher.getTeacher().getId());
        String[] tableTitle = {"Date", "Début","Fin","Type","Salle"};
        String[][] mt = new String[sessionTeacher.size()][tableTitle.length];
        for(int i = 0 ; i < sessionTeacher.size(); i++){
            mt[i][0] = String.valueOf(sessionTeacher.get(i).getDate());
            mt[i][1] = String.valueOf(sessionTeacher.get(i).getStartTime());
            mt[i][2] = String.valueOf(sessionTeacher.get(i).getEndTime());
            mt[i][3] = String.valueOf(sessionTeacher.get(i).getType());
            mt[i][4] = sessionTeacher.get(i).getRoom().getNameRoom();

        }
        TeacherTab = new JTable(mt, tableTitle);

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
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

            //======== Members ========
            {
                Members.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(TeacherTab);
                }
                Members.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 570, 300);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Members.getComponentCount(); i++) {
                        Rectangle bounds = Members.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Members.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Members.setMinimumSize(preferredSize);
                    Members.setPreferredSize(preferredSize);
                }
            }
            panel1.add(Members);
            Members.setBounds(305, 210, 570, 300);

            //---- label3 ----
            label3.setText("Mes prochains cours ");
            label3.setForeground(Color.black);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() & ~Font.BOLD, label3.getFont().getSize() + 7f));
            panel1.add(label3);
            label3.setBounds(310, 155, 255, 36);

            //---- Background ----
            Background.setText(" ");
            Background.setIcon(new ImageIcon(getClass().getResource("/view/ressource/Image/Mt. Fuji.jpg")));
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
    public JPanel Members;
    private JScrollPane scrollPane2;
    private JTable TeacherTab;
    private JLabel label3;
    private JLabel Background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
panel1 = new JPanel();
        label1 = new JLabel();
        Members = new JPanel();
        scrollPane2 = new JScrollPane();
        TeacherTab = new JTable();
        label3 = new JLabel();
        Background = new JLabel();




        ArrayList<Session> sessionTeacher = controllerTeacher.getAllSession(controllerTeacher.getTeacher().getId());
        String[] tableTitle = {"Date", "Début","Fin","Type","Salle"};
        String[][] mt = new String[sessionTeacher.size()][tableTitle.length];
        for(int i = 0 ; i < sessionTeacher.size(); i++){
                mt[i][0] = String.valueOf(sessionTeacher.get(i).getDate());
                mt[i][1] = String.valueOf(sessionTeacher.get(i).getStartTime());
                mt[i][2] = String.valueOf(sessionTeacher.get(i).getEndTime());
                mt[i][3] = String.valueOf(sessionTeacher.get(i).getType());
                mt[i][4] = sessionTeacher.get(i).getRoom().getNameRoom();

        }
        TeacherTab = new JTable(mt, tableTitle);
 */
