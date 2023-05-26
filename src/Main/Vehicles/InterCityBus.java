/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class InterCityBus extends LandVehicle {

    private int totalSeatNum;

    // constructor
    public InterCityBus(int totalSeatNum) {
        super();
        Vehicle.purchasePrice = 1500;
        Vehicle.capacity = 10;
        Vehicle.companyName = "Volvo";
        Vehicle.fuelType = FuelType.DIESEL;

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
