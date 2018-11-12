package com.scrumdog.donationtracker;
import com.scrumdog.donationtracker.controllers.MapsActivity;

import android.content.Intent;
import android.support.v7.view.menu.MenuView;

import com.scrumdog.donationtracker.controllers.HomeScreen;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MapActivityTest {

    @Rule
    public final ActivityTestRule<HomeScreen> rule =
            new ActivityTestRule<>(HomeScreen.class, true, false);

    /**
     * Tests if LoginActivity properly transfers to RegistrationActivity
     * when the button is clicked
     */
    @Test
    public void mapsTest() throws InterruptedException {
        rule.launchActivity(new Intent());

        Intents.init();
        //Simulate filling out fields and pushing register button
        onView(withId(R.id.viewLocationsButton)).perform(click());

        intended(hasComponent(MapsActivity.class.getName()));
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
        // THIS FEELS WRONG>>>?
        onView(withId(R.id.loginButton)).perform(click());
        intended(hasComponent(MenuView.ItemView.class.getName()));
        Intents.release();
    }
}
