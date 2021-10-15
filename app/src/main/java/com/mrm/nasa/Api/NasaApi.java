package com.mrm.nasa.Api;

import com.mrm.nasa.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {
    @GET("rovers/curiosity/photos")
    Call<Model> getNasa(@Query("earth_date") String date);
}
