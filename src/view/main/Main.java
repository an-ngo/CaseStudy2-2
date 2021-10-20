package view.main;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.user.user.User;
import storage.rwHotelToFile.ReadHotelFromFile;
import view.display.Display;
import view.loadBeforeRun.LoadBeforeRun;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        HotelManager hotelManager = LoadBeforeRun.loadBeforeRun();
        Display display = new Display(hotelManager);
//        ReadHotelFromFile readHotelFromFile = new ReadHotelFromFile();
//        try {
//            Hotel hotel = readHotelFromFile.readHotelFromFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        display.displayMenu();

    }
}
