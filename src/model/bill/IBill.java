package model.bill;

import model.room.roomData.Room;

public interface IBill {
    public void bookRoomByUser(Room room);
    public void checkOutRoomByUser(int index);

}
