package storage.rwBillToFile;

import model.bill.Bill;
import model.user.user.User;

import java.io.*;
import java.util.ArrayList;

public class ReadBillFromFile {
    private static final String path = "bill.txt";
    private static ReadBillFromFile instance;

    private ReadBillFromFile() {
    }

    public static ReadBillFromFile getInstance(){
        if(instance == null){
            instance = new ReadBillFromFile();
        }
        return instance;
    }

    public ArrayList<Bill> readBillFromFile() throws IOException, ClassNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Create new BillFile");
            return new ArrayList<>();
        }
        else{
            if(file.canRead()){
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);
                ArrayList<Bill> billArrayList = (ArrayList<Bill>) ois.readObject();
                ois.close();
                is.close();
                return billArrayList;
            }else{
                System.out.println("Bill is null");
                return new ArrayList<>();
            }
        }


    }
}
