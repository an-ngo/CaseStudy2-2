package model.hotel.commandHotel;

import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

public class DisplayAllRoomCommand implements ICommandHotel{
    Hotel hotel;
    public DisplayAllRoomCommand(Hotel hotel){
        this.hotel = hotel;
    }

    @Override
    public void execute() {
        hotel.displayAllRoom();
    }


}
