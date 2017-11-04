package com.example.saul.loginuser.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saul on 03/11/17.
 */

public class RetroFitC {

    private static Retrofit retrofit = null;

    public static  Retrofit getC(String url){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
