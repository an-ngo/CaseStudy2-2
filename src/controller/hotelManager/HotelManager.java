package controller.hotelManager;

import model.hotel.commandHotel.ICommandHotel;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;

import java.util.ArrayList;

public class HotelManager implements IHotelManager{
    private ICommandHotel commandHotel;
    private static HotelManager hotelManager;
    private Hotel hotel;
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

    @Override
    public void doCommand() {
        commandHotel.execute();
    }

    @Override
    public void addRoom(Room room) {
        roomArrayList.add(room);
    }

    @Override
    public void removeRoom(int index) {
        roomArrayList.remove(index);
    }

}

