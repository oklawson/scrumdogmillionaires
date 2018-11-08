package com.scrumdog.donationtracker;

import com.scrumdog.donationtracker.model.User;
import com.scrumdog.donationtracker.model.UserManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;


/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserManagerTest {

    private UserManager testUserManager;
    private User audrey;

    /**
     * set up the UserManager to be tested
     */
    @Before
    public void setUp() {
        testUserManager = new UserManager();
        audrey = new User("Audrey", "audrey@gmail.com", "User","AFD Station 4", "audrey");
        testUserManager.addUser(audrey);
    }

    /**
     * test the UserManager class doLogin method
     */
    @Test
    public void testDoLogin() {
        // test what happens if the user enters the wrong password
        assertEquals(null, testUserManager.doLogin("audrey@gmail.com", "notaudrey"));
        // test what happens if the user does not exist
        assertEquals(null, testUserManager.doLogin("notaudrey@gmail.com", "audrey"));
        // test what happens if the user enters the correct password
        assertEquals(audrey, testUserManager.doLogin("audrey@gmail.com", "audrey"));
    }
}