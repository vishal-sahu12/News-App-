package com.example.mynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("country") String countryName,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<MainNews> getCategoryNews(
            @Query("country") String countryName,
            @Query("categories") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );
}
