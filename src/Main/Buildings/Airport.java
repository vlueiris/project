/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.List;
import Main.Vehicles.AirVehicle;
import java.util.ArrayList;

public class Airport extends Terminal {
    private boolean typeIsInternational;
    private int runwayNum;
    private List<AirVehicle> airVehicles;

    private Airport(double constructionCost, String cityName, String terminalName, String address, double area,
            int numberOfVehicles, boolean typeIsInternational, int runwayNum) {
        super(constructionCost, cityName, terminalName, address, area, numberOfVehicles);
        this.typeIsInternational = typeIsInternational;
        this.runwayNum = runwayNum;
        this.airVehicles = new ArrayList<>();
    }

    // public static Airport createAirport(double constructionCost, String cityName,
    // String terminalName, String address,
    // double meterage, int numVehicle, boolean typeIsInternational, int runwayNum)
    // {
    // return new Airport(constructionCost, cityName, terminalName, address,
    // meterage, numVehicle, typeIsInternational,
    // runwayNum);
    // }
    // ------------------------------------------
    public void addAirVehicle(AirVehicle airVehicle) {
        airVehicles.add(airVehicle);
    }

    public List<AirVehicle> getAirVehicles() {
        return airVehicles;
    }
    // ------------------------------------------

    public boolean isInternational() {
        return typeIsInternational;
    }

    public int getNumberOfRunways() {
        return runwayNum;
    }

}
