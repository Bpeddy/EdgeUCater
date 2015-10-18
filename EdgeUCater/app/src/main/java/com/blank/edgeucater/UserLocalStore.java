package com.blank.edgeucater;

import android.content.*;

/**
 * Created by James on 10/17/2015.
 */
public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){

        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEdit = userLocalDatabase.edit();
        spEdit.putString("firstName", user.getFirstName());
        spEdit.putString("lastName", user.getLastName());
        spEdit.putString("email", user.getEmail());
        spEdit.putString("password", user.getPassword());
        spEdit.putInt("studentID", user.getStudentID());
        spEdit.commit();
    }

    public User getLoggedInUser(){
        String firstName = userLocalDatabase.getString("firstName", "");
        String lastName = userLocalDatabase.getString("lastName", "");
        String email = userLocalDatabase.getString("email", "");
        String password = userLocalDatabase.getString("password", "");
        int studentID = userLocalDatabase.getInt("studentID", -1);

        User storedUser = new User(firstName, lastName, email, password, studentID);

        return storedUser;
    }

    public void setLoggedIn(boolean loggedIn){

        SharedPreferences.Editor spEdit = userLocalDatabase.edit();
        spEdit.putBoolean("loggedIn",loggedIn);
        spEdit.commit();
    }

    public boolean getLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn", false) == true) return true;
        return false;
    }

    public void clearUserData(){
        SharedPreferences.Editor spEdit = userLocalDatabase.edit();
        spEdit.clear();
        spEdit.commit();
    }
}
