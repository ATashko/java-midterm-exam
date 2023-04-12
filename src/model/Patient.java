package model;

import org.apache.log4j.Logger;

import java.sql.Date;

public class Patient {

    private int ID;
    private String name;
    private String lastName;
    private String address;
    private int DNI;
    private String dischargeDate;

    private static final Logger LOGGER = Logger.getLogger(Patient.class);

    public Patient() {
    }

    public Patient(int ID, String name, String lastName, String address, int DNI, String dischargeDate) {
        this.ID= ID;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.DNI = DNI;
        this.dischargeDate = dischargeDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

}
