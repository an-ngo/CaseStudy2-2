package model.room.roomData;

import java.io.Serializable;

public class Room implements IRoom, Serializable {
    int serial;
    private boolean ready = true;
    EnumRoomType type ;
    private int price;

    public Room() {
    }

    public Room(int serial, EnumRoomType type) {
        this.serial = serial;
        this.type = type;
        ready = true;
    }

    public Room(EnumRoomType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public EnumRoomType getType() {
        return type;
    }

    public void setType(EnumRoomType type) {
        this.type = type;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serial=" + serial +
                ", type=" + type +
                '}';
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("-------------------");
        System.out.println(toString());
        System.out.println("-------------------");
    }
}
