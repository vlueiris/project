/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import Main.Vehicles.AirVehicle;

public class Airport extends Terminal {
    private boolean typeIsInternational;
    private int runwayNum;

    public Airport(double constructionCost, String cityName, String terminalName, String address, double area,
            boolean typeIsInternational, int runwayNum) {
        super(constructionCost, cityName, terminalName, address, area);
        this.typeIsInternational = typeIsInternational;
        this.runwayNum = runwayNum;
    }

    // ------------------------------------------
    public void addVehicle(AirVehicle airVehicle) {
        vehicles.add(airVehicle);
    }

    // ------------------------------------------
    public boolean isInternational() {
        return typeIsInternational;
    }
    // ------------------------------------------

    public int getNumberOfRunways() {
        return runwayNum;
    }

}
