package com.cogniwide.cogniwidetask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.ApiModule;
import dagger.CogniwideComponent;
import dagger.DaggerCogniwideComponent;
import dagger.PopularMoviesModule;

public class PopularMovieViewModel extends ViewModel {

    @Inject
    public RetrofitRepository mRetrofitRepository;
    private CogniwideComponent mMyComponent;

    public void init() {
        mMyComponent = DaggerCogniwideComponent.builder().popularMoviesModule(new PopularMoviesModule())
                .apiModule(new ApiModule(null))
                .build();
        mMyComponent.inject(this);
    }

    public MutableLiveData<List<PopularMoviesModel>> getNewsRepository() {
        return mRetrofitRepository.getPopularMovies();
    }
}
