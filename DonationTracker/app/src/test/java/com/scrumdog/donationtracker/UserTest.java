package com.scrumdog.donationtracker;

import org.junit.Test;

import org.junit.Before;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import com.scrumdog.donationtracker.model.User;

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserTest {

    private User testUser;
    private User marilyn;

    /**
     * set up the User to be tested
     */
    @Before
    public void setUp() {
        marilyn = new User("Marilyn", "marilyn@gmail.com", "User","AFD Station 4", "marilyn");
    }

    /**
     * test the User class parseEntry method
     */
    @Test
    public void testParseEntry() {
        // test what happens if the string is null
        assertEquals(null, testUser.parseEntry(null));
        // test what happens if the line has 0 tokens
        assertEquals(null, testUser.parseEntry("\t"));
        // test what happens if the line has 1 tokens
        assertEquals(null, testUser.parseEntry("Marilyn\t"));
        // test what happens if the line has 2 tokens
        assertEquals(null, testUser.parseEntry("Marilyn\tmarilyn@gmail.com"));
        // test what happens if the line has 3 tokens
        assertEquals(null, testUser.parseEntry("Marilyn\tmarilyn@gmail.com\tUser"));
        // test what happens if the line has 4 tokens
        assertEquals(null, testUser.parseEntry("Marilyn\tmarilyn@gmail.com\tUser\tAFD Station 4"));
        // test what happens if the line has 5 tokens
        assertEquals(marilyn, testUser.parseEntry("Marilyn\tmarilyn@gmail.com\tUser\tAFD Station 4\tmarilyn"));
    }
}