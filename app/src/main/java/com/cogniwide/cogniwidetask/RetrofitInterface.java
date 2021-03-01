package com.cogniwide.cogniwidetask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("popular")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
