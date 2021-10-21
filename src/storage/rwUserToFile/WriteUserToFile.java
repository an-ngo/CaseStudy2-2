package storage.rwUserToFile;

import controller.userManager.UserManager;
import model.user.user.User;

import java.io.*;

public class WriteUserToFile implements IOUser {
    private static final String path = "user.txt";
    private static WriteUserToFile instance;

    private WriteUserToFile() {
    }
    public static WriteUserToFile getInstance(){
        if (instance == null) {
            instance = new WriteUserToFile();
        }
        return instance;
    }

    public void writeUserToFile(UserManager userManager) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }else if(file.canRead()){
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(userManager.getUserArrayList());
            oos.close();
            os.close();
        }
    }

}
