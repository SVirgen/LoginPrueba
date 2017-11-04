package com.example.saul.loginuser.retrofit;

import com.example.saul.loginuser.PostWebService.Wservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by saul on 03/11/17.
 */

public interface User {
    @GET ("loginFake/{email}/{password}")
    Call<Wservice> login(@Path("email")String email, @Path("password")String password);
}
