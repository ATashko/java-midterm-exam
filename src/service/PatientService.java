package service;

import dao.Dao;
import dao.PatientDao;
import model.Patient;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private Dao<Patient> patientServiceDao;

    public PatientService(){
        this.patientServiceDao = new PatientDao();
    }

    public Dao<Patient> getPatientServiceDao() {
        return patientServiceDao;
    }

    public void setPatientServiceDao(Dao<Patient> patientServiceDao) {
        this.patientServiceDao = patientServiceDao;
    }

    public Patient addPatient (Patient patient) throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        patientServiceDao.add(patient);
        return patient;
    }

    public Patient upDateDentist (Patient patient) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        patientServiceDao.update(patient);
        return patient;
    }

    public void deletePatient (int ID) throws SQLException {
        try {
            patientServiceDao.delete(ID);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> completePatientDirectory() throws SQLException {
        try {
            return patientServiceDao.listAll();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
