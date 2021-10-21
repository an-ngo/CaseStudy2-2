package view.loadBeforeRun;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;
import model.room.roomData.roomType.RoomBusiness;
import model.room.roomData.roomType.RoomNormal;
import model.room.roomData.roomType.*;

public class LoadBeforeRun {
    public static HotelManager loadBeforeRun(){
        HotelManager hotelManager = HotelManager.getInstance();
        Hotel hotel = new Hotel("Binh An",3.5);
        hotelManager.setHotel(hotel);
        Room room1 = new RoomNormal(11);
        Room room2 = new RoomBusiness(12);
        Room room3 = new RoomVIP(13);
        hotelManager.addRoom(room1);
        hotelManager.addRoom(room2);
        hotelManager.addRoom(room3);
        Room room4 = new RoomNormal(21);
        Room room5 = new RoomBusiness(22);
        Room room6 = new RoomVIP(23);
        hotelManager.addRoom(room4);
        hotelManager.addRoom(room5);
        hotelManager.addRoom(room6);
        return hotelManager;
    }
}
