package model.room.commandRoom;

import model.room.roomData.Room;

public class DisplayRoomInfoCommand implements ICommandRoom{
    Room room;

    public DisplayRoomInfoCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.displayRoomInfo();
    }
}
