package Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guigetlistofpatientsbymedicalcondition extends JFrame {

    JLabel NameofClinic, medicalcondition, list, listt;
    JTextField Clinicname, medcond;

    public guigetlistofpatientsbymedicalcondition() {
        NameofClinic = new JLabel("Name of clinic:");
        medicalcondition = new JLabel("Medical condition:");
        list = new JLabel("list: ");
        listt = new JLabel();

        Clinicname = new JTextField(2);
        medcond = new JTextField(2);

        JButton ok = new JButton("OK");
        JButton back = new JButton("BACK");

        JPanel p1 = new JPanel(new GridLayout(4, 2, 3, 3));
        p1.add(NameofClinic);
        p1.add(Clinicname);
        p1.add(medicalcondition);
        p1.add(medcond);
        p1.add(list);
        p1.add(listt);
        p1.add(back);
        p1.add(ok);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        NameofClinic.setForeground(new Color(0, 160, 160));
        medicalcondition.setForeground(new Color(0, 160, 180));
        list.setForeground(new Color(10, 160, 180));
        listt.setForeground(new Color(10, 180, 180));

        Clinicname.setBackground(new Color(225, 230, 230));
        medcond.setBackground(new Color(225, 230, 230));
        Clinicname.setForeground(new Color(0, 160, 160));
        medcond.setForeground(new Color(20, 160, 180));

        back.setBackground(new Color(0, 160, 180));
        back.setForeground(Color.white);
        ok.setBackground(new Color(0, 180, 160));
        ok.setForeground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("get list of patients by medical condition");
        setSize(400, 200);
        setVisible(true);
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
                ArrayList<Patient> listb = new ArrayList<Patient>();
                String cname = Clinicname.getText();
                String mc = medcond.getText();
                String soflist = "";
                for (int i = 0; i < (Clinic.clinic_list).size(); i++) {
                    if ((((Clinic.clinic_list).get(i)).name).equals(cname)) {
                        listb = ((Clinic.clinic_list).get(i)).get_list_of_patients_by_medical_condition(mc);
                    }
                }
                for (int i = 0; i < listb.size(); i++) {
                    soflist += (listb.get(i)).name + ", ";
                }
                listt.setText(soflist);
            }
        });
    }

}
