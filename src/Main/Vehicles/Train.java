/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import java.util.ArrayList;

enum WelfareFacility {
    RESTAURANT, RESTROOM
}

enum Stars {
    ONE, TWO, THREE, FOUR, FIVE
}

public class Train extends LandVehicle {

    public static double purchasePrice = 30000;
    public static int capacity = 900;
    public static String companyName = "Daewoo";

    public static FuelType fuelType = FuelType.DIESEL;

    private int wagonNum;
    private Stars starsNum;
    private static WelfareFacility[] facilities;
//    = new WelfareFacility[]{WelfareFacility.RESTAURANT, WelfareFacility.RESTROOM, WelfareFacility.RESTROOM};

    // constructor
    public Train(int wagonNum, Stars starsNum, WelfareFacility[] facilities) {
//        (double purchasePrice, int capacity, int ID, String companyName, String fuelType, int wagonNum, int starsNum) {
        super();
//                purchasePrice, capacity, ID, companyName, fuelType);
        setNumberOfWagons(wagonNum);
        setStars(starsNum);
    }

    // getters and setters
    public int getNumberOfWagons() {
        return wagonNum;
    }

    public void setNumberOfWagons(int wagonNum) {
        this.wagonNum = wagonNum;
    }

    public Stars getStars() {
        return starsNum;
    }

    public void setStars(Stars starsNum) {

        this.starsNum = starsNum;
    }

}
