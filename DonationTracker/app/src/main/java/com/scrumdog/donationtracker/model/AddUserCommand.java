package com.scrumdog.donationtracker.model;


public class AddUserCommand extends AbstractCommand {
    private User user;

    /**
     * make a new user
     *
     * @param u the user added to the app
     */
    AddUserCommand(User u) {
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