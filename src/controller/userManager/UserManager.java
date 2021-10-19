package controller.userManager;

import model.user.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager implements IUserManager{
    private ArrayList<User> userArrayList;

    public UserManager() {
        userArrayList = new ArrayList<>();
    }

    public UserManager(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "userArrayList=" + userArrayList +
                '}';
    }

    @Override
    public User login(String username, String password) {
        for (User user:
             userArrayList) {
            if(user.getUserName().equals(username)&&
               user.getPassword().equals(password)){
                System.out.println("--------------------");
                System.out.println("Login success");
                System.out.println("--------------------");
                return user;
            }
        }
        System.out.println("Wrong username or password");
        return null;
    }

    @Override
    public User register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ur username");
        String username = scanner.nextLine();
        System.out.println("Input ur password");
        String password = scanner.nextLine();
        System.out.println("Input ur name");
        String name = scanner.nextLine();
        System.out.println("Input ur age");
        String age = scanner.nextLine();
        if(Integer.parseInt(age)<18){
            System.err.println("Not enough age for you");
            return null;
        }
        else {
            User user = new User(username, password, name, age);
            return user;
        }
    }
}
