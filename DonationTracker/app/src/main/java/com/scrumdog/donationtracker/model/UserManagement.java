package com.scrumdog.donationtracker.model;

import android.util.Log;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import com.scrumdog.donationtracker.R;


public class UserManagement {
    public final static String DEFAULT_JSON_FILE_NAME = "data.json";

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
    private static UserManagement instance = new UserManagement();

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
     *
     * @return the one and only one instance of this facade
     */
    public static UserManagement getInstance() { return instance; }

    public List<User> getStudentsAsList() {
        return um.getUsers();
    }

    public User getUserByID(final String ID) {
        return um.getUserByID(ID);
    }

    public void addNewUser(final String name, final String ID, final String type,
                           final String location, final String password) {
        um.addUser(name, ID, type, location, password, new File("userdata.json"));
    }

    public boolean doLogin(final String ID, final String password) {
        currentUser = um.doLogin(ID, password);
        System.out.println(currentUser);
        return (currentUser != null);
    }

    public User getCurrentUser() { return currentUser; }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void doLogout(){
        currentUser = null;
    }

    // add write to text file
    public boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automagically
            Gson gson = new Gson();

            um = gson.fromJson(inString, UserManager.class);

            input.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Failed to open/read the buffered reader for json");
            return false;
        }

        return true;

    }

    public boolean saveJson(File file) {

        try {
            PrintWriter writer = new PrintWriter(file);
            /*
                We are using the Google Gson library to make things easy.  You will need to add the
                following line to your gradle file so the proper dependencies are set up:
                compile 'com.google.code.gson:gson:2.3'

                Gson, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.


             */
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(um);
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
            return false;
        }

        return true;
    }

}
