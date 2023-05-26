/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class Train extends LandVehicle {

    public enum WelfareFacility {
        RESTAURANT, RESTROOM
    }

    private int wagonNum;
    private int starsNum;
    private List<WelfareFacility> facilities;

    // constructor
    public Train(int wagonNum, int starsNum, List<WelfareFacility> facilities) {

        super();
        Vehicle.purchasePrice = 30000;
        Vehicle.capacity = 900;
        Vehicle.companyName = "GE";
        Vehicle.fuelType = FuelType.DIESEL;

        setNumberOfWagons(wagonNum);
        setStars(starsNum);
        this.facilities = new ArrayList<>();

    }

    // ------------------------------------
    public int getNumberOfWagons() {
        return wagonNum;
    }

    public void setNumberOfWagons(int wagonNum) {
        this.wagonNum = wagonNum;
    }

    // ------------------------------------
    public int getStars() {
        return starsNum;
    }

    public void setStars(int starsNum) {

        this.starsNum = starsNum;
    }

    // ------------------------------------
    public List<WelfareFacility> getFacilities() {
        return facilities;
    }

    // ------------------------------------

}
