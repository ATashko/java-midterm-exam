package dao;


import model.Patient;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements Dao<Patient>{

    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/h2-database;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(PatientDao.class);


    @Override
    public Patient add (Patient patient) throws SQLException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Connection connection = null;
        PreparedStatement preparedStatementInsert = null;


        Class.forName(DB_JDBC_Driver).getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        preparedStatementInsert = connection.prepareStatement(
                "INSERT INTO patients(ID, name, lastName, address, DNI, dischargedDate) VALUES (?,?,?,?,?,?)");

        preparedStatementInsert.setInt(1, patient.getID());
        preparedStatementInsert.setString(2, patient.getName());
        preparedStatementInsert.setString(3, patient.getLastName());
        preparedStatementInsert.setString(4, patient.getAddress());
        preparedStatementInsert.setInt(5, patient.getDNI());
        preparedStatementInsert.setString(6, patient.getDischargeDate());

        preparedStatementInsert.execute();
        LOGGER.info("El paciente ha sido añadido");
        preparedStatementInsert.close();

        connection.close();

        return patient;


    }


    @Override
    public Patient update(Patient patient) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Connection connection = null;
        PreparedStatement preparedStatementUpdate = null;

        Class.forName(DB_JDBC_Driver).getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        preparedStatementUpdate = connection.prepareStatement("UPDATE patients SET dischargedDate =? WHERE ID=?");
        preparedStatementUpdate.setString(1, patient.getDischargeDate());
        preparedStatementUpdate.setInt(2, patient.getID());
        preparedStatementUpdate.execute();
        preparedStatementUpdate.close();
        LOGGER.info("La fecha de alta del dentista ha sido actualizada");

        connection.close();

        return patient;
    }

    @Override
    public void delete(int ID) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Connection connection = null;
        PreparedStatement preparedStatementDelete = null;
        try {
            Class.forName(DB_JDBC_Driver).getDeclaredConstructor().newInstance();;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatementDelete = connection.prepareStatement("DELETE FROM patients where ID=?");
            preparedStatementDelete.setInt(1, ID);
            preparedStatementDelete.execute();
            LOGGER.info("El paciente fue eliminado exitosamente");
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se puede eliminar el dato");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> listAll() throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Patient> patientDirectory = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_Driver).getDeclaredConstructor().newInstance();;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM patients");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int patientID = result.getInt("ID");
                String patientName = result.getString("name");
                String patientLastName = result.getString("lastName");
                String patientAddress = result.getString("address");
                int patientDNI = result.getInt("DNI");
                String patientDischargedDate = result.getString("dischargedDate");



                Patient patient = new Patient();
                patient.setID(patientID);
                patient.setName(patientName);
                patient.setLastName(patientLastName);
                patient.setAddress(patientAddress);
                patient.setDNI(patientDNI);
                patient.setDischargeDate(patientDischargedDate);


                patientDirectory.add(patient);
            }

            preparedStatement.executeQuery();
            LOGGER.info("El directorio  ha sido creado exitosamente");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return patientDirectory;
    }
}


