package com.mindorks.bootcamp.learndagger;

import android.app.Application;
import android.util.Log;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.components.ApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.components.DaggerApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    private String TAG = "ApplicationModule";

    // We need this as db and nw instances are to be shared with activity component
    public ApplicationComponent applicationComponent;

    // @Inject annotation tells Dagger to provide these dependencies
    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;

    // If we use Singleton annotation, then this will also contain same instance as networkService
//    @Inject
//    public NetworkService networkService2;

    @Override
    public void onCreate() {
        super.onCreate();
        // DaggerApplicationComponent class is created using annotation processing, when we build
        // the project after adding the annotations
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);

        Log.d(TAG, networkService.toString());
    }
}