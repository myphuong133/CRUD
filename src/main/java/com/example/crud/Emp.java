package com.example.crud;

public class Emp {
    private int idEmp;
    private String nameEmp,passEmp,emailEmp,countryEmp;

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public String getPassEmp() {
        return passEmp;
    }

    public void setPassEmp(String passEmp) {
        this.passEmp = passEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getCountryEmp() {
        return countryEmp;
    }

    public void setCountryEmp(String countryEmp) {
        this.countryEmp = countryEmp;
    }

    public Emp(int idEmp, String nameEmp, String passEmp, String emailEmp, String countryEmp) {
        this.idEmp = idEmp;
        this.nameEmp = nameEmp;
        this.passEmp = passEmp;
        this.emailEmp = emailEmp;
        this.countryEmp = countryEmp;
    }
    public Emp(String nameEmp, String passEmp, String emailEmp, String countryEmp) {
        this.nameEmp = nameEmp;
        this.passEmp = passEmp;
        this.emailEmp = emailEmp;
        this.countryEmp = countryEmp;
    }
}
