package com.scrumdog.donationtracker.model;

public class Admin extends User {
    /**
     * make a new user
     *
     * @param n  name
     * @param id user id
     * @param t  user type
     * @param l  user location
     * @param p  password
     */
    public Admin(String n, String id, String t, String l, String p) {
        super(n, id, t, l, p);
    }
}
