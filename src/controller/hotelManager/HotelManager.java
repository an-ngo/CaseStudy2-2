package controller.hotelManager;

import model.hotel.commandHotel.ICommandHotel;

public class HotelManager implements IHotelManager{
    private int maxWorkPerDay;
    private ICommandHotel commandHotel;

    public HotelManager() {
        maxWorkPerDay = 5;
    }

    public void setCommandHotel(ICommandHotel commandHotel) {
        this.commandHotel = commandHotel;
    }

    @Override
    public void working() {
        if(maxWorkPerDay>0){
            commandHotel.execute();
            maxWorkPerDay--;
        }
        else {
            System.out.println("--------------------");
            System.out.println("To much work per day");
            System.out.println("--------------------");
        }
    }
}

