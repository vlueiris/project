package Main.Buildings;

public class Room {
    private int roomNum;
    private int bedsNum;
    private double area;
    private double roomCost;

    // constructor

    public Room(int roomNum, int bedsNum, double area, double roomCost) {
        setRoomNumber(roomNum);
        setBedsNumber(bedsNum);
        // setArea(area);
        this.area = area;
        setRoomCost(roomCost);
    }

    // ------------------------------------
    public int getRoomNumber() {
        return this.roomNum;
    }

    public void setRoomNumber(int roomNum) {
        this.roomNum = roomNum;
    }

    // ------------------------------------
    public int getBedsNumber() {
        return this.bedsNum;
    }

    public void setBedsNumber(int bedsNum) {
        this.bedsNum = bedsNum;
    }

    // ------------------------------------
    public double getArea() {
        return this.area;
    }

    // public void setArea(double meterage) {
    //     this.area = meterage;
    // }

    // ------------------------------------
    public double getRoomCost() {
        return this.roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }

}
