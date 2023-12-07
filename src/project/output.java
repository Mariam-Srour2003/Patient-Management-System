package Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class output {

    public output() {
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("PatientManagementSystem.dat"));
            for (int i = 0; i < Patient.patient_list.size(); i++) {
                out.writeObject(Patient.patient_list.get(i));
            }
            for (int i = 0; i < Prescription.ids.size(); i++) {
                out.writeObject(Prescription.ids.get(i));
            }
            for (int i = 0; i < Clinic.clinic_list.size(); i++) {
                out.writeObject(Clinic.clinic_list.get(i));
            }
            out.close();
        } catch (IOException ex) {
        }
    }
}
