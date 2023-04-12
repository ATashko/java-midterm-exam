package dao;


import model.Dentist;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DentistDao implements Dao<Dentist> {



    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/h2-database;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(DentistDao.class);



    @Override
    public Dentist add(Dentist dentist) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Connection connection = null;
        PreparedStatement preparedStatementInsert = null;



            Class.forName(DB_JDBC_Driver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatementInsert = connection.prepareStatement(
                    "INSERT INTO dentists(ID, lastName, name, license) VALUES (?,?,?,?)");

            preparedStatementInsert.setInt(1, dentist.getID());
            preparedStatementInsert.setString(2, dentist.getLastName());
            preparedStatementInsert.setString(3, dentist.getName());
            preparedStatementInsert.setInt(4, dentist.getLicense());

            preparedStatementInsert.execute();
            LOGGER.info("El dentista ha sido añadido");

                   connection.close();
        return dentist;
    }




    @Override
    public Dentist update(Dentist dentist) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatementUpdate = null;
        DriverManager driverManager = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatementUpdate = connection.prepareStatement("UPDATE dentists SET license =? WHERE ID=?");
            preparedStatementUpdate.setInt(1, dentist.getLicense());
            preparedStatementUpdate.setInt(2, dentist.getID());
            preparedStatementUpdate.execute();
            LOGGER.info("La licencia del dentista ha sido actualizada");
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se puede actualizar el dato");
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
        return dentist;
    }


    @Override
    public void delete(int ID) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatementDelete = null;
        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatementDelete = connection.prepareStatement("DELETE FROM dentists where ID=?");
            preparedStatementDelete.setInt(1, ID);
            preparedStatementDelete.execute();
            LOGGER.info("El dentista fue eliminado exitosamente");
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se puede eliminar el dato");
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Dentist> listAll() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Dentist> dentistDirectory = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM dentists");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int dentistId = result.getInt("id");
                int dentistLicense = result.getInt("license");
                String dentistLastName = result.getString("lastName");
                String dentistName = result.getString("name");

                Dentist dentist = new Dentist();
                dentist.setID(dentistId);
                dentist.setLicense(dentistLicense);
                dentist.setLastName(dentistLastName);
                dentist.setName(dentistName);

                dentistDirectory.add(dentist);
            }

            preparedStatement.executeQuery();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        return dentistDirectory;
    }
}

