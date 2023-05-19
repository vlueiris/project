/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import java.util.UUID;

public abstract class Vehicle {

    public static double purchasePrice;
    public static int capacity;
    public static String companyName;

    private UUID id = UUID.randomUUID();

    // constructor
//    public Vehicle(double purchasePrice, int capacity, int ID, String companyName) {
    public Vehicle() {

//        setPurchaseAmount(purchasePrice);
//        setCapacity(capacity);
//        setId(ID);
//        setCompanyName(companyName);  
    }
    // setters

//    public void setPurchaseAmount(double purchasePrice) {
//        this.purchasePrice = purchasePrice;
//    }
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//    public void setId(int ID) {
//        this.ID = ID;
//}
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
// getters
//    public double getPurchaseAmount() {
//        return purchasePrice;
//    }
//    public int getCapacity() {
//        return capacity;
//    }
//    public String getCompanyName() {
//        return companyName;
//    }
//
    public UUID getId() {
        return this.id;
    }

}
