package model.bill.commandBill;

import controller.billManager.BillManager;

public class DisplayAllBillCommand implements ICommandBill{
    private BillManager billManager;

    public DisplayAllBillCommand(BillManager billManager) {
        this.billManager = billManager;
    }


}
