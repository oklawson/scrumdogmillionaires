package com.scrumdog.donationtracker;

import org.junit.Before;
import org.junit.Test;
import com.scrumdog.donationtracker.model.Donation;
import com.scrumdog.donationtracker.model.DonationManager;
import com.scrumdog.donationtracker.controllers.DonationEntryActivity;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class DonationManagerTest {

    private DonationManager testDonationManager;
    private DonationEntryActivity testDonationEntryActivity;
    private Donation d1;
    private Donation d2;
    private ArrayList<Donation> donationList;

    @Before
    public void setUp() {
        testDonationManager = new DonationManager();
        testDonationEntryActivity = new DonationEntryActivity();
        d1 = new Donation("Pink shoes", "40",
                "Clothing","Pink shoes with 3 inch heels",
                "Super cute!", "AFD Station 4");
        d2 = new Donation("Jean jacket", "20",
                "Clothing","A ripped, light-colored jean jacket",
                "Very comfy!", "Boys & Girls Club");
        testDonationManager.addDonation(d1);
        // d1 is not added to the official list of donations (in DonationEntryActivity)
        // until regenMap() is called
        testDonationManager.regenMap();
        donationList = testDonationEntryActivity.donations;
    }

    @Test
    public void regenMap() {
        assertFalse(donationList.contains(null));
        assertFalse(donationList.contains(d2));
        // regenMap() successfully adds the new donation to the official list of donations
        assertTrue(donationList.contains(d1));
    }
}