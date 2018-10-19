package com.scrumdog.donationtracker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class Donation {

    //what are categories??
    public static List<String> theCategories = Arrays.asList("Clothing", "Hat", "Kitchen", "Electronics", "Household", "Other");

    /** this items short description */
    private String _shortDescription;

    /** this items price */
    private String _dollarValue;

    /** this items category */
    private String _category;

    /** this items description */
    private String _fullDescription;

    /** this items comment */
    private String _comments;

    /** this items location */
    private Location _location;

    private Date timeStamp;

    private String _locationS;

    private boolean _listed;


    /** the list of all items at a location */
    //public static ArrayList<Donation> _donation = new ArrayList<>();


    //**Getters and Setters**//

    public String getshortDescription() { return _shortDescription; }
    public void setshortDescription(String shortDescription) { _shortDescription = shortDescription; }

    public String getdollarValue() { return _dollarValue; }
    public void setdollarValue(String dollarValue) { _dollarValue = dollarValue; }

    public String getCategory() { return _category; }
    public void setCategory(String category) { _category = category; }

    public String getFullDescription() { return _fullDescription; }
    public void setFullDescription(String fullDescription) { _fullDescription = fullDescription; }

    public String getComments() { return _comments; }
    public void setComments(String comments) { _comments = comments; }

    public String getItemLocationS() { return _locationS; }
    public void setItemLocationS(String location) { _locationS = location; }

    public Location getItemLocation() { return _location; }
    public void setItemLocation(Location location) { _location = location; }

    public boolean getListed() { return _listed; }
    public void setListed(boolean listed) { _listed = listed; }

    public Date getTimeStamp() { return timeStamp; }

    /**
     * Make a new donation
     * @param shortDescription      the donation's shortDescription
     * @param dollarValue    the donation's dollarValue
     * @param category  the donation's category
     * @param fullDescription  the donation's fullDescription
     * @param comments the donation's comments
     */
    public Donation(String shortDescription, String dollarValue, String category, String fullDescription, String comments) {
        _shortDescription = shortDescription;
        _dollarValue = dollarValue;
        _category = category;
        _fullDescription = fullDescription;
        _comments = comments;
        _locationS = User.getCurrentUser().getUserLocation();
        _location = findLocationByName(User.getCurrentUser().getUserLocation());
        _listed = false;
        timeStamp = new Date();
        //_donation.add(this);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public Donation() {
        this("enter new name" , "NA", "NA", "NA", "NA");
    }


    public static Location findLocationByName(String location) {
        for (Location l : Location.locations) {
            if (location.equals(l.getName())) {
                return l;
            }
        }
        return null;
    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return _shortDescription + " ," + _dollarValue + " ," + _category;
    }
}
