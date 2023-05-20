/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import Main.Vehicles.InterCityBus;

public class BusTerminal extends Terminal {

    private BusTerminal(double constructionCost, String cityName, String terminalName, String address, double area) {
        super(constructionCost, cityName, terminalName, address, area);
    }

    // ------------------------------------------
    public void addVehicle(InterCityBus bus) {
        vehicles.add(bus);
    }

    // ------------------------------------------

}
