package model.hotel.commandHotel;

import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

public class AddNewRoomCommand implements ICommandHotel{
    Hotel hotel;

    public AddNewRoomCommand(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void execute() {
//        Room room = new Room();
//        hotel.addNewRoom(room);
        System.out.println("-------------------");
        System.out.println("This addNewRoom function not complete yet");
        System.out.println("-------------------");
    }
}
