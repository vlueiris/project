/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class CargoPlane extends AirVehicle {

    private double sumTolerableWeight;

    // // constructor
    public CargoPlane(double sumTolerableWeight) {
        super();
        Vehicle.purchasePrice = 15000;
        Vehicle.capacity = 100;
        Vehicle.companyName = "Boeing";
        Vehicle.fuelType = FuelType.GASOLINE;

        AirVehicle.maxFlightHeight = 8000;
        AirVehicle.runwayLength = 800;

        this.sumTolerableWeight = sumTolerableWeight;

    }
    // -------------------------------------

    public double getTotalPayloadWeight() {
        return sumTolerableWeight;
    }
    // -------------------------------------

}
