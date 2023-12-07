package Project;

import java.time.LocalDateTime;
import java.util.Date;

public class Project {

    public static void main(String[] args) {
        System.out.println("WELCOME");
        Clinic c1 = new Clinic("Clinic One", 5);
        Clinic c2 = new Clinic("Clinic Two", 7);
        Clinic c3 = new Clinic("Clinic Three", 7);

        Patient p1 = new Patient("Mariam", "77777777", "m's address", new Date(2003, 8, 19), 0, "Aya", "m's medical condition", LocalDateTime.of(2020, 5, 9, 8, 50));
        Patient p2 = new Patient("Sara", "99555666", "s's address", new Date(2001, 2, 20), 0, "sam", "s's medical condition", LocalDateTime.of(2009, 4, 17, 11, 30));
        Patient p3 = new Patient("zahraa", "90909090", "z's address", new Date(1999, 3, 8), 0, "alaa", "z's medical condition", LocalDateTime.of(2019, 4, 5, 3, 10));

        Prescription pr1 = new Prescription(3, 1, "2019,5,28", "drug1", "drugtype1", "duration of d1", "advice of d1");
        Prescription pr2 = new Prescription(2, 3, "2000,11,8", "drug2", "drugtype2", "duration of d2", "advice of d2");

        c1.add_patient(p3);
        c1.add_patient(p2);
        c1.add_patient(p1);
        System.out.println(c1.get_list_of_patients());
        c1.remove_patient(p3);
        System.out.println(c1.get_list_of_patients());
        c1.move_patient(p2, c2);
        System.out.println(c1.get_list_of_patients());
        System.out.println(c2.get_list_of_patients());
        System.out.println(c1.get_patient_history(p1));
        System.out.println(c1.get_list_of_patients_by_medical_condition("m's medical condition"));
        output fileoutput = new output();
        input fileinput = new input();
        GUIfirst a = new GUIfirst();
    }

}
