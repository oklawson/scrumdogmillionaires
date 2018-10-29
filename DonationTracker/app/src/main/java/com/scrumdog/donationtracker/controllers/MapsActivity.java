package com.scrumdog.donationtracker.controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final int ZOOM_LEVEL = 15;
    private static final int TILT_LEVEL = 0;
    private static final int BEARING_LEVEL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            this.readSDFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMap = googleMap;

        // Add a marker at location 0
//        LatLng location0 = new LatLng(Location.locations.get(0).getLatitude(), Location.locations.get(0).getLongitude());
//        mMap.addMarker(new MarkerOptions().position(location0).title(Location.locations.get(0).getName()));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(location0));

        for (int i = 0; i < Location.locations.size(); i++) {
            Location location = Location.locations.get(i);
            Log.d("DEBUG", "Location: " + Location.locations.get(i));
            LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(position).title(location.getName()));
        }
        //fillTextViews(location);
        CameraPosition camPos = new CameraPosition(
                (new LatLng(Location.locations.get(0).getLatitude(),
                        Location.locations.get(0).getLongitude())),
                ZOOM_LEVEL, TILT_LEVEL, BEARING_LEVEL);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
    }

    private void readSDFile() throws Exception {
        //SimpleModel model = SimpleModel.INSTANCE;

        //Open a stream on the raw file
        InputStream is = getResources().openRawResource(R.raw.locationdata);
        //From here we probably should call a model method and pass the InputStream
        //Wrap it in a BufferedReader so that we get the readLine() method
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line;
        br.readLine(); //get rid of header line
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            Location newLocation = new Location();
            newLocation.setName(tokens[1]);
            newLocation.setType(tokens[8]);
            newLocation.setLongitude(Double.parseDouble(tokens[3]));
            newLocation.setLatitude(Double.parseDouble(tokens[2]));
            newLocation.setAddress(tokens[4]);
            newLocation.setPhoneNumber(tokens[9]);
            Location.locations.add(newLocation);
            //Location.legalLocations.add(newLocation.getName());

        }
        br.close();
    }
}
