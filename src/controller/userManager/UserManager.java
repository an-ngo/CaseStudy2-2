package controller.userManager;

import model.user.commandUser.ICommandUser;
import model.user.user.User;

import java.util.ArrayList;

public class UserManager implements IUserManager{
    private static UserManager instance;
    private ICommandUser commandUser;
    private ArrayList<User> userArrayList;
    private final String regexString = "^[A-Za-z0-9]{4,8}$";



    private UserManager() {
        userArrayList = new ArrayList<>();
    }

    public static UserManager getInstance(){
        if(instance ==null){
            instance = new UserManager();
        }
        return instance;
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

    public void setCommandUser(ICommandUser commandUser) {
        this.commandUser = commandUser;
    }


    public void doCommand(){
        commandUser.execute();
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
                return user;
            }
        }
        return null;
    }

    @Override
    public User register(String username, String password, String name,String age) {
        for (User user :
                userArrayList) {
            if (user.getUserName().equals(username)) {
                return null;
            }
        }
        User user = new User(username, password, name, age);
        userArrayList.add(user);
        return user;
    }
}
