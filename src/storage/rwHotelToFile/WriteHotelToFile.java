package storage.rwHotelToFile;

import model.hotel.hotelData.Hotel;

import java.io.*;

public class WriteHotelToFile {
    private final String path = "hotel.txt";
    private static WriteHotelToFile instance;

    private WriteHotelToFile() {
    }

    public static WriteHotelToFile getInstance(){
        if(instance==null){
            instance = new WriteHotelToFile();
        }
        return instance;
    }

    public void writeHotelToFile(Hotel hotel) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(hotel);
    }
}
