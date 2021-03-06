package com.cogniwide.cogniwidetask;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.cogniwide.cogniwidetask.databinding.ActivityPopulerMoviesBinding;

import java.util.List;

import adapter.CustomAdapter;
import model.PopularMoviesModel;
import viewmodel.PopularMovieViewModel;

public class PopularMoviesActivity extends AppCompatActivity {

    private ActivityPopulerMoviesBinding mPopulerMoviesBinding;
    private PopularMovieViewModel mPopularMovieViewModel;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mPopulerMoviesBinding = DataBindingUtil.setContentView(this, R.layout.activity_populer_movies);
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mPopulerMoviesBinding.recyclerMovies.setLayoutManager(mGridLayoutManager);
        mPopularMovieViewModel = ViewModelProviders.of(this).get(PopularMovieViewModel.class);
        mPopularMovieViewModel.getNewsRepository().observe(this, new Observer<List<PopularMoviesModel>>() {
            @Override
            public void onChanged(List<PopularMoviesModel> populerMoviesModels) {
                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), populerMoviesModels);
                mPopulerMoviesBinding.recyclerMovies.setAdapter(customAdapter); //
            }
        });
    }

}
