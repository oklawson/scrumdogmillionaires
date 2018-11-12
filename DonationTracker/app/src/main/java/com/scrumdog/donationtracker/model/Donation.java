package com.scrumdog.donationtracker.model;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;


public class Donation {

    //what are categories??
    public static final List<String> theCategories = Arrays.asList("Clothing", "Hat", "Kitchen", "Electronics", "Household", "Other");

    /** this items short description */
    private final String _shortDescription;

    /** this items price */
    private final String _dollarValue;

    /** this items category */
    private final String _category;

    /** this items description */
    private final String _fullDescription;

    /** this items comment */
    private final String _comments;

    /** this items location */
    private Location _location;

    /** this items time-stamp */
    private final Date timeStamp;

    private final String _locationS;

    private final boolean _listed;

    // user management
    //UserManagement umt = UserManagement.getInstance();


    //public static ArrayList<Donation> _donation = new ArrayList<>();


    //**Getters and Setters**//

    /**
     * get the donation's shortDescription
     * @return _shortDescription the shortDescription of the donation
     */
    public String getShortDescription() { return _shortDescription; }

//    /**
//     * set the donation's shortDescription
//     * @param shortDescription the shortDescription of the donation
//     */
//    public void setShortDescription(String shortDescription) { _shortDescription = shortDescription; }

    /**
     * get the donation's dollarValue
     * @return _dollarValue the dollarValue of the donation
     */
    public String getDollarValue() { return _dollarValue; }

//    /**
//     * set the donation's dollarValue
//     * @param dollarValue the dollarValue of the donation
//     */
//    public void setDollarValue(String dollarValue) { _dollarValue = dollarValue; }

    /**
     * get the donation's category
     * @return _category the category of the donation
     */
    public String getCategory() { return _category; }

//    /**
//     * set the donation's category
//     * @param category the category of the donation
//     */
//    public void setCategory(String category) { _category = category; }

    /**
     * get the donation's fullDescription
     * @return _fullDescription the fullDescription of the donation
     */
    public String getFullDescription() { return _fullDescription; }

//    /**
//     * set the donation's fullDescription
//     * @param fullDescription the fullDescription of the donation
//     */
//    public void setFullDescription(String fullDescription) { _fullDescription = fullDescription; }

    /**
     * get the donation's comments
     * @return _comments the comments of the donation
     */
    public String getComments() { return _comments; }

//    /**
//     * set the donation's comments
//     * @param comments the comments of the donation
//     */
//    public void setComments(String comments) { _comments = comments; }

    /**
     * get the location of a certain item
     * @return _locationS the location of the item
     */
    public String getItemLocationS() { return _locationS; }

//    /**
//     * set the locations of a certain item
//     * @param location the locations of the item
//     */
//    public void setItemLocationS(String location) { _locationS = location; }

//    /**
//     * get the donation's location
//     * @return _location the location of the donation
//     */
//    public Location getItemLocation() { return _location; }
//
//    /**
//     * set the donation's location
//     * @param location the location of the donation
//     */
//    public void setItemLocation(Location location) { _location = location; }
//
//    /**
//     * get the list of donations
//     * @return _listed the list of donations
//     */
//    public boolean getListed() { return _listed; }
//
//    /**
//     * set the list of donations
//     * @param listed the list of donations
//     */
//    public void setListed(boolean listed) { _listed = listed; }

    /**
     * get the donation's timestamp
     * @return timeStamp the timeStamp of the donation
     */
    public Date getTimeStamp() { return timeStamp; }

    /**
     * Make a new donation
     * @param shortDescription      the donation's shortDescription
     * @param dollarValue    the donation's dollarValue
     * @param category  the donation's category
     * @param fullDescription  the donation's fullDescription
     * @param comments the donation's comments
     */
    public Donation(String shortDescription, String dollarValue, String category, String fullDescription, String comments, String location) {
        _shortDescription = shortDescription;
        _dollarValue = dollarValue;
        _category = category;
        _fullDescription = fullDescription;
        _comments = comments;
       _locationS = location;
       // _location = findLocationByName(umt.getCurrentUser().getUserLocation());
        _listed = false;
        timeStamp = new Date();
        //_donation.add(this);
    }

//    /**
//     * No param constructor -- DO NOT CALL NORMALLY
//     * This constructor only for GUI use in edit/new student dialog
//     */
//    public Donation() {
//        this("enter new name" , "NA", "NA", "NA", "NA", "NA");
//        timeStamp = new Date();
//    }


//    /**
//     * Make a new donation
//     * @param location the location of the item name
//     * @return l the corresponding location if item name is found, null otherwise
//     */
//    public static Location findLocationByName(String location) {
//        for (Location l : Location.locations) {
//            if (location.equals(l.getName())) {
//                return l;
//            }
//        }
//        return null;
//    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return _shortDescription + " ," + _dollarValue + " ," + _category;
    }
}
