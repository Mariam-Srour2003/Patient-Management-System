package Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class guiAddPatient extends JFrame {

    String Name;
    String phonenb;
    String addr;
    Date dob;
    int sex;
    String drname;
    String medcond;
    LocalDateTime appdate;
    JLabel NamePatient, PhoneNumber, Address, DateOfBirth, DoctorName, MedicalCondition, AppointmentDate, nothing;
    JTextField Patientname, Phonenumber, address, Dateofbirth, Doctorname, Medicalcondition, Appointmentdate;
    JRadioButton jRadioButtonf;
    JRadioButton jRadioButtonm;

    public guiAddPatient() {

        NamePatient = new JLabel("Patient Name");
        PhoneNumber = new JLabel("Phone Number");
        Address = new JLabel("Address");
        DateOfBirth = new JLabel("Date Of Birth");
        DoctorName = new JLabel("Doctor Name");
        MedicalCondition = new JLabel("Medical Condition");
        AppointmentDate = new JLabel("Appointment Date");
        nothing = new JLabel("");

        Patientname = new JTextField(2);
        Phonenumber = new JTextField(2);
        address = new JTextField(2);
        Dateofbirth = new JTextField("dd/MM/yyyy", 2);
        Doctorname = new JTextField(2);
        Medicalcondition = new JTextField(2);
        Appointmentdate = new JTextField("yyyy,MM,dd,HH,mm", 2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");
        jRadioButtonf = new JRadioButton("female");
        jRadioButtonm = new JRadioButton("male");
        JPanel p1 = new JPanel(new GridLayout(9, 2, 3, 3));
        p1.add(NamePatient);
        p1.add(Patientname);
        p1.add(PhoneNumber);
        p1.add(Phonenumber);
        p1.add(Address);
        p1.add(address);
        p1.add(DateOfBirth);
        p1.add(Dateofbirth);
        p1.add(DoctorName);
        p1.add(Doctorname);
        p1.add(MedicalCondition);
        p1.add(Medicalcondition);
        p1.add(AppointmentDate);
        p1.add(Appointmentdate);
        p1.add(jRadioButtonf);
        p1.add(jRadioButtonm);
        p1.add(back);
        p1.add(Done);

        NamePatient.setForeground(new Color(20, 160, 180));
        PhoneNumber.setForeground(new Color(0, 160, 160));
        Address.setForeground(new Color(0, 160, 180));
        DateOfBirth.setForeground(new Color(10, 160, 160));
        DoctorName.setForeground(new Color(0, 160, 160));
        MedicalCondition.setForeground(new Color(0, 160, 160));
        AppointmentDate.setForeground(new Color(10, 170, 190));
        nothing.setForeground(new Color(0, 180, 150));

        back.setForeground(Color.white);
        Done.setForeground(Color.white);

        Patientname.setForeground(new Color(20, 160, 180));
        Phonenumber.setForeground(new Color(0, 160, 160));
        address.setForeground(new Color(0, 160, 180));
        Dateofbirth.setForeground(new Color(0, 160, 180));
        Doctorname.setForeground(new Color(10, 160, 160));
        Medicalcondition.setForeground(new Color(0, 160, 160));
        Appointmentdate.setForeground(new Color(0, 160, 160));
        jRadioButtonf.setForeground(new Color(10, 170, 190));
        jRadioButtonm.setForeground(new Color(0, 180, 150));

        Patientname.setBackground(new Color(225, 230, 230));
        Phonenumber.setBackground(new Color(225, 230, 230));
        address.setBackground(new Color(225, 230, 230));
        Dateofbirth.setBackground(new Color(225, 230, 230));
        Doctorname.setBackground(new Color(225, 230, 230));
        Medicalcondition.setBackground(new Color(225, 230, 230));
        Appointmentdate.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(0, 180, 160));

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Patient ");
        setSize(400, 400);
        setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIsec f = new GUIsec();
                dispose();
            }
        });

        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Name = Patientname.getText();
                phonenb = Phonenumber.getText();
                addr = address.getText();
                String dat = Dateofbirth.getText();
                try {
                    dob = new SimpleDateFormat("dd/MM/yyyy").parse(dat);
                } catch (ParseException ex) {
                    System.out.println("Erorr in date!!!!");
                }
                if (jRadioButtonf.isSelected()) {

                    sex = 0;
                } else if (jRadioButtonm.isSelected()) {

                    sex = 1;
                }
                drname = Doctorname.getText();
                medcond = Medicalcondition.getText();
                String appodate = Appointmentdate.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");
                appdate = LocalDateTime.parse(appodate, formatter);
                Patient p = new Patient(Name, phonenb, addr, dob, sex, drname, medcond, appdate);
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });
    }
}
