/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class Ship extends MarineVehicle {

    public static double purchasePrice = 30000;
    public static int capacity = 500;
    public static String companyName = "Daewoo";

    public static FuelType fuelType = FuelType.DIESEL;
    public static double minDepth = 25;

    private int tonnage;

    // constructor
    public Ship(int tonnage) {
        super();
        this.tonnage = tonnage;
        // double purchasePrice, int capacity, int ID, String companyName, String
        // fuelType, double minDepth, int rudderNum) {
        // purchasePrice, capacity, ID, companyName, fuelType, minDepth);
    }

    public int getTonnage() {

        return tonnage;
    }

    // public void setTonnage(int paddeleNum) {
    // this.tonnage = paddeleNum;
    // }
}
