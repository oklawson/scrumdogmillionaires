package com.scrumdog.donationtracker;


import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.*;
import com.scrumdog.donationtracker.model.Donation;


public class DonationTest {

    private Location testLocation;

    //_shortDescription = shortDescription;
    //        _dollarValue = dollarValue;
    //        _category = category;
    //        _fullDescription = fullDescription;
    //        _comments = comments;
    //       _locationS = location;
    //       // _location = findLocationByName(umt.getCurrentUser().getUserLocation());
    //        _listed = false;
    //        timeStamp = new Date();
    //        //_donation.add(this);

    @Before
    public void setUp() {
        testDonation = new Donation("test", "20", "Hat",
                "testing","n/a", "AFD Station 4");
    }

    @Test
    public void testFindLocationByName() {

    }

}
