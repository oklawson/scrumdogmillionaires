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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Marker m0;
    private Marker m1;
    private Marker m2;
    private Marker m3;
    private Marker m4;
    private Marker m5;

    private static final int ZOOM_LEVEL = 10;
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
     *
     * @param googleMap the GoogleMap object that will be used for the app's map display
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            SDFUtils.readSDFile(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        GoogleMap mMap = googleMap;

         //Add a marker at location 0
//        LatLng location0 = new LatLng(Location.locations.get(0).getLatitude(), Location.locations.get(0).getLongitude());
//        m0 = mMap.addMarker(new MarkerOptions()
//                .position(location0)
//                .title(Location.locations.get(0).getName())
//                .snippet(Location.locations.get(0).getPhoneNumber()));
//        m0.setTag(0);
//
//
//        LatLng location1 = new LatLng(Location.locations.get(1).getLatitude(), Location.locations.get(1).getLongitude());
//        m1 = mMap.addMarker(new MarkerOptions()
//                .position(location1)
//                .title(Location.locations.get(1).getName())
//                .snippet(Location.locations.get(1).getPhoneNumber()));
//        m1.setTag(0);
//
//        LatLng location2 = new LatLng(Location.locations.get(2).getLatitude(), Location.locations.get(2).getLongitude());
//        m2 = mMap.addMarker(new MarkerOptions()
//                .position(location2)
//                .title(Location.locations.get(2).getName())
//                .snippet(Location.locations.get(2).getPhoneNumber()));
//        m2.setTag(0);
//
//        LatLng location3 = new LatLng(Location.locations.get(3).getLatitude(), Location.locations.get(3).getLongitude());
//        m3 = mMap.addMarker(new MarkerOptions()
//                .position(location3)
//                .title(Location.locations.get(3).getName())
//                .snippet(Location.locations.get(3).getPhoneNumber()));
//        m3.setTag(0);
//
//        LatLng location4 = new LatLng(Location.locations.get(4).getLatitude(), Location.locations.get(4).getLongitude());
//        m4 = mMap.addMarker(new MarkerOptions()
//                .position(location4)
//                .title(Location.locations.get(4).getName())
//                .snippet(Location.locations.get(4).getPhoneNumber()));
//        m4.setTag(0);
//
//        LatLng location5 = new LatLng(Location.locations.get(5).getLatitude(), Location.locations.get(5).getLongitude());
//        m5 = mMap.addMarker(new MarkerOptions()
//                .position(location5)
//                .title(Location.locations.get(5).getName())
//                .snippet(Location.locations.get(5).getPhoneNumber()));
//        m5.setTag(0);

        for (int i = 0; i < Location.locations.size(); i++) {
            Location location = Location.locations.get(i);
            Log.d("DEBUG", "Location: " + Location.locations.get(i));
            LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(location.getName())
                    .snippet(location.getPhoneNumber()));
            //marker.setTag(0);
        }
        //fillTextViews(location);
        CameraPosition camPos = new CameraPosition(
                new LatLng(Location.locations.get(0).getLatitude(), Location.locations.get(0).getLongitude()),
                ZOOM_LEVEL, TILT_LEVEL, BEARING_LEVEL);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
    }
}
