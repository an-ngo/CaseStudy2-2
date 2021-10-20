package controller.hotelManager;

import model.hotel.commandHotel.ICommandHotel;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

import java.util.ArrayList;

public class HotelManager implements IHotelManager{
    private ICommandHotel commandHotel;
    private static HotelManager hotelManager;
    private Hotel hotel = new Hotel();
    private ArrayList<Room> roomArrayList = new ArrayList<>();

    public HotelManager() {
        roomArrayList = new ArrayList<>();
    }

    public HotelManager(ICommandHotel commandHotel) {
        this.commandHotel = commandHotel;
    }

    public HotelManager(ICommandHotel commandHotel, HotelManager hotelManager, Hotel hotel, ArrayList<Room> roomArrayList) {
        this.commandHotel = commandHotel;
        this.hotelManager = hotelManager;
        this.hotel = hotel;
        this.roomArrayList = roomArrayList;
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
        return roomArrayList;
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
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
    }

    @Override
    public void doCommand() {
        commandHotel.execute();
    }

    @Override
    public void addRoom(Room room) {
        roomArrayList.add(room);
        hotel.setRoomArrayList(roomArrayList);
    }

    @Override
    public void removeRoom(int index) {
        roomArrayList.remove(index);
    }

}

