package view.display;
import controller.billManager.BillManager;
import controller.commandControllerMenu.CommandControllerMenu;
import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.bill.Bill;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;
import model.user.user.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Display {
        public HotelManager hotelManager = HotelManager.getInstance();
        public UserManager userManager = UserManager.getInstance() ;
        public BillManager billManager = BillManager.getInstance();
        //public Display display;
        public Hotel hotel ;
        public User user = new User();
        CommandControllerMenu commandControllerMenu = new CommandControllerMenu(userManager,hotelManager);




        public Display(HotelManager hotelManager, UserManager userManager, BillManager billManager) {
                this.hotelManager = hotelManager;
                this.userManager = userManager;
                this.billManager = billManager;
                this.hotel = hotelManager.getHotel();
        }



        public void firstMenu() {
                System.out.println("Input your choice");
                System.out.println("1: Login");
                System.out.println("2: Register");
                System.out.println("0: Quit");
//                Menu1.displayMenu1();
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                switch (input){
                        case 1:
                                this.loginFunction();
                                secondMenu();
                                break;
                        case 2:
                                this.registerFunction();
                                secondMenu();
                                break;
                        case 0:
                                System.out.println("Logout.......");
                                break;
                        default:
                                System.out.println("Wrong input");
                                firstMenu();
                }
        }

        public void secondMenu() {

                System.out.println("-----------------------------------");
                System.out.println("Input your choice");
                System.out.println("1: Show all Room");
                System.out.println("2: view Hotel info");
                System.out.println("3: Show all your room in this hotel");
                System.out.println("4: Book Room");
                System.out.println("5: Check out Room / return Room");
                System.out.println("6: Show ur information");
                System.out.println("7: Show all your Bill");
                System.out.println("0: Back to previous");
//                Menu2.displayMenu2();
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                switch (input){
                        case 1:
                                commandControllerMenu.displayAllRoomCommand(this.hotel);
                                secondMenu();
                                break;
                        case 2:
                                commandControllerMenu.displayHotelInfoCommand(this.hotel);
                                secondMenu();
                                break;
                        case 3:
                                commandControllerMenu.displayAllUserRoomCommand(this.user);
                                secondMenu();
                                break;
                        case 4:
                                commandControllerMenu.displayAllRoomCommand(this.hotel);
                                chooseAndBookRoomByUser();
                                secondMenu();
                                break;
                        case 5:
                                commandControllerMenu.displayAllUserRoomCommand(this.user);
                                ChooseAndCheckoutRoomByUser();
                                secondMenu();
                                break;

                        case 6:
                                commandControllerMenu.displayUserInfoCommand(this.user);
                                secondMenu();
                                break;
                        case 7:
                                displayAllBillByUser();
                                secondMenu();
                                break;
                        case 0:
                                System.out.println("Back to 1st menu.....");
                                firstMenu();
                                break;
                        default:
                                System.out.println("Wrong input");
                                secondMenu();
                }
        }

        private void displayAllBillByUser() {
                ArrayList<Bill> billOfUser = billManager.getAllBillOfUser(user);
                if(billOfUser!=null){
                        System.out.println("All bill: ");
                        for (Bill bill :
                                billOfUser) {
                                System.out.println(bill);
                        }
                }else System.out.println("U have no Bill in this Hotel");
        }

        private void ChooseAndCheckoutRoomByUser() {
                System.out.println("Input Room's serial to remove");
                Scanner scanner1 = new Scanner(System.in);
                int serial2 = scanner1.nextInt();
                Room room2 = hotelManager.getRoomBySerial(serial2);
                if(room2!=null){
                        room2.setReady(true);
                        Bill bill = billManager.setCheckoutTimeToBill(user,room2);
                        user.checkoutRoomByUser(room2);
                        System.out.println("Your bill is : "+bill.getMoney());
                }else{
                        System.out.println("Input wrong serial");
                }
        }

        private void chooseAndBookRoomByUser() {
                System.out.println("0: Back to previous");
                System.out.println("Input Room's serial to book");
                Scanner scanner2 = new Scanner(System.in);
                int serial = scanner2.nextInt();
                if(serial==0){return;}
                Room room = hotelManager.getRoomBySerial(serial);
                if(room!=null){
                        if(room.isReady()){
                                room.setReady(false);
                                Bill bill = new Bill(user,room);
                                billManager.addBill(bill);
                                user.bookRoomByUser(room);
                                System.out.println("Book successfully");
                        }else System.out.println("Room is not Ready");
                }else{
                        System.out.println("Input wrong serial");
                }
        }

        public void loginFunction() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please login your account");
                System.out.println("UserName");
                String userName = scanner.nextLine();
                System.out.println("Password");
                String password = scanner.nextLine();

                this.user = userManager.login(userName,password);
                if(this.user==null){
                        System.out.println("Wrong username or password");

                }
                else System.out.println("Success Login");
        }

        public void registerFunction() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please input your account");
                System.out.println("Input UserName");
                String userName = scanner.nextLine();
                System.out.println("Input Password");
                String password = scanner.nextLine();
                System.out.println("Input name");
                String name = scanner.nextLine();
                System.out.println("Input age");
                String age = scanner.nextLine();
                //improve here...............................................
                String regexString = "^[A-Za-z0-9]{4,12}$";
                Pattern pattern = Pattern.compile(regexString);
                Matcher matcher = pattern.matcher(userName);
                if(!matcher.matches()){
                        System.out.println("UserName must have 4 - 12 character with no special item");
                        firstMenu();
                }else{
                        user = userManager.register(userName, password,name , age);
                        if(user==null){
                                System.out.println("Same username with another account");
                                firstMenu();
                        }else System.out.println("Register success");

                        commandControllerMenu.displayUserInfoCommand(this.user);

                }

        }
}
