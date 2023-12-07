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

public class guiAddClinic extends JFrame {

    String Name;
    int maxnbofpatients;

    JLabel NameClinic, MaxNumberOfPatients;
    JTextField Clinicname, nbofpatients;

    public guiAddClinic() {

        NameClinic = new JLabel("Clinic Name");
        MaxNumberOfPatients = new JLabel("Max Number Of Patients");

        Clinicname = new JTextField(2);
        nbofpatients = new JTextField(2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");

        JPanel p1 = new JPanel(new GridLayout(4, 2, 3, 3));
        p1.add(NameClinic);
        p1.add(Clinicname);
        p1.add(MaxNumberOfPatients);
        p1.add(nbofpatients);
        p1.add(back);
        p1.add(Done);

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(0, 160, 160));
        nbofpatients.setBackground(new Color(225, 230, 230));
        Clinicname.setBackground(new Color(225, 230, 230));

        NameClinic.setForeground(new Color(20, 160, 160));
        MaxNumberOfPatients.setForeground(new Color(0, 160, 160));
        Clinicname.setForeground(new Color(0, 160, 160));
        back.setForeground(Color.white);
        nbofpatients.setForeground(new Color(0, 160, 160));

        Done.setForeground(Color.white);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Clinic");
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
                Name = Clinicname.getText();
                String NumberOfPatients = nbofpatients.getText();
                maxnbofpatients = Integer.parseInt(NumberOfPatients);
                Clinic c = new Clinic(Name, maxnbofpatients);
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });
    }

}
