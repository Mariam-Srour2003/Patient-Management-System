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

public class GUIsec extends JFrame {

    JLabel page, patientL;
    JButton add, Addpresc, info, back;
    JTextField patient, idpresc;

    public GUIsec() {

        Font f = new Font("", 15, 20);

        final Container cp2 = getContentPane();
        cp2.setLayout(new GridLayout(6, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout());
        final JPanel p5 = new JPanel(new FlowLayout());
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cp2.setBackground(new Color(225, 230, 230));
        add = new JButton("Add a patient");
        Addpresc = new JButton("Add prescription");
        back = new JButton("Back");
        info = new JButton("Patient Information");
        page = new JLabel("Patient", JLabel.CENTER);
        patientL = new JLabel();
        patient = new JTextField("name of patient", 15);
        idpresc = new JTextField("prescription id", 15);

        page.setFont(f);

        add.setBackground(new Color(20, 160, 160));
        Addpresc.setBackground(new Color(0, 180, 160));
        back.setBackground(new Color(0, 160, 180));
        info.setBackground(new Color(0, 160, 160));
        patient.setBackground(new Color(225, 230, 230));

        page.setForeground(new Color(20, 160, 160));
        add.setForeground(Color.white);
        Addpresc.setForeground(Color.white);
        back.setForeground(Color.white);
        info.setForeground(Color.white);
        patient.setForeground(new Color(0, 160, 160));
        patientL.setForeground(new Color(20, 160, 160));

        p1.add(page);
        p2.add(add);
        p3.add(patient);
        p3.add(idpresc);
        p4.add(info);
        p4.add(Addpresc);
        p6.add(back);
        cp2.add(p1);
        cp2.add(p2);
        cp2.add(p3);
        cp2.add(p4);
        cp2.add(p5);
        cp2.add(p6);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddPatient f = new guiAddPatient();
                dispose();
            }
        });
        Addpresc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                p5.add(patientL);
                int c = 0;
                for (int i = 0; i < Patient.patient_list.size(); i++) {
                    if (Patient.patient_list.get(i).name.equals(patient.getText())) {
                        c++;
                        for (int j = 0; j < Prescription.ids.size(); j++) {
                            if (Prescription.ids.get(j).ID == Integer.parseInt(idpresc.getText())) {
                                c++;
                                Patient.patient_list.get(i).add_prescription(Prescription.ids.get(j));
                            }
                        }
                    }
                }
                if (c == 0) {
                    patientL.setText("Patient not found!");
                } else if (c == 1) {
                    patientL.setText("Prescription not found!");
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
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                p5.add(patientL);
                int c = 0;
                for (int i = 0; i < Patient.patient_list.size(); i++) {
                    if (Patient.patient_list.get(i).name.equals(patient.getText())) {
                        patientL.setText(Patient.patient_list.get(i).toString());
                        c++;
                    }
                }
                if (c == 0) {
                    patientL.setText("Patient not found!");
                }
            }
        });

        setTitle("Patient Management System");
        setSize(400, 300);
        setVisible(true);
    }

}
