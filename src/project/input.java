package Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class input {

    public input() {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream("PatientManagementSystem.dat"));
            for (int i = 0; i < Patient.patient_list.size(); i++) {
                System.out.println(Patient.patient_list.get(i));
            }
            for (int i = 0; i < Prescription.ids.size(); i++) {
                System.out.println(Prescription.ids.get(i));
            }
            for (int i = 0; i < Clinic.clinic_list.size(); i++) {
                System.out.println(Clinic.clinic_list.get(i));
            }
            in.close();
        } catch (IOException ex) {
        }
    }
}
