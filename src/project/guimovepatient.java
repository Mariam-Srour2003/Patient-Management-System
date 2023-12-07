package Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guimovepatient extends JFrame {

    JLabel NameofClinicwithp, Nameofcilinicmovedto, patientname;
    JTextField Clinicnamewithp, nbofpatientsmo, pname;

    public guimovepatient() {
        NameofClinicwithp = new JLabel("Move patient from:");
        Nameofcilinicmovedto = new JLabel("Move patient to:");
        patientname = new JLabel("Patient name:");

        Clinicnamewithp = new JTextField("clinic name", 2);
        nbofpatientsmo = new JTextField("clinic name", 2);
        pname = new JTextField("patiet name", 2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");

        JPanel p1 = new JPanel(new GridLayout(4, 2, 3, 3));
        p1.add(NameofClinicwithp);
        p1.add(Clinicnamewithp);
        p1.add(Nameofcilinicmovedto);
        p1.add(nbofpatientsmo);
        p1.add(patientname);
        p1.add(pname);
        p1.add(back);
        p1.add(Done);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        NameofClinicwithp.setForeground(new Color(0, 160, 160));
        Nameofcilinicmovedto.setForeground(new Color(0, 160, 180));
        patientname.setForeground(new Color(10, 160, 180));

        Clinicnamewithp.setBackground(new Color(225, 230, 230));
        nbofpatientsmo.setBackground(new Color(225, 230, 230));
        pname.setBackground(new Color(225, 230, 230));
        Clinicnamewithp.setForeground(new Color(0, 160, 160));
        nbofpatientsmo.setForeground(new Color(10, 160, 180));
        pname.setForeground(new Color(10, 180, 160));

        back.setBackground(new Color(0, 160, 180));
        back.setForeground(Color.white);
        Done.setBackground(new Color(0, 180, 160));
        Done.setForeground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("move patient");
        setSize(400, 200);
        setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIthird f = new GUIthird();
                dispose();
            }
        });
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String PName = pname.getText();
                String oldc = Clinicnamewithp.getText();
                String newc = nbofpatientsmo.getText();
                for (int i = 0; i < (Clinic.clinic_list).size(); i++) {
                    if ((((Clinic.clinic_list).get(i)).name).equals(oldc)) {
                        for (int l = 0; l < (Clinic.clinic_list).size(); l++) {
                            if ((((Clinic.clinic_list).get(l)).name).equals(newc)) {
                                for (int k = 0; k < (((Clinic.clinic_list).get(i)).listOfPatients).size(); k++) {
                                    if ((((((Clinic.clinic_list).get(i)).listOfPatients).get(k)).name).equals(PName)) {
                                        ((Clinic.clinic_list).get(i)).move_patient((((Clinic.clinic_list).get(i)).listOfPatients).get(k), ((Clinic.clinic_list).get(l)));
                                    }
                                }
                            } else {
                                System.out.println("clinic you want to move patient to doesn't exist");
                            }
                        }
                    } else {
                        System.out.println("clinic you want to move patient from doesn't exist");
                    }
                }
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });
    }

}
