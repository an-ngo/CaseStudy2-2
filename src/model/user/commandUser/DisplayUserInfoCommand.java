package model.user.commandUser;

import model.user.user.User;

public class DisplayUserInfoCommand implements ICommandUser{
    User user;

    public DisplayUserInfoCommand(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        user.displayUserInfo();
    }
}
