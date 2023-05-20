/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.ArrayList;
import java.util.List;
import Main.Vehicles.InterCityBus;

public class BusTerminal extends Terminal {
    private List<InterCityBus> buses;

    private BusTerminal(double constructionCost, String cityName, String terminalName, String address, double area,
            int numberOfVehicles) {
        super(constructionCost, cityName, terminalName, address, area, numberOfVehicles);
        this.buses = new ArrayList<>();
    }

    // public static BusTerminal createBusTerminal(double constructionCost, String
    // cityName, String terminalName,
    // String address, double meterage, int numVehicle) {
    // return new BusTerminal(constructionCost, cityName, terminalName, address,
    // meterage, numVehicle);
    // }
    // ------------------------------------------
    public void addBus(InterCityBus bus) {
        buses.add(bus);
    }

    public List<InterCityBus> getBuses() {
        return buses;
    }
    // ------------------------------------------

}
