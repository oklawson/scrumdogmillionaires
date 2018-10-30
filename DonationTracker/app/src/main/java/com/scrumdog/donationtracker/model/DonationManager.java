package com.scrumdog.donationtracker.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.Context;

import com.google.gson.Gson;
import com.scrumdog.donationtracker.controllers.DonationEntryActivity;

public class DonationManager {
    /**
     * A list of donations
     */
    private final List<Donation> donations = new ArrayList<>();

    /**
     * A map of donations by Key == name of item Value == Donation object
     *
     * This is marked as transient so it will not be serialized.
     * It is derived from the students collection above, so it does not
     * need to be serialized.
     */
    private transient Map<String, Donation> donationMap = new HashMap<>();

    // do we need this?
    //private Donation currentDonation = null;

    /**
     * add a user to the collection
     * @param comments
     * @param price
     * @param category
     * @param longDescription
     * @param shortDescription
     */
    void addDonation(String comments, String price, String category, String longDescription, String shortDescription, String location) {
        Donation donation = new Donation(comments, price, category, longDescription, shortDescription, location);
        AddDonationCommand dmd = new AddDonationCommand(donation);
        CommandManager commandManager = AbstractCommand.manager;
        commandManager.executeDonationCommand(dmd);
    }


    /**
     * Attempt to login a user
     *
     * @param shortDescription name of donation
     * @return  the Student object is login successful, null otherwise
     */
    Donation registerDonation(String shortDescription) {
        //first lookup the user by their login id
        Donation d = donationMap.get(shortDescription);
        //if that user id not there, return null
        if (d == null) return null;
        System.out.println("donation does not exist");

        //we have a good user at this point, so check their password
//        if (d.checkPassword(password)) return user;
//        //return null if a bad password
//        System.out.println("password incorrect");
        return null;
    }


    /**
     * this is package vis because only model should be asking for this data
     *
     * @return
     */
    List<Donation> getDonations() {
        return donations;
    }

    Donation getDonationByName(String name) {
        return donationMap.get(name);
    }


    /**
     * This should only be called during serialization (reading in).
     *
     * This recomputes the user map which is derived from the user collection.
     *
     */
    void regenMap() {
        if (donationMap != null)
            donationMap.clear();
        else
            donationMap = new HashMap<>();
        for (Donation d : donations) {
            donationMap.put(d.getshortDescription(), d);
            DonationEntryActivity.donations.add(d);
        }
    }

    /**
     * used by command pattern, should be not called otherwise
     *
     * @param donation the donation to add
     */
    void addDonation(Donation donation) {
        donations.add(donation);
        donationMap.put(donation.getshortDescription(), donation);
    }

    void removeDonation(Donation donation) {
        donations.remove(donation);
        donationMap.remove(donation.getshortDescription());
    }

}
