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

    public static double purchasePrice = 30000;
    public static int capacity = 900;
    public static String companyName = "GE";

    public static FuelType fuelType = FuelType.DIESEL;

    private int wagonNum;
    private int starsNum;
    private List<WelfareFacility> facilities;
    // = new WelfareFacility[]{WelfareFacility.RESTAURANT, WelfareFacility.RESTROOM,
    // WelfareFacility.RESTROOM};

    // constructor
    public Train(int wagonNum, int starsNum, List<WelfareFacility> facilities) {
        // (double purchasePrice, int capacity, int ID, String companyName, String
        // fuelType, int wagonNum, int starsNum) {
        super();
        // purchasePrice, capacity, ID, companyName, fuelType);
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

    // public void setFacilities(WelfareFacility[] facilities) {

    //     this.facilities = facilities;
    // }
    // ------------------------------------

}
