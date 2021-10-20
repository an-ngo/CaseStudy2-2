package view.display;
import controller.billManager.BillManager;
import controller.commandControllerMenu.CommandMenu;
import controller.hotelManager.HotelManager;
import controller.userManager.UserManager;
import model.hotel.commandHotel.AddNewRoomCommand;
import model.hotel.commandHotel.DisplayAllRoomCommand;
import model.hotel.commandHotel.DisplayHotelInfoCommand;
import model.hotel.commandHotel.ICommandHotel;
import model.hotel.hotelData.Hotel;
import model.room.roomData.Room;
import model.user.commandUser.DisplayAllUserRoomCommand;
import model.user.commandUser.DisplayUserInfoCommand;
import model.user.commandUser.ICommandUser;
import model.user.user.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Display {
        public HotelManager hotelManager = HotelManager.getInstance();
        public UserManager userManager = UserManager.getInstance();
        public BillManager billManager = BillManager.getInstance();
        public Display display;
        public Hotel hotel = hotelManager.getHotel();
        public User user = new User();
        CommandMenu commandMenu = new CommandMenu(this);
        private final String regexString = "^[A-Za-z0-9]{4,8}$";

        ICommandHotel addNewRoomCommand = new AddNewRoomCommand(this.hotel);
        ICommandHotel displayAllRoomCommand = new DisplayAllRoomCommand(this.hotel);
        ICommandHotel displayHotelInfoCommand = new DisplayHotelInfoCommand(this.hotel);

        ICommandUser displayAllUserRoomCommand = new DisplayAllUserRoomCommand(this.user);
        ICommandUser displayUserInfoCommand = new DisplayUserInfoCommand(this.user);

        public Display(HotelManager hotelManager) {
                this.hotelManager = hotelManager;
                this.hotel = hotelManager.getHotel();
        }

        public void displayHotelInfo(Hotel hotel) {
                System.out.println("--------------------------");
                System.out.println(hotel.toString());
                System.out.println("--------------------------");

        }



        public void displayRoomInfo(int index) {
                String roomInfo = hotelManager.getRoomArrayList().get(index).toString();
                System.out.println(roomInfo);
        }



        public void displayAllRoom() {
                hotelManager.setCommandHotel(displayAllRoomCommand);
                hotelManager.doCommand();

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
                this.displayMenu();
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

                        this.displaySecondMenu();
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
                                break;
                        case 2:
                                this.registerFunction();
                                break;
                        case 3:

                                System.exit(0);
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
                System.out.println("5: Show ur information");
                System.out.println("6: Back to previous");

                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                switch (input){
                        case 1:
//                                hotelManager.setCommandHotel(displayAllRoomCommand);
//                                hotelManager.doCommand();
//                                displaySecondMenu();
                                commandMenu.displayAllRoomCommand(this.hotel);
                        case 2:
//                                hotelManager.setCommandHotel(displayHotelInfoCommand);
//                                hotelManager.doCommand();
                                commandMenu.displayHotelInfoCommand(this.hotel);
                                displaySecondMenu();
                        case 3:
//                                userManager.setCommandUser(displayAllUserRoomCommand);
//                                userManager.doCommand();
                                commandMenu.displayAllUserRoomCommand(this.user);
                                displaySecondMenu();
                        case 4:
                                System.out.println("Input Room's index");
                                Scanner scanner2 = new Scanner(System.in);
                                try{
                                        int index = scanner2.nextInt();
                                        Room room = hotelManager.getRoomArrayList().get(index);
                                        billManager.addBill(user,room);
                                }catch (Exception e){
                                        System.out.println("wrong input");
                                }finally {
                                        displaySecondMenu();
                                }
                        case 5:
//                                ICommandUser displayUserInfoCommand = new DisplayUserInfoCommand(this.user);
//                                userManager.setCommandUser(displayUserInfoCommand);
//                                userManager.doCommand();
                                commandMenu.displayUserInfoCommand(this.user);
                                displaySecondMenu();

                        case 6:
                                displayMenu();
                        default:
                                System.out.println("Wrong input");
                                displaySecondMenu();
                }
        }

//        public void displayThirdMenu() {
//                System.out.println("Input your choice");
//                System.out.println("1: show all room info");
//                System.out.println("4: Back to previous Menu");
//
//                Scanner scanner = new Scanner(System.in);
//                int input = scanner.nextInt();
//                switch (input){
//                        case 1:
//                                hotel.showAllRoom();
//                                displayThirdMenu();
//                        case 2:
//                                System.out.println("Input index of room u want");
//                                int index = scanner.nextInt();
//                                user.addBookedRoomToUser(hotel.getRoomList().get(index));
//                                System.out.println("success book room");
//                                displayThirdMenu();
//                        case 3:
//                                user.showALlRoomOfUser();
//                                displayThirdMenu();
//                        case 4:
//                                displaySecondMenu();
//                        default:
//                                System.out.println("Wrong input");
//                                displayThirdMenu();
//
//                }
//        }


}
