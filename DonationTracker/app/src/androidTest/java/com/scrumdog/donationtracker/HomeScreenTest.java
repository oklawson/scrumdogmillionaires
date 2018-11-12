
package com.scrumdog.donationtracker;
import com.scrumdog.donationtracker.controllers.LoginActivity;

import android.content.Intent;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.view.menu.MenuView;

import com.scrumdog.donationtracker.controllers.HomeScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.Intents;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class HomeScreenTest {

    @Rule
    public final ActivityTestRule<HomeScreen> rule =
            new ActivityTestRule<>(HomeScreen.class, true, false);

    /**
     * Tests if LoginActivity transfers to HomeScreen correctly
     * when the loginButton is clicked
     */
    @Test
    public void loginTest() throws InterruptedException {
        rule.launchActivity(new Intent());
        Intents.init();
        onView(withId(R.id.loginButton)).perform(click());
        intended(hasComponent(LoginActivity.class.getName()));
        Intents.release();
    }

    /**
     * On create.
     *
     * @throws Exception the exception
     */
    @Test
    public void onCreate() throws Exception {
        rule.launchActivity(new Intent());
        Intents.init();
        onView(withId(R.id.loginButton)).perform(click());
        intended(hasComponent(MenuView.ItemView.class.getName()));
        Intents.release();
    }

}
