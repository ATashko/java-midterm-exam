package model;

import org.apache.log4j.Logger;

public class Dentist {

    private int ID;
    private String lastName;
    private String name;
    private int license;

    private static final Logger LOGGER = Logger.getLogger(Dentist.class);

    public Dentist() {
    }

    public Dentist(int ID, String lastName, String name, int license) {
        this.ID = ID;
        this.lastName = lastName;
        this.name = name;
        this.license = license;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }


}
