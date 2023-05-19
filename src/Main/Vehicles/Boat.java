/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

public class Boat extends MarineVehicle{
    public static double purchasePrice;
    public static int capacity;
    public static String companyName;
    
    private int paddeleNum;
    //constructor
    public Boat(
            double purchasePrice, int capacity, int ID, String companyName, String fuelType, double minDepth, int paddeleNum){
        super(purchasePrice, capacity, ID, companyName, fuelType, minDepth);
    }
    
}


