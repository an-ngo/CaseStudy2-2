package view.main;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.user.user.User;
import view.display.Display;
import view.loadBeforeRun.LoadBeforeRun;

public class Main {
    public static void main(String[] args) {
        UserManager userManager;
        Display display = new Display();
        HotelManager hotelManager = LoadBeforeRun.loadBeforeRun();
        display.displayMenu();

    }
}
