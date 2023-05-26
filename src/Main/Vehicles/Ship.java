/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class Ship extends MarineVehicle {

    private int tonnage;

    // constructor
    public Ship(int tonnage) {
        super();
        Vehicle.purchasePrice = 30000;
        Vehicle.capacity = 500;
        Vehicle.companyName = "Daewoo";
        Vehicle.fuelType = FuelType.DIESEL;

        MarineVehicle.minDepth = 25;

        this.tonnage = tonnage;

    }

    public int getTonnage() {
        return tonnage;
    }

}
