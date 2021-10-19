package model.user.commandUser;

import model.user.user.User;

public class DisplayUserInfo implements ICommandUser{
    User user;

    public DisplayUserInfo(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        user.displayUserInfo();
    }
}
