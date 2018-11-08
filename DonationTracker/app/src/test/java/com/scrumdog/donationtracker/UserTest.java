package com.scrumdog.donationtracker;

import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.*;
import com.scrumdog.donationtracker.model.User;
import com.scrumdog.donationtracker.model.DonationManager;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserTest {

    private User testUser;
    private DonationManager dm;

    //Madison's methods
    @Before
    public void setUp() {
        testUser = new User("John Doe", "johndoe@gmail.com", "User",
                "AFD Station 4", "johndoe");
    }
    @Test
    public void testParseEntry() {
        assertEquals("Entries parsed incorrectly", testUser.parseEntry(null), null);
        assertEquals("Entries parsed incorrectly",  testUser.parseEntry("John Doe   johndoe@gmail.com   User    AFD Station 4   johndoe"),
                testUser);

    }

//    @Before
//    public void setUpDM() {
//        dm = new DonationManager();
//        dm.donations.add()
//    }
//
//    @Test
//    public void testUserMap() {
//
//    }



}