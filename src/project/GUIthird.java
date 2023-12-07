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

public class GUIthird extends JFrame {

    JLabel page;
    JButton addP, addC, remove, back, move, pList, p_m_c, history;

    public GUIthird() {
        Font f = new Font("", 15, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout());
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        addP = new JButton("Add Patient");
        move = new JButton("Move Patient");
        p_m_c = new JButton("Patient List by Medical Condition");
        pList = new JButton("Patient List");
        addC = new JButton("Add Clinic");
        back = new JButton("Back");
        remove = new JButton("Remove Patient");
        history = new JButton("Patient History");
        page = new JLabel("Clinic", JLabel.CENTER);

        page.setFont(f);

        addP.setBackground(new Color(20, 160, 160));
        addC.setBackground(new Color(0, 180, 160));
        back.setBackground(new Color(0, 160, 180));
        history.setBackground(new Color(0, 160, 160));
        p_m_c.setBackground(new Color(20, 160, 160));
        move.setBackground(new Color(0, 180, 160));
        pList.setBackground(new Color(10, 180, 160));
        remove.setBackground(new Color(10, 180, 180));

        page.setForeground(new Color(20, 160, 160));
        addP.setForeground(Color.white);
        addC.setForeground(Color.white);
        back.setForeground(Color.white);
        move.setForeground(Color.white);
        p_m_c.setForeground(Color.white);
        pList.setForeground(Color.white);
        remove.setForeground(Color.white);
        history.setForeground(Color.white);

        p1.add(page);
        p2.add(addC);
        p2.add(pList);
        p3.add(addP);
        p3.add(remove);
        p3.add(history);
        p4.add(move);
        p4.add(p_m_c);
        p5.add(back);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
        cp.add(p5);
        addC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddClinic f = new guiAddClinic();
                dispose();
            }
        });
        pList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiPatientList f = new guiPatientList();
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });
        addP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addPatienttoClinic p = new addPatienttoClinic();
                dispose();
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                removePatientFromClinic p = new removePatientFromClinic();
                dispose();
            }
        });
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiPatientHistory p = new guiPatientHistory();
                dispose();
            }
        });
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guimovepatient f = new guimovepatient();
                dispose();
            }
        });
        p_m_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guigetlistofpatientsbymedicalcondition f = new guigetlistofpatientsbymedicalcondition();
                dispose();
            }
        });

        setTitle("Patient Management System");
        setSize(400, 300);
        setVisible(true);
    }

}
