package Project;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIfirst extends JFrame {

    JLabel image;
    JButton patient, clinic, prescription, save;
    ImageIcon i;

    public GUIfirst() {
        Font f = new Font("", 10, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 1));
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        patient = new JButton("Patient");
        clinic = new JButton("Clinic");
        prescription = new JButton("Prescription");
        save = new JButton("Save Data");
        try {
            ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("image.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            image = new JLabel(img);
            p2.add(image);
        } catch (Exception e) {
            System.out.println("Image not found");
        }
        p3.add(patient);
        p3.add(clinic);
        p3.add(prescription);
        p3.add(save);
        cp.add(p2);
        cp.add(p3);

        patient.setBackground(new Color(0, 180, 160));
        prescription.setBackground(new Color(0, 160, 180));
        clinic.setBackground(new Color(0, 160, 160));
        save.setBackground(new Color(0, 180, 180));
        patient.setForeground(Color.WHITE);
        clinic.setForeground(Color.WHITE);
        prescription.setForeground(Color.WHITE);
        save.setForeground(Color.WHITE);

        patient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIsec f = new GUIsec();
                dispose();
            }
        });
        prescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIfourth f = new GUIfourth();
                dispose();
            }
        });
        clinic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIthird f = new GUIthird();
                dispose();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                output o = new output();
            }
        });

        pack();
        setTitle("Wecome to the Patient Management System");
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUIfirst();
    }
}
