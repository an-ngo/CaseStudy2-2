package model.user.user;

import model.bill.Bill;
import model.room.roomData.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements IUser, Serializable {
    private Bill bill;
    private String userName;
    private String password;
    private String name;
    private String age;
    private ArrayList<Room> roomArrayList= new ArrayList<>();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String name, String age) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public Bill getBill() {
        if(bill!=null){
        return bill;

        }else {
            System.err.println("NULL Bill");
            return null;
        }
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
    }





    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public void displayUserInfo() {
        System.out.println(toString());
    }

    @Override
    public void displayAllUserRoom() {
        if(roomArrayList.size()>0){
            for (Room room :
                    this.roomArrayList) {
                System.out.println(room.toString());
            }
        }else System.out.println("U have booked no room");
    }

    public void bookRoomByUser(Room room){
        roomArrayList.add(room) ;
    }
    public void checkoutRoomByUser(Room room){
        roomArrayList.remove(room);
    }
}
