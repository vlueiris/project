/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private double constructionCost;
    private String hotelName;
    private String address;
    private int stars;
    // private int roomsNum;
    private List<Room> rooms;

    // constructor

    public Hotel(double constructionCost, String hotelName, String address, int stars) {
        this.hotelName = hotelName;
        this.constructionCost = constructionCost;
        this.address = address;
        this.stars = stars;

        // setHotelName(hotelName);
        // setConstructionCost(constructionCost);
        // setAddress(address);
        // setStars(stars);
        this.rooms = new ArrayList<>();
    }

    // ------------------------------------
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // ------------------------------------
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    // ------------------------------------
    public double getConstructionCost() {
        return constructionCost;
    }
    // ------------------------------------

    // public void setConstructionCost(double constructionCost) {
    // this.constructionCost = constructionCost;
    // }

    // ------------------------------------
    public String getAddress() {
        return address;
    }

    // public void setAddress(String address) {
    // this.address = address;
    // }
    // ------------------------------------
    public int getStars() {
        return stars;
    }
    // ------------------------------------

    // public void setStars(int stars) {
    // this.stars = stars;
    // }

}
