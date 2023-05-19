/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.List;
import Main.Vehicles.Train;
import java.util.ArrayList;


public class TrainStation extends Terminal{
    private int inputRailNum;
    private int outputRailNum;
    private List<Train> trains;

    public List<Train> getTrains() {
        return trains;
    }

    public int getNumberOfInputRails() {
        return inputRailNum;
    }

    public int getNumberOfOutputRails() {
        return outputRailNum;
    }

    private TrainStation(double constructionCost, String cityName, String terminalName, String address, double meterage, int numVehicle, int inputRailNum,int outputRailNum) {
        super(constructionCost, cityName, terminalName, address, meterage, numVehicle);
        this.trains = new ArrayList<>();
        this.inputRailNum = inputRailNum;
        this.outputRailNum = outputRailNum;
    }

    public static TrainStation createTrainStation(double constructionCost, String cityName, String terminalName,
            String address, double meterage, int numVehicle, int inputRailNum, int outputRailNum) {
        return new TrainStation(constructionCost, cityName, terminalName, address, meterage, numVehicle, inputRailNum, outputRailNum);
    }

    public void addTrain(Train train) {
        trains.add(train);
    }
}
