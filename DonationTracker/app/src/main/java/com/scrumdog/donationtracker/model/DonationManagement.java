package com.scrumdog.donationtracker.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DonationManagement {

    public final static String DEFAULT_JSON_FILE_NAME = "donationdata.json";

    /**
     * the facade maintains references to any required model classes
     */
    private DonationManager dm;
    //private DonationManager dm;
    //private LocationManager lm;
    private Donation currentDonation = null;

    /**
     * Singleton pattern
     */
    private static DonationManagement instance = new DonationManagement();

    /**
     * private constructor for facade pattern
     */
    private DonationManagement() {
        dm = new DonationManager();
        //dm = new DonationManager();
        //lm = new LocationManager();
    }

    /**
     * Singleton pattern accessor for instance
     *
     *
     * @return the one and only one instance of this facade
     */
    public static DonationManagement getInstance() { return instance; }

    public List<Donation> getDonationsAsList() {
        return dm.getDonations();
    }

    public Donation getDonationByName(final String name) {
        return dm.getDonationByName(name);
    }

    public void addNewDonation(final String shortDescription, final String dollarValue, final
        String category, final String fullDescription, final String comments) {
        dm.addDonation(shortDescription, dollarValue, category, fullDescription, comments);
    }

    public boolean registerDonation(final String shortDescription) {
        currentDonation = dm.registerDonation(shortDescription);
        return (currentDonation != null);
    }

    public Donation getCurrentDonation() { return currentDonation; }

    public void setCurrentDonation(Donation d) {
        this.currentDonation = d;
    }

    void addDonation(Donation d) {
        dm.addDonation(d);
    }

    void removeDonation(Donation donation) {
        dm.removeDonation(donation);
    }

//    public void doLogout(){
//        currentUser = null;
//    }

    // add write to text file
    public boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automagically
            Gson gson = new Gson();

            dm = gson.fromJson(inString, DonationManager.class);
            dm.regenMap();
            input.close();
        } catch (IOException e) {
            Log.e("DonationManagementFacade", "Failed to open/read the buffered reader for json");
            return false;
        }

        return true;

    }

    public boolean saveJson(File file) {

        try {
            PrintWriter writer = new PrintWriter(file);
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(dm);
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("DonationManagementFacade", "Failed to open json file for output");
            return false;
        }

        return true;
    }
}
