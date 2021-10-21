package model.bill;

import model.room.roomData.Room;
import model.user.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.DAYS;

public class Bill implements IBill, Serializable {
    private User user;
    private LocalDate bookedTime;
    private LocalDate checkoutTime;
    private Room room;
    private long money;
    private long dayBetween;
    private boolean status;

    //CONSTRUCTOR
    public Bill() {
        user = new User();
    }

    public Bill(User user) {
        this.user = user;

    }

    public Bill(User user, Room room) {
        this.user = user;
        this.room = room;
        bookedTime = LocalDate.now();
        room.setStartBook(bookedTime);
        this.status = false;
    }

    //GET SET


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getDayBetween() {
        return dayBetween;
    }

    public void setDayBetween() {
        dayBetween = DAYS.toChronoUnit().between(bookedTime,checkoutTime);
    }

    public long getMoney() {
        return money;
    }

    public void setMoney() {
        if(checkoutTime!= null){
            setDayBetween();
            money = getDayBetween() * room.getPrice();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(LocalDate bookedTime) {
        this.bookedTime = bookedTime;
    }

    public LocalDate getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDate checkoutTime) {
        this.checkoutTime = checkoutTime;
        room.setEndBook(checkoutTime);
    }

    @Override
    public String toString() {
        if(checkoutTime==null){
            String notYetCheckoutTime = "Not_checkout_yet";
        return "Bill{" +
                "user=" + user +
                ", bookedTime=" + bookedTime +
                ", checkoutTime=" + notYetCheckoutTime +
                ", room=" + room +
                '}';
        }else
            return  "Bill{" +
                "user=" + user +
                ", bookedTime=" + bookedTime +
                ", checkoutTime=" + checkoutTime +
                ", room=" + room +
                ", money=" + money +
                ", dayBetween=" + dayBetween +
                '}';
    }
}
