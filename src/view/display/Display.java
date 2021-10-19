package view.display;

import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.user.user.User;

public class Display implements IDisplay{
        public HotelManager hotelManager = new HotelManager();
        public UserManager userManager = new UserManager();
        public Display display;
        public Hotel hotel;
        public User user;
}
