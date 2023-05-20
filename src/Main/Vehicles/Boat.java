/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class Boat extends MarineVehicle {
    public static double purchasePrice = 800;
    public static int capacity = 20;
    public static String companyName = "LaCoure";

    public static FuelType fuelType = FuelType.DIESEL;
    public static double minDepth = 0.5;

    private int paddeleNum;

    // constructor
    public Boat(int paddeleNum) {
        super();
        this.paddeleNum = paddeleNum;
        // double purchasePrice, int capacity, int ID, String companyName, String
        // fuelType, double minDepth,
        // purchasePrice, capacity, ID, companyName, fuelType, minDepth);
    }

    public int getPaddeleNum() {

        return paddeleNum;
    }

    public void setPaddeleNum(int paddeleNum) {
        this.paddeleNum = paddeleNum;
    }

}
