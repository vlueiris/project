package Main.Buildings;

public class Room {
    private int roomNum;
    private int bedsNum;
    private double meterage;
    private double roomCost;

    // constructor

    public Room(int roomNum, int bedsNum, double meterage, double roomCost) {
        setRoomNumber(roomNum);
        setBedNumber(bedsNum);
        setArea(meterage);
        setRoomCost(roomCost);
    }

    // setters and getters
    public int getRoomNumber() {
        return roomNum;
    }

    public void setRoomNumber(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getBedNumber() {
        return bedsNum;
    }

    public void setBedNumber(int bedsNum) {
        this.bedsNum = bedsNum;
    }

    public double getMeterage() {
        return meterage;
    }

    public void setArea(double meterage) {
        this.meterage = meterage;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }
    
}
