package model.room.roomData;

public class Room implements IRoom{
    int serial;
    EnumRoomType type ;

    public Room(int serial, EnumRoomType type) {
        this.serial = serial;
        this.type = type;
    }

    public Room(EnumRoomType type) {
        this.type = type;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public EnumRoomType getType() {
        return type;
    }

    public void setType(EnumRoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serial=" + serial +
                ", type=" + type +
                '}';
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("-------------------");
        System.out.println(toString());
        System.out.println("-------------------");
    }
}
