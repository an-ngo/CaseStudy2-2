package controller.userManager;

import model.user.user.User;

public interface IUserManager {
    public User login(String username, String password);
    public User register(String username, String password, String name,String age);
}
