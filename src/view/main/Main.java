package view.main;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.user.user.User;
import view.display.Display;
import view.loadBeforeRun.LoadBeforeRun;

public class Main implements IMain{
    public static void main(String[] args) {
        UserManager userManager;
        HotelManager hotelManager;
        Display display = new Display();
        LoadBeforeRun.loadBeforeRun(display);
        //display.displayMenu();

    }
}
