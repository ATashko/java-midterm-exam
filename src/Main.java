import dao.DentistDao;
import dao.PatientDao;
import model.Dentist;
import model.Patient;
import org.apache.log4j.Logger;
import service.DentistService;
import service.PatientService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Patient patient = new Patient(8, "Lalo", "Miranda", "Calle de gatos # 45", 615987, "09-11-22");
        PatientService patientService = new PatientService();
        patientService.setPatientServiceDao(new PatientDao());
        patientService.addPatient(patient);

        Patient patient1 = new Patient(9,"Rosita", "López", "Galería de cosas # 5487", 655145, "04-11-22");
        patientService.addPatient(patient1);
        System.out.println(patient1);
        System.out.println(patientService.completePatientDirectory());

        Dentist dentist = new Dentist(48,"Roca", "Juan", 4521);
        DentistService dentistService = new DentistService();
        dentistService.setDentistServiceDao(new DentistDao());
        dentistService.addDentist(dentist);
        Dentist dentist1 = new Dentist(88, "Mendez", "Juana", 464667);
        dentistService.addDentist(dentist1);

        System.out.println(dentistService.completeDentistDirectory());
    }

}
