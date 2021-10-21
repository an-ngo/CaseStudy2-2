package view.main;

import controller.billManager.BillManager;
import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.bill.Bill;
import model.hotel.hotelData.Hotel;
import model.user.user.User;
import storage.rwBillToFile.ReadBillFromFile;
import storage.rwBillToFile.WriteBillToFile;
import storage.rwHotelToFile.ReadHotelFromFile;
import storage.rwHotelToFile.WriteHotelToFile;
import storage.rwUserToFile.ReadUserFromFile;
import storage.rwUserToFile.WriteUserToFile;
import view.display.Display;
import view.loadBeforeRun.LoadBeforeRun;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        HotelManager hotelManager = HotelManager.getInstance();
        BillManager billManager = BillManager.getInstance();

        ReadHotelFromFile readHotelFromFile = ReadHotelFromFile.getInstance();
        WriteHotelToFile writeHotelToFile = WriteHotelToFile.getInstance();
        ReadUserFromFile readUserFromFile = ReadUserFromFile.getInstance();
        WriteUserToFile writeUserToFile = WriteUserToFile.getInstance();
        ReadBillFromFile readBillFromFile = ReadBillFromFile.getInstance();
        WriteBillToFile writeBillToFile = WriteBillToFile.getInstance();

        //Prepare before Display Menu
        try {
            ArrayList<User> userArrayList = readUserFromFile.readUserFromFile();
            ArrayList<Bill> billArrayList = readBillFromFile.readBillFromFile();
            Hotel hotel = readHotelFromFile.readHotelFromFile();

            if(hotel !=null) {
                hotelManager.setHotel(hotel);
                hotelManager.setRoomArrayList(hotel.getRoomArrayList());
            }else {
                hotelManager = LoadBeforeRun.loadBeforeRun();
            }

            billManager.setBillArrayList(billArrayList);
            userManager.setUserArrayList(userArrayList);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            hotelManager = LoadBeforeRun.loadBeforeRun();
        }

        //body project
        Display display = new Display(hotelManager, userManager,billManager);
        display.displayMenu();

        //Function before end Project/Menu
        try {
            writeHotelToFile.writeHotelToFile(display.hotel);

            UserManager userManagerAfter = display.userManager;
            writeUserToFile.writeUserToFile(userManagerAfter);

            BillManager billManagerAfter = display.billManager;
            writeBillToFile.setWriteBillToFile(billManagerAfter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
