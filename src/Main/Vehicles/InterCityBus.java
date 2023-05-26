/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class InterCityBus extends LandVehicle {

    public static double purchasePrice = 1500;
    public static int capacity = 10;
    public static String companyName = "Volvo";

    public static FuelType fuelType = FuelType.GASOLINE;

    private int totalSeatNum;

    // constructor
    public InterCityBus(int totalSeatNum) {
        super();
        this.totalSeatNum = totalSeatNum;
        // double purchasePrice, int capacity, int ID, String companyName, String
        // fuelType, int totalSeatNum) {
        // purchasePrice, capacity, ID, companyName, fuelType);
    }

    public void setTotalSeatNum(int totalSeatNum) {
        this.totalSeatNum = totalSeatNum;
    }

    public int getTotalSeatNum() {
        return totalSeatNum;
    }

}
