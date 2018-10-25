package com.scrumdog.donationtracker.model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class User implements Serializable {

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsers = Arrays.asList("User", "Location Employee", "Admin");

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsersLocations = Arrays.asList("AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministires", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");

    /** this users name */
    private String name;

    /** this users ID - can be email or id */
    private String ID;

    /** this users type */
    private String userType;

    /** this users location */
    // using String for read/write purposes, will fix later
    private String userLocation;

    /** this users password */
    private String password;

    public static User currentUser;

    /**
     * make a new user
     * @param n name
     * @param id user id
     * @param t user type
     * @param l user location
     * @param p password
     */
    public User(final String n, final String id, final String t, final String l, final String p) {
        name = n;
        ID = id;
        userType = t;
        userLocation = l;
        password = p;
    }

    /**
     * check an entered password for a match
     *
     * @pre pwd is not null
     * @param pwd the password to check
     * @return true is passwords match, false otherwise
     */
    public boolean checkPassword(String pwd) {
        return getPassword().equals(pwd);
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserLocation() { return userLocation; }

    private String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + name + " " + ID + " " + userType + " " + userLocation + " " + password;
    }


    /**
     * Save this class in a custom save format
     *
     * @param writer the file to write this user to
     */
    public void saveAsText(PrintWriter writer) {
        System.out.println("Student saving student: " + name);
        writer.println(name + "\t" + ID + "\t" + userType + "\t" + userLocation + "\t" + password);
    }


    /**
     * This is a static factory method that constructs a student given a text line in the correct format.
     * It assumes that a student is in a single string with each attribute separated by a tab character
     * The order of the data is assumed to be:
     *
     * 0 - name
     * 1 - ID
     * 2 - type
     * 3 - location
     * 4 - password
     *
     * @param line  the text line containing the data
     * @return the user object
     */
    public static User parseEntry(String line) {
        assert line != null;
        String[] tokens = line.split("\t");
        assert tokens.length == 5;
        User u = new User(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);

        return u;
    }
}
