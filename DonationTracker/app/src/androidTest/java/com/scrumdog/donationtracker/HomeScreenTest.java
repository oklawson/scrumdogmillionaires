
package com.scrumdog.donationtracker;
import com.scrumdog.donationtracker.controllers.LoginActivity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.junit.Assert.*;

import android.content.Intent;
import androidx.test.espresso.Espresso.*;
import androidx.test.espresso.intent.*;
import android.support.test.espresso.*;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.view.menu.MenuView;

import com.scrumdog.donationtracker.controllers.HomeScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
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
        // THIS FEELS WRONG>>>?
        onView(withId(R.id.loginButton)).perform(click());
        intended(hasComponent(MenuView.ItemView.class.getName()));
        Intents.release();
    }

}
