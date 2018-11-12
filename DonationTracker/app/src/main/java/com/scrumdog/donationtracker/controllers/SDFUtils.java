package com.scrumdog.donationtracker.controllers;

import android.content.Context;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SDFUtils {

    /**
     * loads locations
     */
    public static void readSDFile(Context context) throws Exception {
        //SimpleModel model = SimpleModel.INSTANCE;

        //Open a stream on the raw file
        InputStream is = context.getResources().openRawResource(R.raw.locationdata);
        //From here we probably should call a model method and pass the InputStream
        //Wrap it in a BufferedReader so that we get the readLine() method
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line;
        br.readLine(); //get rid of header line
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            Location newLocation = new Location(tokens[1], tokens[8], Double.parseDouble(tokens[3]), Double.parseDouble(tokens[2]), tokens[4], tokens[9]);
            newLocation.setName(tokens[1]);
            newLocation.setType(tokens[8]);
            newLocation.setLongitude(Double.parseDouble(tokens[3]));
            newLocation.setLatitude(Double.parseDouble(tokens[2]));
            newLocation.setAddress(tokens[4]);
            newLocation.setPhoneNumber(tokens[9]);
            Location.locations.add(newLocation);

        }
        br.close();
    }
}
