package dagger;

import com.cogniwide.cogniwidetask.PopularMoviesActivity;

import viewmodel.PopularMovieViewModel;
import retrofit.RetrofitRepository;

import javax.inject.Singleton;

@Singleton
@Component(modules = {PopularMoviesModule.class, AppModule.class, NetworkModule.class})
public interface CogniwideComponent {
    void inject(PopularMovieViewModel popularMovieViewModel);

    void inject(RetrofitRepository popularMoviesActivity);

    void inject(PopularMoviesActivity popularMoviesActivity);
}
