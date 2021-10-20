package storage.rwHotelToFile;

import model.hotel.hotelData.Hotel;

import java.io.*;

public class ReadHotelFromFile {
    private final String path = "hotel.txt";
    private ReadHotelFromFile readHotelFromFile;

    public ReadHotelFromFile getInstance(){
        if(this.readHotelFromFile==null){
            this.readHotelFromFile = new ReadHotelFromFile();
        }
        return this.readHotelFromFile;
    }

    public Hotel readHotelFromFile() throws IOException, ClassNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        Hotel hotel = (Hotel) ois.readObject();
        ois.close();
        is.close();
        return hotel;
    }


}