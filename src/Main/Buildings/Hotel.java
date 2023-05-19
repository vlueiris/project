/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Buildings;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private double constructionCost;
    private String address;
    private int stars;
    //private int roomsNum;
    private List<Room> rooms;

    // constructor

    public Hotel(String hotelName, double constructionCost, String address, int stars) {
        setHotelName(hotelName);
        setConstructionCost(constructionCost);
        setAddress(address);
        setStars(stars);
        this.rooms = new ArrayList<>();
    }

    // methods

    public void addRoom(Room room) {
        rooms.add(room);
    }

    // getters and setters

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public void setConstructionCost(double constructionCost) {
        this.constructionCost = constructionCost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Room> getRooms() {
        return rooms;
    }

}

