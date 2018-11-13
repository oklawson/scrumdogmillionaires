package com.scrumdog.donationtracker.model;



public class AddUserCommand extends AbstractCommand {
    private final User user;

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


}