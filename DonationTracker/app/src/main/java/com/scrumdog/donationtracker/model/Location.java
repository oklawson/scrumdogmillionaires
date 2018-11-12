package com.scrumdog.donationtracker.model;

//import com.scrumdog.donationtracker.controllers.DonationEntryActivity;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;


public class Location {

    public static final ArrayList<Location> locations = new ArrayList<>();
    private String _locationName;
    private String _locationType;
    private double _longitude;
    private double _latitude;
    private String _address;
    private String _phoneNumber;

    /**
     * get the location's name
     * @return _locationName the location's name
     */
    public String getName() { return _locationName; }

    /**
     * set the location's name
     * @param name the location's name
     */
    public void setName(String name) { _locationName = name; }

    /**
     * get the location's type
     * @return _location type the location's type
     */
    public String getType() { return _locationType; }

    /**
     * set the location's type
     * @param type type the location's type
     */
    public void setType(String type) { _locationType = type; }

    /**
     * get the location's address
     * @return _address type the location's address
     */
    public String getAddress() { return _address; }

    /**
     * set the location's address
     * @param address type the location's address
     */
    public void setAddress(String address) { _address = address; }

    /**
     * get the location's longitude
     * @return _longitude type the location's longitude
     */
    public double getLongitude() { return _longitude; }

    /**
     * set the location's longitude
     * @param longitude type the location's longitude
     */
    public void setLongitude(double longitude) { _longitude = longitude; }

    /**
     * get the location's latitude
     * @return _latitude type the location's latitude
     */
    public double getLatitude() { return _latitude; }

    /**
     * set the location's latitude
     * @param latitude type the location's latitude
     */
    public void setLatitude(double latitude) { _latitude = latitude; }

    /**
     * get the location's phone number
     * @return _phoneNumber type the location's phone number
     */
    public String getPhoneNumber() { return _phoneNumber; }

    /**
     * set the location's phone number
     * @param phoneNumber type the location's phone number
     */
    public void setPhoneNumber(String phoneNumber) { _phoneNumber = phoneNumber; }


    /**
     * construct a new location
     * @param name the location's name
     * @param type the location's type
     * @param longitude the location's longitude
     * @param latitude the location's latitude
     * @param address the location's address
     * @param phoneNumber the location's phone number
     */
    private Location(String name, String type, double longitude, double latitude, String address, String phoneNumber) {
        _locationName = name;
        _locationType = type;
        _longitude = longitude;
        _latitude = latitude;
        _address = address;
        _phoneNumber = phoneNumber;
        //legalLocations.add(this._locationName);
    }

//    /**
//     * No param constructor -- DO NOT CALL NORMALLY
//     * This constructor only for GUI use in edit/new student dialog
//     * Creates a new location
//     */
//    public Location() {
//        this("Enter new name", "Enter type", 0, 0, "Enter address", null);
//    }

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
