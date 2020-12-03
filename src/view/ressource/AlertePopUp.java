package view.ressource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AlertePopUp {
    public AlertePopUp() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        AddFailId.dispose();
        // exit
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - biollay
        AddFailId = new JDialog();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        button1 = new JButton();
        label12 = new JLabel();
        DeleteFail = new JDialog();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        button2 = new JButton();

        //======== AddFailId ========
        {
            var AddFailIdContentPane = AddFailId.getContentPane();
            AddFailIdContentPane.setLayout(null);

            //---- label6 ----
            label6.setText("Please try again");
            AddFailIdContentPane.add(label6);
            label6.setBounds(20, 170, 160, 30);

            //---- label7 ----
            label7.setText("Add Fail !");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 3f));
            label7.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
            AddFailIdContentPane.add(label7);
            label7.setBounds(25, 5, 215, 65);

            //---- label8 ----
            label8.setText("Error id already exists ");
            AddFailIdContentPane.add(label8);
            label8.setBounds(5, 80, 140, 46);

            //---- button1 ----
            button1.setText("Ok");
            button1.addActionListener(e -> button1ActionPerformed(e));
            AddFailIdContentPane.add(button1);
            button1.setBounds(220, 165, 70, 30);

            //---- label12 ----
            label12.setText("or textfield is empty");
            AddFailIdContentPane.add(label12);
            label12.setBounds(150, 80, 130, 46);

            AddFailIdContentPane.setPreferredSize(new Dimension(310, 235));
            AddFailId.setSize(310, 235);
            AddFailId.setLocationRelativeTo(AddFailId.getOwner());
        }

        //======== DeleteFail ========
        {
            var DeleteFailContentPane = DeleteFail.getContentPane();
            DeleteFailContentPane.setLayout(null);

            //---- label9 ----
            label9.setText("Please try again");
            DeleteFailContentPane.add(label9);
            label9.setBounds(20, 110, 160, 30);

            //---- label10 ----
            label10.setText("Delete Fail !");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 3f));
            label10.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
            DeleteFailContentPane.add(label10);
            label10.setBounds(25, 5, 215, 65);

            //---- label11 ----
            label11.setText("Error id doesn't exists");
            DeleteFailContentPane.add(label11);
            label11.setBounds(20, 80, 180, 31);

            //---- button2 ----
            button2.setText("Ok");
            button2.addActionListener(e -> button1ActionPerformed(e));
            DeleteFailContentPane.add(button2);
            button2.setBounds(190, 140, 70, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < DeleteFailContentPane.getComponentCount(); i++) {
                    Rectangle bounds = DeleteFailContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = DeleteFailContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                DeleteFailContentPane.setMinimumSize(preferredSize);
                DeleteFailContentPane.setPreferredSize(preferredSize);
            }
            DeleteFail.pack();
            DeleteFail.setLocationRelativeTo(DeleteFail.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - biollay
    public JDialog AddFailId;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton button1;
    private JLabel label12;
    public JDialog DeleteFail;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables



}
