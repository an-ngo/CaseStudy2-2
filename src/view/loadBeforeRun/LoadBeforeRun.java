package view.loadBeforeRun;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;
import model.room.roomData.roomType.RoomBusiness;
import model.room.roomData.roomType.RoomNormal;
import model.room.roomData.roomType.*;
import view.display.Display;

public class LoadBeforeRun {
    public static void loadBeforeRun(Display display){
        Hotel hotel1 = new Hotel("Binh An",2.5);
        Room room1 = new RoomNormal(11);
        Room room2 = new RoomBusiness(12);
        Room room3 = new RoomVIP(13);
        hotel1.addNewRoom(room1);
        hotel1.addNewRoom(room2);
        hotel1.addNewRoom(room3);
        Room room4 = new RoomNormal(21);
        Room room5 = new RoomBusiness(22);
        Room room6 = new RoomVIP(23);
        hotel1.addNewRoom(room4);
        hotel1.addNewRoom(room2);
        hotel1.addNewRoom(room3);
    }
}
