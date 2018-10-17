package com.scrumdog.donationtracker.model;

public class LocationEmployee extends User {

    Location _employeeLocation;

    public LocationEmployee(String name, String ID, String password, String userType, Location location) {
        super(name, ID, password, userType);
        _employeeLocation = location;
    }

    public Location getLocation() { return _employeeLocation; }
    public void setLocation(Location location) { _employeeLocation = location; }

}
