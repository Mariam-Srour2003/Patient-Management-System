package Project;

import java.util.ArrayList;
import java.util.Collections;

public class Clinic {

    String name;
    int MaximumNumberOfPatients;
    ArrayList<Patient> listOfPatients = new ArrayList<Patient>();
    static ArrayList<Clinic> clinic_list = new ArrayList<Clinic>();

    public Clinic(String name, int MaximumNumberOfPatients) {
        this.name = name;
        this.MaximumNumberOfPatients = MaximumNumberOfPatients;
        Collections.sort(listOfPatients, new sort());
        clinic_list.add(this);
    }

    public void add_patient(Patient p) {
        if (listOfPatients.size() <= this.MaximumNumberOfPatients) {
            if (listOfPatients.contains(p)) {
                System.out.println("Patient already exists!");
            } else {
                listOfPatients.add(p);
            }
        } else {
            System.out.println("The number of patients in this cinic shoud not exceed " + this.MaximumNumberOfPatients + " patients.");
        }
        Collections.sort(listOfPatients, new sort());
    }

    public void remove_patient(Patient p) {
        if (listOfPatients.contains(p)) {
            listOfPatients.remove(p);
        } else {
            System.out.println("Patient doesn't exist!");
        }
    }

    public void move_patient(Patient p, Clinic c) {
        if (listOfPatients.contains(p)) {
            listOfPatients.remove(p);
            c.listOfPatients.add(p);
        } else {
            System.out.println("Patient doesn't exist!");
        }
    }

    public ArrayList<Patient> get_list_of_patients() {
        return listOfPatients;
    }

    public ArrayList<Patient> get_list_of_patients_by_medical_condition(String s) {
        ArrayList<Patient> patientsbymedicalconditions = new ArrayList<Patient>();
        for (int i = 0; i < listOfPatients.size(); i++) {
            if ((listOfPatients.get(i).medicalCondition).equalsIgnoreCase(s)) {
                patientsbymedicalconditions.add(listOfPatients.get(i));
            }
        }
        return patientsbymedicalconditions;
    }

    public String get_patient_history(Patient p) {
        String x = (p.toString() + ",Clinic name: " + this.name);
        for (int i = 0; i < p.prescription_list.size(); i++) {
            x += ", " + ((p.prescription_list).get(i)).showPrescription(i);
        }
        return x;
    }
}
