package com.frontiir.arch.userarch.service;

import android.telecom.Call;

import com.frontiir.arch.userarch.model.User;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author monshein
 * @since 1/17/18
 */

public interface Webservice {

    @GET("/users/{user}")
    retrofit2.Call<User> getUser(@Path("user") String userId);
}
