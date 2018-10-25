package com.scrumdog.donationtracker.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

import com.google.gson.Gson;

/**
 * This class manages the list of users in the model
 * It is all package vis because it should only be accessed from the facade, not directly
 *
 */

public class UserManager {
    /**
     * A list of students
     */
    private final List<User> users = new ArrayList<>();

    /**
     * A map of students by Key == user ID Value == User object
     *
     * This is marked as transient so it will not be serialized.
     * It is derived from the students collection above, so it does not
     * need to be serialized.
     */
    private transient Map<String, User> userMap = new HashMap<>();

    private User currentUser = null;

    /**
     * add a user to the collection
     * @param name the user name
     * @param ID the user id
     * @param userType the user type
     * @param userLocation the user location
     * @param password the user password
     * @param file userdata file (JSON)
     */
    void addUser(String name, String ID, String userType, String userLocation, String password, File file) {
        User user = new User(name, ID, userType, userLocation, password);
        users.add(user);
        userMap.put(ID, user);

        try {
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            // convert our objects to a string for output
            writer.append(gson.toJson(user));
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to save user to json file for output");
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Failed to save user to json file for output");
        }

    }


    /**
     * Attempt to login a user
     *
     * @param ID user id of user
     * @param password password of user
     * @return  the Student object is login successful, null otherwise
     */
    User doLogin(String ID, String password) {
        //first lookup the user by their login id
        User user = userMap.get(ID);
        //if that user id not there, return null
        if (user == null) return null;


        //we have a good user at this point, so check their password
        if (user.checkPassword(password)) return user;
        //return null if a bad password
        return null;
    }


    /**
     * this is package vis because only model should be asking for this data
     *
     * @return
     */
    List<User> getUsers() {
        return users;
    }

    User getUserByID(String ID) {
        return userMap.get(ID);
    }

    /**
     *
     * @param writer
     */
    void saveAsText(PrintWriter writer) {
        System.out.println("Manager saving: " + users.size() + " users" );
        writer.println(users.size());
        for(User u : users) {
            u.saveAsText(writer);
        }
    }

    /**
     * load the model from a custom text file
     *
     * @param reader  the file to read from
     */
    void loadFromText(BufferedReader reader) {
        System.out.println("Loading Text File");
        userMap.clear();
        users.clear();
        try {
            String countStr = reader.readLine();
            assert countStr != null;
            int count = Integer.parseInt(countStr);

            //then read in each user to model
            for (int i = 0; i < count; ++i) {
                String line = reader.readLine();
                User u = User.parseEntry(line);
                users.add(u);
                userMap.put(u.getID(), u);
            }
            //be sure and close the file
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done loading text file with " + users.size() + " users");

    }


    /**
     * This should only be called during serialization (reading in).
     *
     * This recomputes the user map which is derived from the user collection.
     *
     */
    void regenMap() {
        if (userMap != null)
            userMap.clear();
        else
            userMap = new HashMap<>();
        for (User u : users) {
            userMap.put(u.getID(), u);
        }
    }

    /**
     * used by command pattern, should be not called otherwise
     *
     * @param user the student to add
     */
    void addUser(User user) {
        users.add(user);
        userMap.put(user.getID(), user);
    }

    void removeUser(User user) {
        users.remove(user);
        userMap.remove(user.getID());
    }
}
