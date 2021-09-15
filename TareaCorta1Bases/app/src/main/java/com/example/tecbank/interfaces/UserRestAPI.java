package com.example.tecbank.interfaces;

import com.example.tecbank.models.User;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserRestAPI {

    @GET("client/username/{username}")
    public Call<User> getUser(@Path("username") String username);

    @POST("client")
    public Call<User> postUser(@Body User user);

}
