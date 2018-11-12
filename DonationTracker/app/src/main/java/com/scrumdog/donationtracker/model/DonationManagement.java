package com.scrumdog.donationtracker.model;

import android.annotation.SuppressLint;
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
    private static final DonationManagement instance = new DonationManagement();

    /**
     * private constructor for facade pattern
     */
    private DonationManagement() {
        dm = new DonationManager();
    }

    /**
     * Singleton pattern accessor for instance
     * @return instance the one and only one instance of this facade
     */
    public static DonationManagement getInstance() { return instance; }

    /**
     * retrieves a list of the donations
     * @return donList list of donations
     */
    public List<Donation> getDonationsAsList() {
        List<Donation> donList = dm.getDonations();
        return donList;
    }

    /**
     * retrieves a donation by its name
     * @param name the name of the donation
     * @return don the donation
     */
    public Donation getDonationByName(final String name) {
        Donation don = dm.getDonationByName(name);
        return don;
    }

    /**
     * adds a new donation
     * @param shortDescription the donation's shortDescription
     * @param dollarValue the donation's dollarValue
     * @param category the donation's category
     * @param fullDescription the donation's fullDescription
     * @param comments the donation's comments
     * @param location the donation's location
     */
    public void addNewDonation(final String shortDescription, final String dollarValue, final
        String category, final String fullDescription, final String comments, final String location) {
        dm.addDonation(shortDescription, dollarValue, category, fullDescription, comments, location);
    }

//    public boolean registerDonation(final String shortDescription) {
//        currentDonation = dm.registerDonation(shortDescription);
//        return (currentDonation != null);
//    }

//    public Donation getCurrentDonation() { return currentDonation; }
//
//    public void setCurrentDonation(Donation d) {
//        this.currentDonation = d;
//    }

    /**
     * adds a new donation
     * @param d the donation added to the application
     */
    void addDonation(Donation d) {
        dm.addDonation(d);
    }

    /**
     * removes a new donation
     * @param donation the donation removed to the application
     */
    void removeDonation(Donation donation) {
        dm.removeDonation(donation);
    }


    /**
     * loads the JSON file storing the donation data
     * @param file the JSON file
     * @return true if the file is successfully loaded, false otherwise
     */
    @SuppressLint("LongLogTag")
    public void loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "Donation JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automatically
            Gson gson = new Gson();

            dm = gson.fromJson(inString, DonationManager.class);
            dm.regenMap();
            input.close();
        } catch (IOException e) {
            Log.e("DonationManagementFacade", "Failed to open/read the buffered reader for json");
        }

    }

    /**
     * save data to the JSON file storing the donation data
     * @param file the JSON file
     * @return true if the data is successfully saved to the file, false otherwise
     */
    @SuppressLint("LongLogTag")
    public void saveJson(File file) {

        try {
            PrintWriter writer = new PrintWriter(file);
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(dm);
            Log.d("DEBUG", " Donation JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("DonationManagementFacade", "Failed to open json file for output");
        }

    }
}
