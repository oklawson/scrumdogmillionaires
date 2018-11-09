package com.scrumdog.donationtracker;

import com.scrumdog.donationtracker.controllers.RegistrationActivity;
import com.scrumdog.donationtracker.model.User;
import com.scrumdog.donationtracker.model.UserManager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class RegistrationActivityTest {

    private RegistrationActivity testRegistrationActivity;
    private UserManager testUserManager;

    /**
     * set up the UserManager to be tested
     */
    @Before
    public void setUp() {
        testRegistrationActivity = new RegistrationActivity();
        testUserManager = new UserManager();
        testUserManager.addUser("Jackie", "jackie@gmail.com", "User","Boys & Girls Club", "jackie");
    }

    /**
     * test the RegistrationActivity class validate method
     */
    @Test
    public void validate() {
        // test what happens if the userID is null
        assertEquals(false, testRegistrationActivity.validate(null));
        // test what happens if the userID is saved in the map already
        assertEquals(true, testRegistrationActivity.validate("jackie@gmail.com"));
        // test what happens if the userID is not saved in the map already
        assertEquals(false, testRegistrationActivity.validate("notjackie@gmail.com"));
    }
}