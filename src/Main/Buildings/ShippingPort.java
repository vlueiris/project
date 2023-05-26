/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import Main.Vehicles.MarineVehicle;

public class ShippingPort extends Terminal {
    private int wharfNum;

    public ShippingPort(double constructionCost, String cityName, String terminalName, String address, double area,
            int wharfNum) {
        super(constructionCost, cityName, terminalName, address, area);
        this.wharfNum = wharfNum;
    }

    // ------------------------------------------
    public void addVehicle(MarineVehicle vehicle) {
        vehicles.add(vehicle);
    }

    // ------------------------------------------
    public int getNumberOfDocks() {
        return wharfNum;
    }

    // ------------------------------------------
}
