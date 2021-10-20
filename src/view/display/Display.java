package view.display;
import controller.billManager.BillManager;
import controller.commandControllerMenu.CommandMenu;
import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;
import model.user.user.User;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Display {
        public HotelManager hotelManager = HotelManager.getInstance();
        public UserManager userManager = UserManager.getInstance();
        public BillManager billManager = BillManager.getInstance();
        //public Display display;
        public Hotel hotel = hotelManager.getHotel();
        public User user = new User();
        CommandMenu commandMenu = new CommandMenu(this);



        public Display(HotelManager hotelManager) {
                this.hotelManager = hotelManager;
                this.hotel = hotelManager.getHotel();
        }

        public Display(HotelManager hotelManager, UserManager userManager, BillManager billManager) {
                this.hotelManager = hotelManager;
                this.userManager = userManager;
                this.billManager = billManager;
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
                String regexString = "^[A-Za-z0-9]{4,8}$";
                Pattern pattern = Pattern.compile(regexString);
                Matcher matcher = pattern.matcher(userName);
                if(!matcher.matches()){
                        System.out.println("UserName must have 4 - 8 character with no special item");
                        displayMenu();
                }else{
                        this.user = userManager.register(userName, password,name , age);
                        if(this.user==null){
                                System.out.println("u must have more than 18 to register this LoveHotel");
                                displayMenu();
                        }else System.out.println("Register success");

                        commandMenu.displayUserInfoCommand(this.user);

                }

        }

        public void displayMenu() {
                System.out.println("Input your choice");
                System.out.println("1: Login");
                System.out.println("2: Register");
                System.out.println("3: Quit");
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                switch (input){
                        case 1:
                                this.loginFunction();
                                displaySecondMenu();
                                break;
                        case 2:
                                this.registerFunction();
                                displaySecondMenu();
                                break;
                        case 3:
                                System.out.println("Logout.......");
                                break;
                        default:
                                System.out.println("Wrong input");
                                displayMenu();
                }
        }

        public void displaySecondMenu() {
                System.out.println("Input your choice");
                System.out.println("1: Show all Room");
                System.out.println("2: view Hotel info");
                System.out.println("3: Show all your room in this hotel");
                System.out.println("4: Book Room");
                System.out.println("5: Check out Room / return Room");
                System.out.println("6: Show ur information");
                System.out.println("7: Back to previous");

                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                switch (input){
                        case 1:
                                commandMenu.displayAllRoomCommand(this.hotel);
                                displaySecondMenu();
                                break;
                        case 2:
                                commandMenu.displayHotelInfoCommand(this.hotel);
                                displaySecondMenu();
                                break;
                        case 3:
                                commandMenu.displayAllUserRoomCommand(this.user);
                                displaySecondMenu();
                                break;
                        case 4:
                                System.out.println("-----------------------------------");
                                commandMenu.displayAllRoomCommand(this.hotel);
                                System.out.println("Input Room's serial to book");
                                Scanner scanner2 = new Scanner(System.in);
                                int serial = scanner2.nextInt();
                                Room room = hotelManager.getRoomBySerial(serial);
                                if(room != null){
                                        room.setReady(false);
                                        billManager.addBill(user,room);
                                        user.getRoomArrayList().add(room);
                                }else{
                                        System.out.println("Input wrong serial");
                                }
                                System.out.println("-----------------------------------");
                                displaySecondMenu();
                                break;
                        case 5:
                                System.out.println("-----------------------------------");
                                commandMenu.displayAllUserRoomCommand(this.user);
                                System.out.println("Input Room's serial to remove");
                                Scanner scanner1 = new Scanner(System.in);
                                int serial2 = scanner1.nextInt();
                                Room room2 = hotelManager.getRoomBySerial(serial2);
                                if(room2!=null){
                                        room2.setReady(true);
                                        user.getRoomArrayList().remove(room2);
                                }else{
                                        System.out.println("Input wrong serial");
                                        System.out.println("-----------------------------------");
                                }
                                displaySecondMenu();
                                break;

                        case 6:
                                System.out.println("-----------------------------------");
                                commandMenu.displayUserInfoCommand(this.user);
                                displaySecondMenu();
                                break;

                        case 7:
                                System.out.println("-----------------------------------");
                                System.out.println("Back to 1st menu");
                                displayMenu();
                                break;
                        default:
                                System.out.println("-----------------------------------");
                                System.out.println("Wrong input");
                                displaySecondMenu();
                }
        }

}
