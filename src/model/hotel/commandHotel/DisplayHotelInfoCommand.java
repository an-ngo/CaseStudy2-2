package model.hotel.commandHotel;

import model.hotel.hotelData.Hotel;

public class DisplayHotelInfoCommand implements ICommandHotel{
    Hotel hotel = new Hotel();

    public DisplayHotelInfoCommand(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void execute() {
        hotel.displayHotelInfo();
    }
}
