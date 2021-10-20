package model.user.commandUser;

import model.user.user.User;

public class DisplayAllUserRoomCommand implements ICommandUser{
    User user;

    public DisplayAllUserRoomCommand(User user){
        this.user=user;
    }

    @Override
    public void execute() {
        user.displayAllUserRoom();
    }
}
