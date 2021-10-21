package model.room.roomData;

import java.io.Serializable;
import java.time.LocalDate;

public class Room implements IRoom, Serializable {
    int serial;
    private boolean ready = true;
    EnumRoomType type ;
    private int price;
    private LocalDate startBook;
    private LocalDate endBook;

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

    public LocalDate getStartBook() {
        return startBook;
    }

    public void setStartBook(LocalDate startBook) {
        this.startBook = startBook;
    }

    public LocalDate getEndBook() {
        return endBook;
    }

    public void setEndBook(LocalDate endBook) {
        this.endBook = endBook;
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
                ", ready=" + ready +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    @Override
    public void displayRoomInfo() {
        System.out.println(toString());
    }
}
