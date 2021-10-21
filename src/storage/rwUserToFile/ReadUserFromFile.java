package storage.rwUserToFile;

import model.user.user.User;

import java.io.*;
import java.util.ArrayList;

public class ReadUserFromFile {
    private static final String path = "user.txt";
    private static ReadUserFromFile instance;

    private ReadUserFromFile() {
    }

    public static ReadUserFromFile getInstance(){
        if (instance == null) {
            instance = new ReadUserFromFile();
        }
        return instance;
    }

    public ArrayList<User> readUserFromFile() throws IOException, ClassNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Create new UserFile");
            return new ArrayList<>();
        }else{
            if(file.canRead()){
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);
                ArrayList<User> userArrayList = (ArrayList<User>) ois.readObject();
                ois.close();
                is.close();
                return userArrayList;
            }else{
                System.out.println("User is Null");
                return new ArrayList<>();
            }
        }

    }
}
