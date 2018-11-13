package com.scrumdog.donationtracker.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable {

    /** a demonstration of using something other than an enum for holding choices */
    public static final List<String> legalUsers = Arrays.asList("User", "Location Employee", "Admin");

    /** a demonstration of using something other than an enum for holding choices */
    public static final List<String> legalUsersLocations = Arrays.asList("AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministries", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");

    /** this users name */
    private final String name;

    /** this users ID - can be email or id */
    private final String ID;

    /** this users type */
    private final String userType;

    /** this users location */
    // using String for read/write purposes, will fix later
    private final String userLocation;

    /** this users password */
    private final String password;


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
     *  check an entered password for a match
     *
     * @param pwd put in the password
     * @return if correct or not
     */
    public boolean checkPassword(String pwd) {
        return getPassword().equals(pwd);
    }

    /**
     * get user's name
     *
     * @return user's name
     */
    private String getName() {
        return name;
    }

    /**
     * get user's id
     *
     * @return user's id
     */
    public String getID() {
        return ID;
    }

    /**
     * get user's type
     *
     * @return user's type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * get user's location
     *
     * @return user's location
     */
    public String getUserLocation() { return userLocation; }

    /**
     * get user's password
     *
     * @return user's password
     */
    private String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + name + " " + ID + " " + userType + " " + userLocation + " " + password;
    }


//    /**
//     * Save this class in a custom save format
//     *
//     * @param writer the file to write this user to
//     */
//    public void saveAsText(PrintWriter writer) {
//        System.out.println("User saving user: " + name);
//        writer.println(name + "\t" + ID + "\t" + userType + "\t" + userLocation + "\t" + password);
//    }


    /**
     * This is a static factory method that constructs a user given a text line in the correct format.
     * It assumes that a user is in a single string with each attribute separated by a tab character
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
        if (line == null) {
            System.out.println("line is null");
            return null;
        }
//        assert line != null;
        String[] tokens = line.split("\t");
        if (tokens.length != 5) {
            System.out.println("incorrect number of tokens");
            return null;
        }
//        assert tokens.length == 5;
        User u = new User(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
        System.out.println("parsed user");
        return u;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User o = (User) other;
        return this.name.equals(o.getName()) && this.ID.equals(o.getID())
                && this.userType.equals(o.getUserType()) && this.userLocation.equals(o.getUserLocation())
                && this.password.equals(o.getPassword());
    }

}
