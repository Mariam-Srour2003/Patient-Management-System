package Project;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIfourth extends JFrame {

    JLabel page, prescInfo;
    JButton add, info, back;
    JTextField presc;

    public GUIfourth() {
        Font f = new Font("", 15, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        final JPanel p4 = new JPanel(new FlowLayout());
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        add = new JButton("Add Prescription");
        back = new JButton("Back");
        info = new JButton("Show Prescription");
        page = new JLabel("Prescription", JLabel.CENTER);
        prescInfo = new JLabel("");
        presc = new JTextField("  ID of prescription", 10);

        page.setFont(f);

        add.setBackground(new Color(0, 180, 160));
        presc.setBackground(new Color(225, 230, 230));
        back.setBackground(new Color(0, 160, 180));
        info.setBackground(new Color(20, 160, 160));
        prescInfo.setBackground(new Color(20, 160, 160));

        page.setForeground(new Color(20, 160, 160));
        add.setForeground(Color.white);
        presc.setForeground(new Color(0, 160, 160));
        back.setForeground(Color.white);
        info.setForeground(Color.white);
        prescInfo.setForeground(new Color(0, 160, 160));

        p1.add(page);
        p2.add(add);
        p3.add(info);
        p3.add(presc);
        p5.add(back);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
        cp.add(p5);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddPrescription f = new guiAddPrescription();
                dispose();
            }
        });
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                p4.add(prescInfo);
                int c = 0;
                for (int i = 0; i < (Prescription.ids).size(); i++) {
                    if (((Prescription.ids).get(i)).ID == Integer.parseInt(presc.getText())) {
                        prescInfo.setText(Prescription.ids.get(i).toString());
                        c++;
                    }
                }
                if (c == 0) {
                    prescInfo.setText("Prescription not found!");
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });

        setTitle("Patient Management System");
        setSize(400, 300);
        setVisible(true);
    }
}
