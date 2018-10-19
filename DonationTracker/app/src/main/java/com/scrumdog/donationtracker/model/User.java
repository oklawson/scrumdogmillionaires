package com.scrumdog.donationtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//implements Parcelable
public class User {

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsers = Arrays.asList("User", "Location Employee", "Admin");

    /** a demonstration of using something other than an enum for holding choices */
    public static List<String> legalUsersLocations = Arrays.asList("AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministires", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");

    /** this users ID - can be email or id */
    private String _ID;

    /** this users name */
    private String _name;

    /** this users type */
    private String _userType;

    /** this users location */
    private String _userLocation;

    /** this users password */
    private String _password;

    /** the list of all registered users */
    public static ArrayList<User> _users = new ArrayList<>();


    /* **********************
     * Getters and setters
     */
    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    //no setter for this.  id is a read only field
    public String getID() { return _ID; }
    public void setID(String ID) { _ID = ID; }

    public String getUserType() {return _userType; }
    public void set_userType(String userType) { _userType = userType; }

    public String getPassword() {return _password; }
    public void setPassword(String password) { _password = password; }

    public String getUserLocation() {return _userLocation; }
    public void setUserLocation(String userLocation) { _userLocation = userLocation; }

    /**
     * Lookup a user type based on its code.  Returns the postion of that
     * user type in the array
     *
     * @param code the user type to find
     *
     * @return the index of the array that corresponds to the submitted major
     */
//    public static int findPosition(String code) {
//        int i = 0;
//        while (i < legalUsers.size()) {
//            if (code.equals(legalUsers.get(i))) return i;
//            ++i;
//        }
//        return 0;
//    }


    /**
     * Make a new user
     * @param name      the user's name
     * @param ID    the user's id
     * @param password  the user's password
     * @param userType  the user's type
     * @param userLocation the user's location
     */
    public User(String name, String ID, String password, String userType, String userLocation) {
        _name = name;
        _ID = ID;
        _password = password;
        _userType = userType;
        _userLocation = userLocation;
        _users.add(this);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public User() {
        this("enter new name" , "NA", "NA", "NA", "NA");
    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return _name + " ," + _ID + " ," + _userType + " ," + _userLocation;
    }


    /* *********************************
     * These methods are required by the Parcelable interface
     * I just wanted to demo how to pass information from one activity
     * to another through an intent.   If this were a real project, I
     * would probably have the facade maintain information about the
     * currently selected student which would remove the need to
     * pass the student object in an intent, which would remove the need
     * to implement the Parcelable interface and these methods.
     */

//    /**
//     * Constructor used by Parcel to make a new student out of the
//     * parceled information
//     *
//     * @param in  the parcel containing the student information
//     */
//    private Student(Parcel in) {
//        _name = in.readString();
//        _major = in.readString();
//        _id = in.readInt();
//
//
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    /* *************************
//       If you add new instance vars to Student, you will need to add them to the write
//       Be sure the order you write information matches the order that the constructor above
//       reads them.
//     */
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(_name);
//        dest.writeString(_major);
//        dest.writeInt(_id);
//
//
//    }
//
//    /**
//     * Should not have to edit this method if the constructor and write method are
//     * working correctly.
//     */
//    public static final Parcelable.Creator<Student> CREATOR
//            = new Parcelable.Creator<Student>() {
//        public Student createFromParcel(Parcel in) {
//            return new Student(in);
//        }
//
//        public Student[] newArray(int size) {
//            return new Student[size];
//        }
//    };
}
