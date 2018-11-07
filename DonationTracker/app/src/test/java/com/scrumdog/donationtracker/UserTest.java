package com.scrumdog.donationtracker;

import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.*;
import com.scrumdog.donationtracker.model.User;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserTest {

    private User testUser;

    @Before
    public void setUp() {
        testUser = new User("John Doe", "johndoe@gmail.com", "User",
                "AFD Station 4", "johndoe");
    }
    @Test
    public void testParseEntry() {
        assertEquals("Entries parsed incorrectly",  testUser.parseEntry("John Doe   johndoe@gmail.com   User    AFD Station 4   johndoe"),
                new User("John Doe","johndoe@gmail.com", "User",
                "AFD Station 4", "johndoe"));
    }
}