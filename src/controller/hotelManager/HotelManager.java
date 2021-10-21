package controller.hotelManager;

import model.hotel.commandHotel.ICommandHotel;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

import java.util.ArrayList;

public class HotelManager implements IHotelManager{
    private static HotelManager hotelManager;
    private ICommandHotel commandHotel;
    private Hotel hotel = new Hotel();
    //private ArrayList<Room> roomArrayList = new ArrayList<>();

//    private HotelManager() {
//        roomArrayList = new ArrayList<>();
//    }

    public HotelManager() {
    }

    public HotelManager(Hotel hotel){
        this.hotel = hotel;
    }

    public HotelManager(ICommandHotel commandHotel) {
        this.commandHotel = commandHotel;
    }

    public HotelManager(ICommandHotel commandHotel, HotelManager hotelManager, Hotel hotel, ArrayList<Room> roomArrayList) {
        this.commandHotel = commandHotel;
        this.hotel = hotel;
        //this.roomArrayList = roomArrayList;
    }

    public static HotelManager getInstance(){
        if(hotelManager == null){
            hotelManager = new HotelManager();
        }
        return hotelManager;
    }
    public void setCommandHotel(ICommandHotel commandHotel) {
        this.commandHotel = commandHotel;
    }

    public ArrayList<Room> getRoomArrayList() {
        return hotel.getRoomArrayList();
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        hotel.setRoomArrayList(roomArrayList);
    }

    public ICommandHotel getCommandHotel() {
        return commandHotel;
    }

    public static HotelManager getHotelManager() {
        return hotelManager;
    }

    public static void setHotelManager(HotelManager hotelManager) {
        HotelManager.hotelManager = hotelManager;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        //this.hotel.getRoomArrayList() = hotel.getRoomArrayList();
    }

    @Override
    public void doCommand() {
        commandHotel.execute();
    }

    @Override
    public void addRoom(Room room) {
        hotel.getRoomArrayList().add(room);
        //hotel.setRoomArrayList(roomArrayList);
    }

    @Override
    public void removeRoom(int index) {
        hotel.getRoomArrayList().remove(index);
    }

    public Room getRoomBySerial(int serial){
        for (Room room :
                hotel.getRoomArrayList()) {
            if (room.getSerial() == serial) {
                return room;
            }
        }
        return null;
    }

}

