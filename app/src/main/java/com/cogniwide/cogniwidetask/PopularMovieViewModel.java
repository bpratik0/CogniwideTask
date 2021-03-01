package com.cogniwide.cogniwidetask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.CogniwideComponent;
import dagger.DaggerCogniwideComponent;

public class PopularMovieViewModel extends ViewModel {

    @Inject
    public RetrofitRepository mRetrofitRepository;
    private CogniwideComponent myComponent;

    public void init() {
       // mRetrofitRepository = mRetrofitRepository.getInstance();
        myComponent = DaggerCogniwideComponent.create();
        myComponent.inject(this);
    }

    public MutableLiveData<List<PopularMoviesModel>> getNewsRepository() {
        return mRetrofitRepository.getPopularMovies();
    }
}
