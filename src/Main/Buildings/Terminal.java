package Main.Buildings;

import Main.Person;
import java.util.ArrayList;
import java.util.List;

public abstract class Terminal {
    private double constructionCost;
    private String cityName;
    private String terminalName;
    private String address;
    private double area;
    private int numVehicle;

    public List<Person> drivers;

    // constructor
    Terminal(double constructionCost, String cityName, String terminalName, String address, double area,
            int numberOfVehicles
    // double constructionCost, String cityName, String terminalName, String
    // address, double meterage,
    ) {
        this.constructionCost = constructionCost;
        this.cityName = cityName;
        this.terminalName = terminalName;
        this.address = address;
        this.area = area;
        this.numVehicle = numberOfVehicles;
        this.drivers = new ArrayList<>();

        // setCityName(cityName);
        // setTerminalName(terminalName);
        // setAddress(address);
        // setArea(area);
        // setNumberOfVehicles(numVehicle);
    }

    // public static Terminal createTerminal(double constructionCost, String
    // cityName, String terminalName, String address,
    // double meterage, int numVehicle) {
    // return new Terminal(constructionCost, cityName, terminalName, address,
    // meterage, numVehicle) {
    // };
    // }

    // ------------------------------------------
    public void hireEmployee(Person employee) {
        drivers.add(employee);
    }

    public List<Person> getEmployees() {
        return drivers;
    }

    // ------------------------------------------
    public double getConstructionCost() {
        return constructionCost;
    }

    // public void setConstructionCost(double constructionCost) {
    // this.constructionCost = constructionCost;
    // }

    public String getCityName() {
        return cityName;
    }

    // public void setCityName(String cityName) {
    // this.cityName = cityName;
    // }

    public String getTerminalName() {
        return terminalName;
    }

    // public void setTerminalName(String terminalName) {
    // this.terminalName = terminalName;
    // }

    public String getAddress() {
        return address;
    }

    // public void setAddress(String address) {
    // this.address = address;
    // }

    public double getMeterage() {
        return this.area;
    }

    // public void setArea(double meterage) {
    // this.meterage = meterage;
    // }

    public int getNumberOfVehicles() {
        return numVehicle;
    }

    // public void setNumberOfVehicles(int numVehicle) {
    // this.numVehicle = numVehicle;
    // }

}
