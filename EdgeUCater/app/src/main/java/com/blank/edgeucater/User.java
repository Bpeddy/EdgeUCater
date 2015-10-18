package com.blank.edgeucater;

/**
 * Created by James on 10/17/2015.
 */
public class User {

    private String firstName, lastName, email, password;
    private int studentID;

    public User(String firstName, String lastName, String email, String password, int studentID){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.studentID = studentID;

    }

    public User(String email, String password){

        this.firstName = "";
        this.lastName = "";
        this.email = email;
        this.password = password;
        this.studentID = -1;

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public int getStudentID(){
        return this.studentID;
    }

}
