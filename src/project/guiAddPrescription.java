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

public class guiAddPrescription extends JFrame {

    int IDd;
    int patientId;
    String Dat;
    String dName;
    String dType;
    String dDuration;
    String dAdvice;

    JLabel ID, patientID, Date, drugName, drugType, drugDuration, drugAdvice;
    JTextField id, patientid, date, drugname, drugtype, drugduration, drugadvice;

    public guiAddPrescription() {

        ID = new JLabel("Prescription ID");
        patientID = new JLabel("Paitient ID");
        Date = new JLabel("Date");
        drugName = new JLabel("Drug name");
        drugType = new JLabel("Drug Type");
        drugDuration = new JLabel("Drug Duration");
        drugAdvice = new JLabel("Drug Advice");

        id = new JTextField(2);
        patientid = new JTextField(2);
        date = new JTextField(2);
        drugname = new JTextField(2);
        drugtype = new JTextField(2);
        drugduration = new JTextField(2);
        drugadvice = new JTextField(2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");

        ID.setForeground(new Color(0, 160, 160));
        patientID.setForeground(new Color(0, 160, 180));
        Date.setForeground(new Color(10, 160, 180));
        drugName.setForeground(new Color(10, 180, 180));
        drugType.setForeground(new Color(10, 180, 160));
        drugDuration.setForeground(new Color(0, 180, 160));
        drugAdvice.setForeground(new Color(0, 160, 160));

        id.setForeground(new Color(0, 160, 160));
        patientid.setForeground(new Color(0, 160, 180));
        date.setForeground(new Color(10, 160, 180));
        drugname.setForeground(new Color(10, 180, 180));
        drugtype.setForeground(new Color(10, 180, 160));
        drugduration.setForeground(new Color(0, 180, 160));
        drugadvice.setForeground(new Color(0, 160, 160));

        id.setBackground(new Color(225, 230, 230));
        patientid.setBackground(new Color(225, 230, 230));
        date.setBackground(new Color(225, 230, 230));
        drugname.setBackground(new Color(225, 230, 230));
        drugtype.setBackground(new Color(225, 230, 230));
        drugduration.setBackground(new Color(225, 230, 230));
        drugadvice.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(0, 180, 160));

        back.setForeground(Color.white);
        Done.setForeground(Color.white);

        JPanel p1 = new JPanel(new GridLayout(9, 2, 3, 3));
        p1.add(ID);
        p1.add(id);
        p1.add(patientID);
        p1.add(patientid);
        p1.add(Date);
        p1.add(date);
        p1.add(drugName);
        p1.add(drugname);
        p1.add(drugType);
        p1.add(drugtype);
        p1.add(drugDuration);
        p1.add(drugduration);
        p1.add(drugAdvice);
        p1.add(drugadvice);
        p1.add(back);
        p1.add(Done);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Prescription");
        setSize(400, 300);
        setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIfourth f = new GUIfourth();
                dispose();
            }
        });
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sid = id.getText();
                IDd = Integer.parseInt(sid);
                String pid = patientid.getText();
                patientId = Integer.parseInt(pid);
                Dat = date.getText();
                dName = drugname.getText();
                dType = drugtype.getText();
                dDuration = drugduration.getText();
                dAdvice = drugadvice.getText();
                Prescription p = new Prescription(IDd, patientId, Dat, dName, dType, dDuration, dAdvice);
                GUIfirst f = new GUIfirst();
                dispose();
            }
        });
    }
}
