package controller.commandControllerMenu;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.commandHotel.DisplayAllRoomCommand;
import model.hotel.commandHotel.DisplayHotelInfoCommand;
import model.hotel.commandHotel.ICommandHotel;
import model.hotel.hotelData.Hotel;
import model.room.commandRoom.DisplayRoomInfoCommand;
import model.room.commandRoom.ICommandRoom;
import model.room.roomData.Room;
import model.user.commandUser.DisplayAllUserRoomCommand;
import model.user.commandUser.DisplayUserInfoCommand;
import model.user.commandUser.ICommandUser;
import model.user.user.User;
import view.display.Display;

public class CommandControllerMenu {
    private UserManager userManager ;
    private HotelManager hotelManager ;

    public CommandControllerMenu(UserManager userManager, HotelManager hotelManager) {
        this.userManager = userManager;
        this.hotelManager = hotelManager;
    }

    public void displayUserInfoCommand(User user){
        ICommandUser displayUserInfoCommand = new DisplayUserInfoCommand(user);
        userManager.setCommandUser(displayUserInfoCommand);
        userManager.doCommand();
    }
    public void displayAllUserRoomCommand(User user){
        ICommandUser displayAllUserRoomCommand = new DisplayAllUserRoomCommand(user);
        userManager.setCommandUser(displayAllUserRoomCommand);
        userManager.doCommand();
    }
//    public void displayRoomInfoCommand(Room room){
//        ICommandRoom displayRoomInfoCommand = new DisplayRoomInfoCommand(room);
//        //not use yet
//    }
    public void displayAllRoomCommand(Hotel hotel){
        ICommandHotel displayAllRoomCommand = new DisplayAllRoomCommand(hotel);
        hotelManager.setCommandHotel(displayAllRoomCommand);
        hotelManager.doCommand();
    }
    public void displayHotelInfoCommand(Hotel hotel){
        ICommandHotel displayHotelInfoCommand = new DisplayHotelInfoCommand(hotel);
        hotelManager.setCommandHotel(displayHotelInfoCommand);
        hotelManager.doCommand();
    }
}
