package com.example.saul.loginuser.retrofit;

/**
 * Created by saul on 03/11/17.
 */

public class ApiUl {


    public static final  String BASE_URL ="http://35.188.192.72/api/";

    public  static User getUser(){
        return RetroFitC.getC(BASE_URL).create(User.class);

    }
}
