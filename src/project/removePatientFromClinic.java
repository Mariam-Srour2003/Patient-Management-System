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

public class removePatientFromClinic extends JFrame {

    JLabel title, Cname, Pname, result;
    JTextField CnameTF, PnameTF;
    JButton back, ok;

    public removePatientFromClinic() {
        Font f = new Font("", 10, 16);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        title = new JLabel("Remove a Patient from a Clinic");
        Cname = new JLabel("Write the name of the Clinic");
        Pname = new JLabel("Write the name of the Patient");
        result = new JLabel("");
        result.setVisible(false);
        CnameTF = new JTextField(10);
        PnameTF = new JTextField(10);
        ok = new JButton("OK");
        back = new JButton("Back");

        title.setFont(f);

        title.setForeground(new Color(0, 160, 160));
        Cname.setForeground(new Color(0, 160, 180));
        Pname.setForeground(new Color(10, 160, 180));
        result.setForeground(new Color(10, 180, 180));

        CnameTF.setForeground(new Color(0, 160, 160));
        PnameTF.setForeground(new Color(0, 160, 180));
        CnameTF.setBackground(new Color(225, 230, 230));
        PnameTF.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        ok.setBackground(new Color(0, 180, 160));
        back.setForeground(Color.white);
        ok.setForeground(Color.white);

        p1.add(title);
        p2.add(Cname);
        p2.add(CnameTF);
        p3.add(Pname);
        p3.add(PnameTF);
        p3.add(ok);
        p4.add(back);
        p4.add(result);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIthird f = new GUIthird();
                dispose();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int x = 0;
                result.setVisible(true);
                for (int i = 0; i < Clinic.clinic_list.size(); i++) {
                    if (CnameTF.getText().equals(Clinic.clinic_list.get(i).name)) {
                        x = 1;
                        for (int j = 0; j < Patient.patient_list.size(); j++) {
                            if (Patient.patient_list.get(j).name.equals(PnameTF.getText())) {
                                x = 2;
                                Clinic.clinic_list.get(i).remove_patient(Patient.patient_list.get(j));
                                result.setText("       Patient removed successfully");
                            }
                        }
                    }
                }
                if (x == 0) {
                    result.setText("             Clinic not found!");
                }
                if (x == 1) {
                    result.setText("             Patient not found!");
                }
            }
        });
        setTitle("Patient Management System");
        setSize(400, 200);
        setVisible(true);
    }
}
