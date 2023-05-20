/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class CargoPlane extends AirVehicle {

    public static double purchasePrice = 15000;
    public static int capacity = 100;
    public static String companyName = "Boeing";

    public static double maxFlightHeight = 8000;
    public static double runwayLength = 800;

    private double sumTolerableWeight = 100;

    // // constructor
    public CargoPlane(double sumTolerableWeight) {
        super();
        this.sumTolerableWeight = sumTolerableWeight;
        // double purchasePrice, int capacity, int ID, String companyName, double
        // sumTolerableWeight, double maxFlightHeight, double runwayLength) {
        // purchasePrice, capacity, ID, companyName, maxFlightHeight, runwayLength);
        // setTotalPayloadWeight(sumTolerableWeight);
    }
    // -------------------------------------

    public double getTotalPayloadWeight() {
        return this.sumTolerableWeight;
    }
    // -------------------------------------

}
