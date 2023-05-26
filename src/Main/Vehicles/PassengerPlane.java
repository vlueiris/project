/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class PassengerPlane extends AirVehicle {

    private int crewNum;
    private int seatRow;

    // constructor
    public PassengerPlane(int crewNum, int seatRow) {
        super();
        Vehicle.purchasePrice = 20000;
        Vehicle.capacity = 200;
        Vehicle.companyName = "Airbus";
        Vehicle.fuelType = FuelType.GASOLINE;

        AirVehicle.maxFlightHeight = 11000;
        AirVehicle.runwayLength = 600;

        this.crewNum = crewNum;
        this.seatRow = seatRow;

    }

    // -------------------------------------
    public int getNumberOfCrews() {
        return crewNum;
    }

    // -------------------------------------
    public int getAircraftSeats() {
        return seatRow;
    }

}
