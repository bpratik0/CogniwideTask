package dagger;

import com.cogniwide.cogniwidetask.RetrofitRepository;

import javax.inject.Singleton;

@Module
public class PopularMoviesModule {
    @Singleton
    @Provides
    public RetrofitRepository provideContext() {
        return new RetrofitRepository();
    }
}
