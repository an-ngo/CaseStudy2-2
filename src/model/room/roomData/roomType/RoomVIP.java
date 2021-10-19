package model.room.roomData.roomType;

import model.room.roomData.EnumRoomType;
import model.room.roomData.Room;

public class RoomVIP extends Room {
    public RoomVIP(int serial){
        super(serial,EnumRoomType.VIP);
    }

}
