/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.List;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

public class ShippingPort extends Terminal{
    private List<Vehicle> vehicles;
    private int wharfNum;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getNumberOfDocks() {
        return wharfNum;
    }

    private ShippingPort(double constructionCost, String cityName, String terminalName, String address, double meterage, int numVehicle, int wharfNum) {
        super(constructionCost, cityName, terminalName, address, meterage, numVehicle);
        this.vehicles = new ArrayList<>();
        this.wharfNum = wharfNum;
    }

    public static ShippingPort createShippingPort(double constructionCost, String cityName, String terminalName, String address, double meterage, int numVehicle, int wharfNum) {
        return new ShippingPort(constructionCost, cityName, terminalName, address, meterage, numVehicle, wharfNum);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
