package service;

import dao.Dao;
import dao.DentistDao;
import model.Dentist;
import model.Patient;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class DentistService {

    private Dao<Dentist> dentistServiceDao;

    public DentistService(){
        this.dentistServiceDao = new DentistDao();
    }

    public Dao<Dentist> getDentistServiceDao() {
        return dentistServiceDao;
    }

    public void setDentistServiceDao(Dao<Dentist> dentistServiceDao) {
        this.dentistServiceDao = dentistServiceDao;
    }

    public Dentist addDentist (Dentist dentist) throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        dentistServiceDao.add(dentist);
        return dentist;
    }

    public Dentist upDateDentist (Dentist dentist) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        dentistServiceDao.update(dentist);
        return dentist;
    }

    public void deleteDentist (int ID) throws SQLException {
        try {
            dentistServiceDao.delete(ID);
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

    public List<Dentist> completeDentistDirectory() throws SQLException {
        try {
            return dentistServiceDao.listAll();
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
