package Project;

import java.util.ArrayList;

public class Prescription {

    int ID;
    int patientID;
    String Date;
    String drugName;
    String drugType;
    String drugDuration;
    String drugAdvice;
    static int nbofPrescription = 0;
    static ArrayList<Prescription> ids = new ArrayList<Prescription>();

    public Prescription(int ID, int patientID, String Date, String drugName, String drugType, String drugDuration, String drugAdvice) {
        this.ID = ID;
        this.patientID = patientID;
        this.Date = Date;
        this.drugName = drugName;
        this.drugType = drugType;
        this.drugDuration = drugDuration;
        this.drugAdvice = drugAdvice;
        ids.add(this);
        for (int i = 0; i < Patient.nbofpatients; i++) {
            if (patientID == i) {
                Patient.patient_list.get(i).prescription_list.add(this);
            }
        }
    }

    public String showPrescription(int ID) {
        return ("Drug Name: " + ids.get(ID).drugName + ", Type: " + ids.get(ID).drugType + ", date: " + ids.get(ID).Date + ", Advice: " + ids.get(ID).drugAdvice + ", duration" + ids.get(ID).drugDuration);
    }
}
