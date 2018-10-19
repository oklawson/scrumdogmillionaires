package com.scrumdog.donationtracker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Donation {

    //what are categories??
    public static List<String> theCategories = Arrays.asList("Clothing", "Hat", "Kitchen", "Electronics", "Household", "Other");

    /** this items short descripnt */
    private String _shortDescription;

    /** this items price */
    private String _dollarValue;

    /** this items category */
    private String _category;

    /** this items description */
    private String _fullDescription;

    /** this items comment */
    private String _comments;

    /** the list of all items at a location */
    public static ArrayList<Donation> _donation = new ArrayList<>();


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

    /**
     * Make a new user
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
        _donation.add(this);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public Donation() {
        this("enter new name" , "NA", "NA", "NA", "NA");
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
