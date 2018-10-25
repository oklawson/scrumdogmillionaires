package com.scrumdog.donationtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.lang.String.*;

//implements Parcelable
public class User {

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsers = Arrays.asList("User", "Location Employee", "Admin");

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsersLocations = Arrays.asList("AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministires", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");

    /** this users ID - can be email or id */
    private String _ID;

    /** this users name */
    private String _name;

    /** this users type */
    private String _userType;

    /** this users location */
    private String _userLocation;

    /** this users password */
    private String _password;

    /** the list of all registered users */
    public static ArrayList<User> _users = new ArrayList<>();

    public static User currentUser;


    /* **********************
     * Getters and setters
     */
    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    //no setter for this.  id is a read only field
    public String getID() { return _ID; }
    public void setID(String ID) { _ID = ID; }

    public String getUserType() {return _userType; }
    public void set_userType(String userType) { _userType = userType; }

    public String getPassword() {return _password; }
    public void setPassword(String password) { _password = password; }

    public String getUserLocation() {return _userLocation; }
    public void setUserLocation(String userLocation) { _userLocation = userLocation; }

    /**
     * Lookup a user type based on its code.  Returns the postion of that
     * user type in the array
     *
     * @param code the user type to find
     *
     * @return the index of the array that corresponds to the submitted major
     */
//    public static int findPosition(String code) {
//        int i = 0;
//        while (i < legalUsers.size()) {
//            if (code.equals(legalUsers.get(i))) return i;
//            ++i;
//        }
//        return 0;
//    }


    /**
     * Make a new user
     * @param name      the user's name
     * @param ID    the user's id
     * @param password  the user's password
     * @param userType  the user's type
     * @param userLocation the user's location
     */
    public User(String name, String ID, String password, String userType, String userLocation) {
        _name = name;
        _ID = ID;
        _password = password;
        _userType = userType;
        _userLocation = userLocation;
        _users.add(this);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public User() {
        this("enter new name" , "NA", "NA", "NA", "NA");
    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return _name + " ," + _ID + " ," + _userType + " ," + _userLocation;
    }

    public static void setCurrentUser(User curr) {
        currentUser = curr;
    }
    public static User getCurrentUser() {
        return currentUser;
    }

}






