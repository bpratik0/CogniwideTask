package dagger;

import android.app.Application;

public class MyApplication extends Application {
    private CogniwideComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerCogniwideComponent.builder().apiModule(new ApiModule("\"http://api.themoviedb.org/3/movie/")).build();

    }

    public CogniwideComponent getNetComponent() {
        return mApiComponent;
    }
}
