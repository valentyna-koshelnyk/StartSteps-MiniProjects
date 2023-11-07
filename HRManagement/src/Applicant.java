import enums.StatusApplication;

import java.util.ArrayList;
import java.util.List;

public class Applicant {
    List<String> previousCompanies = new ArrayList<>();
    private String name;
    private String currentCity;
    private String preferredLocation;
    private double expectedSalary;
    private StatusApplication status;
    public String getCurrentCity() {
        return currentCity;
    }
    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
    public String getPreferredLocation() {
        return preferredLocation;
    }
    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public StatusApplication getStatus() {
        return status;
    }

    public void setStatus(StatusApplication status) {
        this.status = status;
    }
    public Applicant(String name, String currentCity, String preferredLocation, double expectedSalary) {
        this.name = name;
        this.currentCity = currentCity;
        this.preferredLocation = preferredLocation;
        this.expectedSalary = expectedSalary;
        this.status = StatusApplication.PENDING;
    }
    public Applicant(List<String> previousCompanies, String currentCity, String preferredLocation, double expectedSalary) {
        this.previousCompanies = previousCompanies;
        this.currentCity = currentCity;
        this.preferredLocation = preferredLocation;
        this.expectedSalary = expectedSalary;
        this.status = StatusApplication.PENDING;
    }
    public boolean isRelocationPreferred(){
        return !(preferredLocation.equals(currentCity));
    }





}
