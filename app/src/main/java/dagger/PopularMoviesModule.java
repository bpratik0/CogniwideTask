package dagger;

import android.content.Context;

import retrofit.RetrofitRepository;

import javax.inject.Singleton;

@Module
public class PopularMoviesModule {

    private final Context context;

    public PopularMoviesModule (Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public RetrofitRepository provideContext() {
        return new RetrofitRepository(context);
    }
}
