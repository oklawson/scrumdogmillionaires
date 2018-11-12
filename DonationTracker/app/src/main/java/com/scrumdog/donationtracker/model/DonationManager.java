package com.scrumdog.donationtracker.model;

//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.io.File;
//import java.io.*;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import android.content.Context;
//
//import com.google.gson.Gson;
import com.scrumdog.donationtracker.controllers.DonationEntryActivity;

class DonationManager {
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
     * @param comments comments of the donation
     * @param price of the donation
     * @param category certain category of the donation
     * @param longDescription detailed description of the donation
     * @param shortDescription quick description of the donation
     */
    public void addDonation(String comments, String price, String category, String longDescription, String shortDescription, String location) {
        Donation donation = new Donation(comments, price, category, longDescription, shortDescription, location);
        AddDonationCommand dmd = new AddDonationCommand(donation);
        CommandManager commandManager = AbstractCommand.manager;
        commandManager.executeDonationCommand(dmd);
    }


    /**
     * Attempt to register a donation
     *
     * @param shortDescription name of donation
     * @return  the Donation object exists successful, null otherwise
     */
    Donation registerDonation(String shortDescription) {
        //first lookup the donation by the donation shortDescription
        Donation d = donationMap.get(shortDescription);
        //if that donation shortDescription not there, return null
        if (d == null) {
            System.out.println("donation does not exist");
            return null;
        }
        return d;
    }


//    /**
//     * this is package vis because only model should be asking for this data
//     *
//     * @return list of donations
//     */
//    List<Donation> getDonations() {
//        return donations;
//    }
//
//    Donation getDonationByName(String name) {
//        return donationMap.get(name);
//    }


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
            donationMap.put(d.getShortDescription(), d);
            DonationEntryActivity.donations.add(d);
        }
    }

    /**
     * used by command pattern, should be not called otherwise
     *
     * @param donation the donation to add
     */
    public void addDonation(Donation donation) {
        donations.add(donation);
        donationMap.put(donation.getShortDescription(), donation);
    }

    /**
     * method that removes donation from donations map and array
     *
     * @param donation the inputted donation
     */
    public void removeDonation(Donation donation) {
        donations.remove(donation);
        donationMap.remove(donation.getShortDescription());
    }

}
