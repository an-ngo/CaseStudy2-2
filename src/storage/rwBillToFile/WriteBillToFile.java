package storage.rwBillToFile;

import controller.billManager.BillManager;
import controller.userManager.UserManager;
import storage.rwUserToFile.WriteUserToFile;

import java.io.*;

public class WriteBillToFile {
    private static final String path = "bill.txt";
    private static WriteBillToFile writeBillToFile;
    public void setWriteBillToFile(BillManager billManager) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(billManager.getBillArrayList());
        oos.close();
        os.close();


    }
}
