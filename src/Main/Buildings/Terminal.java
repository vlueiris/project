package Main.Buildings;

import Main.Person;
import java.util.ArrayList;
import java.util.List;
import Main.Person;


public abstract class Terminal{
    static double constructionCost;
    static String cityName;
    static String terminalName;
    static String address;
    static double meterage;
    static int numVehicle;
    
    private List<Person> passenger;

    // constructor

    Terminal(double constructionCost, String cityName, String terminalName, String address, double meterage, int numberOfVehicles) {
        setConstructionCost(constructionCost);
        setCityName(cityName);
        setTerminalName(terminalName);
        setAddress(address);
        setMeterage(meterage);
        setNumberOfVehicles(numVehicle);
        this.passenger = new ArrayList<>();
    }

    public static Terminal createTerminal(double constructionCost, String cityName, String terminalName, String address, double meterage, int numVehicle) {
        return new Terminal(constructionCost, cityName, terminalName, address, meterage, numVehicle){};
    }

    // methods
    public void hireEmployee(Person employee) {
        passenger.add(employee);
    }
    // getters and setters

    public double getConstructionCost() {
        return constructionCost;
    }

    public void setConstructionCost(double constructionCost) {
        this.constructionCost = constructionCost;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {        
        this.cityName = cityName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMeterage() {
        return meterage;
    }

    public void setMeterage(double meterage) {
        this.meterage = meterage;
    }

    public int getNumberOfVehicles() {
        return numVehicle;
    }

    public void setNumberOfVehicles(int numVehicle) {
        this.numVehicle = numVehicle;
    }

    public List<Person> getEmployees() {
        return passenger;
    }
}





    

