package com.scrumdog.donationtracker.model;

import com.scrumdog.donationtracker.controllers.DonationEntryActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location {

    public static ArrayList<Location> locations = new ArrayList<>();

    //public static List<String> legalLocations = Arrays.asList();

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
        //legalLocations.add(this._locationName);
    }

    public Location() {
        this("Enter new name", "Enter type", 0, 0, "Enter address", null);
    }

    @Override
    public String toString() {
        return _locationName + " ," + _locationType + ", " + _longitude + ", " + +_latitude + ", " + _address + ", " + _phoneNumber;
    }



}

//LOCATION EMPLOYEE CLASS
//package com.scrumdog.donationtracker.model;
//
//public class LocationEmployee extends User {
//
//    Location _employeeLocation;
//
//    public LocationEmployee(String name, String ID, String password, String userType, String userLocation) {
//        super(name, ID, password, userType, userLocation);
//        _employeeLocation = userLocation;
//    }
//
//    public Location getLocation() { return _employeeLocation; }
//    public void setLocation(Location location) { _employeeLocation = location; }
//
//}
