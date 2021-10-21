package controller.billManager;

import model.bill.Bill;
import model.room.roomData.Room;
import model.user.user.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class BillManager implements IBillManager {
    private static BillManager billManager;
    ArrayList<Bill> billArrayList;


    public static BillManager getInstance() {
        if (billManager == null) {
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
        Bill bill = new Bill(user, room);
        addBill(bill);
    }

    public Bill setCheckoutTimeToBill(User user, Room room) {
        if (user.getRoomArrayList().contains(room)) {
            for (Bill bill :
                    billArrayList) {
                if (bill.getUser().equals(user) && bill.getRoom().equals(room) && bill.getCheckoutTime() == null) {
                    bill.setCheckoutTime(LocalDate.now().plusDays(1));
                    bill.setMoney();
                    return bill;
                }
            }
        }
        return null;
    }
    public ArrayList<Bill> getAllBillOfUser(User user){
            ArrayList<Bill> billOfUser = new ArrayList<>();
        for (Bill bill :
                billArrayList) {
            if(bill.getUser().getUserName().equals(user.getUserName()) && bill.getUser().getPassword().equals(user.getPassword()) ){
                        billOfUser.add(bill);
            }
        }return billOfUser;
    }

}
