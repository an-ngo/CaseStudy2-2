package controller.billManager;

import model.bill.Bill;
import model.room.roomData.Room;
import model.user.user.User;

import java.util.ArrayList;

public class BillManager implements IBillManager{
    private static BillManager billManager;
    ArrayList<Bill> billArrayList;



    public BillManager(BillManager billManager) {
        this.billManager = billManager;
    }

    public static BillManager getInstance(){
        if(billManager==null){
            billManager = new BillManager();
        }
        return billManager;
    }

    public ArrayList<Bill> getBillArrayList() {
        return billArrayList;
    }

    public void setBillArrayList(ArrayList<Bill> billArrayList) {
        this.billArrayList = billArrayList;
    }

    @Override
    public void addBill(Bill bill) {
        billArrayList.add(bill);
    }


    private BillManager() {
        billArrayList = new ArrayList<>();
    }

    public void addBill(User user, Room room) {
        Bill bill = new Bill(user);
        bill.getRoomArrayList().add(room);
        billArrayList.add(bill);
    }
}
