package dagger;

import com.cogniwide.cogniwidetask.PopularMovieViewModel;
import com.cogniwide.cogniwidetask.PopularMoviesActivity;
import com.cogniwide.cogniwidetask.RetrofitRepository;

import javax.inject.Singleton;

@Singleton
@Component(modules = {PopularMoviesModule.class, ApiModule.class})
public interface CogniwideComponent {
    void inject(PopularMovieViewModel popularMovieViewModel);
    void inject(PopularMoviesActivity popularMoviesActivity);
}
