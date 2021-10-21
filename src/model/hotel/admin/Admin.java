package model.hotel.admin;

import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

public class Admin implements IAdmin{
    Hotel hotel;

    public Admin(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addNewRoom(Room room){
        hotel.getRoomArrayList().add(room);
    }
    public void removeRoom(Room room){
        hotel.getRoomArrayList().remove(room);
    }
}
