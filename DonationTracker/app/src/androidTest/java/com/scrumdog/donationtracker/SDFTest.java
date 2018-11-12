package com.scrumdog.donationtracker;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.scrumdog.donationtracker.controllers.SDFUtils;
import com.scrumdog.donationtracker.model.Location;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;



import androidx.test.filters.MediumTest;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class SDFTest {

    @Before
    public void setup() {
        Location.locations.clear();
    }

    @Test
    public void testReadSDF() {
        try {
            SDFUtils.readSDFile(InstrumentationRegistry.getTargetContext());
        } catch (Exception e) {
            // no exception expected - file exists
        }

        assertEquals(6, Location.locations.size());

    }

}
