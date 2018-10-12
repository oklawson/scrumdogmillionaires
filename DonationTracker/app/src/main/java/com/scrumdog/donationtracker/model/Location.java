package com.scrumdog.donationtracker.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    public static ArrayList<Location> locations = new ArrayList<>();

    private String _locationName;
    private String _locationType;
    private double _longitude;
    private double _latitude;
    private String _address;
    private String _phoneNumber;

    public String getName() { return _locationName; }
    public void setName(String name) { _locationName = name; }

    public String getType() { return _locationType; }
    public void setType(String type) { _locationType = type; }

    public String getAddress() { return _address; }
    public void setAddress(String address) { _address = address; }

    public double getLongitude() { return _longitude; }
    public void setLongitude(double longitude) { _longitude = longitude; }

    public double getLatitude() { return _latitude; }
    public void setLatitude(double latitude) { _latitude = latitude; }

    public String getPhoneNumber() { return _phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { _phoneNumber = phoneNumber; }

    public Location(String name, String type, double longitude, double latitude, String address, String phoneNumber) {
        _locationName = name;
        _locationType = type;
        _longitude = longitude;
        _latitude = latitude;
        _address = address;
        _phoneNumber = phoneNumber;
        //_locations.add(this);
    }

    public Location() {
        this("Enter new name", "Enter type", 0, 0, "Enter address", null);
    }

    @Override
    public String toString() {
        return _locationName + " ," + _locationType + ", " + _longitude + ", " + +_latitude + ", " + _address + ", " + _phoneNumber;
    }



}
