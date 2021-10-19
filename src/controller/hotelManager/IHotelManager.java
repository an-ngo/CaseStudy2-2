package controller.hotelManager;

import model.room.roomData.Room;

public interface IHotelManager {
    public void doCommand();
    public void addRoom(Room room);
    public void removeRoom(int index);

}
