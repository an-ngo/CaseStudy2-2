package model.room.roomData.roomType;

import model.room.roomData.EnumRoomType;
import model.room.roomData.Room;

public class RoomNormal extends Room {
    public RoomNormal(int serial) {
        super(serial,EnumRoomType.normal);
        super.setPrice(10000);
    }
}
