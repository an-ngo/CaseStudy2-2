package model.hotel.hotelData;

import model.room.roomData.Room;

import java.util.ArrayList;

public class Hotel implements IHotel{
    String name;
    double rate;
    ArrayList<Room> roomArrayList = new ArrayList<>();

    public Hotel() {
        roomArrayList = new ArrayList<>();
    }

    public Hotel(String name, double rate) {
        this.name = name;
        this.rate = rate;
        roomArrayList = new ArrayList<>();

    }

    public Hotel(String name, double rate, ArrayList<Room> roomArrayList) {
        this.name = name;
        this.rate = rate;
        this.roomArrayList = roomArrayList;
    }

    //GET SET


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
    }

    @Override
    public void addNewRoom(Room room) {
        roomArrayList.add(room);
    }

    @Override
    public void displayAllRoom() {
        System.out.println("-------------------");
        for (int i = 0; i < roomArrayList.size(); i++) {
            System.out.println(roomArrayList.get(i).toString());
        }
        System.out.println("-------------------");
    }

    @Override
    public void displayHotelInfo() {
        System.out.println("-------------------");
        System.out.println(this.toString());
        System.out.println("-------------------");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
