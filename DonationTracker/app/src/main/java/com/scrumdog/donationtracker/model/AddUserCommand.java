package com.scrumdog.donationtracker.model;


public class AddUserCommand extends AbstractCommand {
    User user;

    public AddUserCommand(User u) {
        user = u;
    }

    @Override
    public boolean execute() {
        UserManagement umt = UserManagement.getInstance();
        umt.addUser(user);
        return true;
    }

    @Override
    public boolean undo() {
        UserManagement umf = UserManagement.getInstance();
        umf.removeUser(user);
        return true;
    }


}