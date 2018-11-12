package com.scrumdog.donationtracker.model;

import android.util.Log;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
//import com.scrumdog.donationtracker.R;

public class UserManagement {
    public final static String DEFAULT_JSON_FILE_NAME = "userdata.json";

    /**
     * the facade maintains references to any required model classes
     */
    private UserManager um;
    //private DonationManager dm;
    //private LocationManager lm;
    private User currentUser = null;

    /**
     * Singleton pattern
     */
    private static final UserManagement instance = new UserManagement();

    /**
     * private constructor for facade pattern
     */
    private UserManagement() {
        um = new UserManager();
        //dm = new DonationManager();
        //lm = new LocationManager();
    }

    /**
     * Singleton pattern accessor for instance
     *
     * @return the one and only one instance of this facade
     */
    public static UserManagement getInstance() { return instance; }

    /**
     * retrieves a list of users
     *
     * @return the list of users
     */
    public List<User> getUsersAsList() {
        return um.getUsers();
    }

    /**
     * retrieves a user via their id
     *
     * @param ID the user's id
     * @return the user
     */
    public User getUserByID(final String ID) {
        return um.getUserByID(ID);
    }

    /**
     * adds a user
     *
     * @param name the user's name
     * @param ID the user's id
     * @param type the user's type
     * @param location the user's location
     * @param password the user's password
     */
    public void addNewUser(final String name, final String ID, final String type,
                           final String location, final String password) {
        um.addUser(name, ID, type, location, password);
    }

    /**
     * logs a user into the application
     *
     * @param ID the user's id
     * @param password the user's password
     * @return true if the user is successfully logged in, false otherwise
     */
    public boolean doLogin(final String ID, final String password) {
        currentUser = um.doLogin(ID, password);
        return (currentUser != null);
    }

    /**
     * gets the instance of the current user
     *
     * @return the current user instance
     */
    public User getCurrentUser() { return currentUser; }

    /**
     * sets the instance of the current user
     *
     * @param user the current user
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    /**
     * adds a user
     *
     * @param user the user to be added to the application
     */
    void addUser(User user) {
        um.addUser(user);
    }

    /**
     * removes a user
     *
     * @param user the user to be removed from the application
     */
    void removeUser(User user) {
        um.removeUser(user);
    }

    /**
     * logs the current user out of the system
     */
    public void doLogout(){
        currentUser = null;
    }

    /**
     * loads the JSON file storing the user data
     * @param file the JSON file
     */
    public void loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automatically
            Gson gson = new Gson();

            um = gson.fromJson(inString, UserManager.class);
            um.regenMap();
            input.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Failed to open/read the buffered reader for json");
        }

    }

    /**
     * save data to the JSON file storing the user data
     * @param file the JSON file
     */
    public void saveJson(File file) {

        try {
            PrintWriter writer = new PrintWriter(file);
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(um);
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
        }

    }

}
