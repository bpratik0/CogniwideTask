package com.cogniwide.cogniwidetask;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import dagger.MyApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRepository {

    private String API_KEY = "f106692af7b706f509359e6e8f9e6096";
    private RetrofitInterface mRetrofitService;
    @Inject
    Retrofit mRetrofit;

    @Inject
    public RetrofitRepository() {

    }

    public MutableLiveData<List<PopularMoviesModel>> getPopularMovies() {
        MutableLiveData<List<PopularMoviesModel>> poListMutableLiveData = new MutableLiveData<>();
        mRetrofitService = mRetrofit.create(RetrofitInterface.class);
        Call<MoviesResponse> call = mRetrofitService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                MoviesResponse dataList = response.body();
                Log.i("MainActivity", "onResponse: " + dataList.getResults());
                poListMutableLiveData.setValue(dataList.getResults());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
               poListMutableLiveData.setValue(null);
            }
        });
        return poListMutableLiveData;
    }
}
