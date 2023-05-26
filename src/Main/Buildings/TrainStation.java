/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import Main.Vehicles.Train;

public class TrainStation extends Terminal {
    private int inputRailNum;
    private int outputRailNum;

    public TrainStation(double constructionCost, String cityName, String terminalName, String address, double area,
            int inputRailNum, int outputRailNum) {
        super(constructionCost, cityName, terminalName, address, area);
        this.inputRailNum = inputRailNum;
        this.outputRailNum = outputRailNum;
    }

    // ------------------------------------------
    public void addVehicle(Train train) {
        vehicles.add(train);
    }

    // ------------------------------------------
    public int getNumberOfInputRails() {
        return inputRailNum;
    }

    // ------------------------------------------
    public int getNumberOfOutputRails() {
        return outputRailNum;
    }
}
