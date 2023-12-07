package Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Patient {

    static int nbofpatients = 0;
    String name;
    int ID;
    String PhoneNumber;
    String Address;
    Date DateOfBirth;
    int sex;//0 for female and 1 for male
    String Doctor;
    String medicalCondition;
    ArrayList<Prescription> prescription_list = new ArrayList<Prescription>();
    LocalDateTime appointement;
    static ArrayList<Patient> patient_list = new ArrayList<Patient>();

    public Patient(String name, String PhoneNumber, String Address, Date DateOfBirth, int sex, String Doctor, String medicalCondition, LocalDateTime appointement) {
        nbofpatients++;
        this.ID = nbofpatients;
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
        this.sex = sex;
        this.Doctor = Doctor;
        this.medicalCondition = medicalCondition;
        this.appointement = appointement;
        patient_list.add(this);
    }

    @Override
    public String toString() {
        String x;
        if (this.sex == 0) {
            x = "female";
        } else {
            x = "male";
        }
        return "Patient name: " + name + ", ID: " + ID + ", PhoneNumber: " + PhoneNumber + ", Address: " + Address + ", DateOfBirth: " + DateOfBirth + "sex: " + x + ", Doctor: " + Doctor + ", medicalCondition: " + medicalCondition + ", appointement: " + appointement;
    }

    public void add_prescription(Prescription P) {
        prescription_list.add(P);
        System.out.println("prescription added");
    }
}
