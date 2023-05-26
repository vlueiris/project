/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class PassengerPlane extends AirVehicle {

    public static double purchasePrice = 20000;
    public static int capacity = 200;
    public static String companyName = "Airbus";

    public static double maxFlightHeight = 11000;
    public static double runwayLength = 600;

    private int crewNum = 10;
    private int seatRow = 4;

    // constructor
    public PassengerPlane(int crewNum, int seatRow) {
        super();
        this.crewNum = crewNum;
        this.seatRow = seatRow;
        // double purchasePrice, int capacity, int ID, String companyName, int crewNum,
        // int seatRow, double maxFlightHeight, double runwayLength
        // }) {
        // purchasePrice, capacity, ID, companyName, maxFlightHeight, runwayLength);
        // setNumberOfCrews(crewNum);
        // setAircraftSeats(seatRow);
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

