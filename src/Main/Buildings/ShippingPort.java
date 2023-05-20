/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.List;
import Main.Vehicles.MarineVehicle;
import java.util.ArrayList;

public class ShippingPort extends Terminal {
    private List<MarineVehicle> vehicles;
    private int wharfNum;

    private ShippingPort(double constructionCost, String cityName, String terminalName, String address, double area,
            int numberOfVehicles, int wharfNum) {
        super(constructionCost, cityName, terminalName, address, area, numberOfVehicles);
        this.wharfNum = wharfNum;
        this.vehicles = new ArrayList<>();
    }

    // public static ShippingPort createShippingPort(double constructionCost, String
    // cityName, String terminalName, String address, double meterage, int
    // numVehicle, int wharfNum) {
    // return new ShippingPort(constructionCost, cityName, terminalName, address,
    // meterage, numVehicle, wharfNum);
    // }
    // ------------------------------------------
    public List<MarineVehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(MarineVehicle vehicle) {
        vehicles.add(vehicle);
    }

    // ------------------------------------------
    public int getNumberOfDocks() {
        return wharfNum;
    }

    // ------------------------------------------
}
