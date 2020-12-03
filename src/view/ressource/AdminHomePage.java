package view.ressource;

import controller.ControllerAdmin;
import controller.ControllerConnection;
import model.Site;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/*// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - biollay
        panel1 = new JPanel();
        label1 = new JLabel();
        Sites = new JPanel();
        scrollPane1 = new JScrollPane();
        //table1 = new JTable();
        label2 = new JLabel();
        Members = new JPanel();
        scrollPane2 = new JScrollPane();
        //userTab = new JTable();
        label3 = new JLabel();
        chart = new JPanel();
        Background = new JLabel();
        createUIComponents();

        ArrayList<ArrayList<String>> users = controllerAdmin.getAllUser();
        String[] tableTitle = {"ID", "Nom", "Prenom", "Email", "Permission"};
        String[][] mt = new String[users.size()][tableTitle.length];
        for(int i = 0 ; i < users.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = users.get(i).get(j);
            }
        }
        userTab = new JTable(mt, tableTitle);


        ArrayList<Site> sites = controllerAdmin.getAllSite();
        String[] table2Title = {"ID Site", "Name Site"};

        String[][] mt2 = new String[sites.size()][table2Title.length];
        for(int i = 0 ; i < sites.size(); i++){
            mt2[i][0] = sites.get(i).getIdSite();
            mt2[i][1] = sites.get(i).getNameSite();
        }
        table1 = new JTable(mt2, table2Title);
*/
 

public class AdminHomePage {
    
    public ControllerConnection controllerConnection;
    public ControllerAdmin controllerAdmin;

    public AdminHomePage(ControllerConnection controllerConnection, ControllerAdmin controllerAdmin) throws SQLException, ClassNotFoundException {
        this.controllerConnection = controllerConnection;
        this.controllerAdmin = controllerAdmin;
        initComponents();
    }

    /**
     * Création des composants personnalisés, ici ChartPanel pour afficher un diagramme circulaire
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    private void createUIComponents() throws SQLException, ClassNotFoundException {
        ChartPanel chartPanel = controllerAdmin.getChartStudentByPromotion();
        chart.setLayout(null);
        chartPanel.setBounds(0, 0, 340, 265);
        chart.add(chartPanel);
    }

    /**
     * Initialisation des composants du modéle
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void initComponents() throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sami Quintana

        panel1 = new JPanel();
        label1 = new JLabel();
        Sites = new JPanel();
        scrollPane1 = new JScrollPane();
        //table1 = new JTable();
        label2 = new JLabel();
        Members = new JPanel();
        scrollPane2 = new JScrollPane();
        //userTab = new JTable();
        label3 = new JLabel();
        chart = new JPanel();
        Background = new JLabel();
        createUIComponents();

        ArrayList<ArrayList<String>> users = controllerAdmin.getAllUsers();
        String[] tableTitle = {"ID", "Nom", "Prenom", "Email", "Permission"};
        String[][] mt = new String[users.size()][tableTitle.length];
        for(int i = 0 ; i < users.size(); i++){
            for (int j = 0; j < tableTitle.length; j++) {
                mt[i][j] = users.get(i).get(j);
            }
        }
        userTab = new JTable(mt, tableTitle);


        ArrayList<Site> sites = controllerAdmin.getAllSites();
        String[] table2Title = {"ID Site", "Name Site"};

        String[][] mt2 = new String[sites.size()][table2Title.length];
        for(int i = 0 ; i < sites.size(); i++){
            mt2[i][0] = sites.get(i).getIdSite();
            mt2[i][1] = sites.get(i).getNameSite();
        }
        table1 = new JTable(mt2, table2Title);

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) )
            ; panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
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
            label2.setText("Les sites");
            label2.setForeground(Color.black);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() & ~Font.BOLD, label2.getFont().getSize() + 7f));
            panel1.add(label2);
            label2.setBounds(15, 165, 115, 31);

            //======== Members ========
            {
                Members.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(userTab);
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
            Members.setBounds(15, 380, 570, 300);

            //---- label3 ----
            label3.setText("Membres");
            label3.setForeground(Color.black);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() & ~Font.BOLD, label3.getFont().getSize() + 7f));
            panel1.add(label3);
            label3.setBounds(15, 345, 160, 31);

            //======== chart ========
            {
                chart.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < chart.getComponentCount(); i++) {
                        Rectangle bounds = chart.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = chart.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    chart.setMinimumSize(preferredSize);
                    chart.setPreferredSize(preferredSize);
                }
            }
            panel1.add(chart);
            chart.setBounds(810, 300, 340, 265);

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
    // Generated using JFormDesigner Evaluation license - Sami Quintana
    public JPanel panel1;
    private JLabel label1;
    public JPanel Sites;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    public JPanel Members;
    private JScrollPane scrollPane2;
    private JTable userTab;
    private JLabel label3;
    public JPanel chart;
    private JLabel Background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
    
    
}
