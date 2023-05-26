/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class Boat extends MarineVehicle {

    private int paddeleNum;

    // constructor
    public Boat(int paddeleNum) {
        super();
        Vehicle.purchasePrice = 800;
        Vehicle.capacity = 20;
        Vehicle.companyName = "LaCoure";
        Vehicle.fuelType = FuelType.GASOLINE;

        MarineVehicle.minDepth = 1.2;

        setPaddeleNum(paddeleNum);

    }

    public int getPaddeleNum() {

        return paddeleNum;
    }

    public void setPaddeleNum(int paddeleNum) {
        this.paddeleNum = paddeleNum;
    }

}
