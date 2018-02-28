package com.example.diu.loginapppractice;

import android.provider.ContactsContract;

public class User {
    
    private String username;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String userType;

    public User(){

    }
    public User(String username,String password,String email,String phone,String gender,String userType){
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.userType=userType;
    }
    /*public User(String username,String password){
        this.username=username;
        this.password=password;

    }*/
    //get info

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    //set info


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    //check login
    /*public boolean  verifyLogin(String username1,String password2){
        if(username1.equalsIgnoreCase(username) && password2.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }*/

    //insert value
   /* public void insertUserInformation(){

    }*/
}
