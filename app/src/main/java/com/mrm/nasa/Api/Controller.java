package com.mrm.nasa.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    private static final String KEY = "9ZgzamRGiD9dLROoWeaHXcQUPIgPYzfPxhy5Ft60";

    private static OkHttpClient httpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            final Request request = chain.request();
            final HttpUrl httpUrl = request.url();
            final HttpUrl url = httpUrl.newBuilder()
                    .addQueryParameter("api_key", KEY)
                    .build();
            final Request.Builder builder = request.newBuilder()
                    .url(url);
            final Request r = builder.build();
            return chain.proceed(r);
        });

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(httpLoggingInterceptor);
        return httpClient.build();
    }

    public static NasaApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        String BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient())
                .build();

        return retrofit.create(NasaApi.class);
    }
}