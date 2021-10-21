package model.bill;

import model.room.roomData.Room;
import model.user.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bill implements IBill, Serializable {
    private User user ;
    private LocalDate bookedTime;
    private LocalDate checkoutTime;
    private ArrayList<Room> roomArrayList = new ArrayList<>();

    public Bill() {
        user = new User();
        roomArrayList = new ArrayList<>();
    }

    public Bill(User user) {
        Bill bill = new Bill(user, this.roomArrayList);
        this.user = user;
        roomArrayList = new ArrayList<>();
        user.setBill(bill);

    }

    public Bill(User user, ArrayList<Room> roomArrayList) {
        this.user = user;
        this.roomArrayList = roomArrayList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
    }

    @Override
    public void bookRoomByUser(Room room) {
        roomArrayList.add(room);
        user.setRoomArrayList(roomArrayList);
    }

    @Override
    public void checkOutRoomByUser(int index) {
        roomArrayList.remove(index);
        user.setRoomArrayList(roomArrayList);
    }
}
