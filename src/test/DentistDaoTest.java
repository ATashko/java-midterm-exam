package test;


import model.Dentist;

import org.junit.jupiter.api.Test;
import service.DentistService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DentistDaoTest {


    @Test

    void dentistIsCorrectlyAddedToList () throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Dentist dentist = new Dentist(1,"Pérez", "Ramón", 3344);
        Dentist dentist1 = new Dentist(2,"López", "Mario", 5461);

        DentistService dentistService = new DentistService();

        dentistService.addDentist(dentist);
        dentistService.addDentist(dentist1);

        String result = dentistService.completeDentistDirectory().toString();

        String expected = "";

        assertEquals(expected, result);





    }


}
