package model.room.roomData.roomType;

import model.room.roomData.EnumRoomType;
import model.room.roomData.Room;

public class RoomBusiness extends Room {
    public RoomBusiness(int serial) {
        super(serial,EnumRoomType.business);
    }
}
