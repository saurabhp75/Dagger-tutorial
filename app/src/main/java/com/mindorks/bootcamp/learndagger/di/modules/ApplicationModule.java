package com.mindorks.bootcamp.learndagger.di.modules;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Module annotation tells Dagger that this class has method to provide a dependencies/instances
@Module
public class ApplicationModule {

    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    // Provides annotation tells Dagger which method to call to provide the dependency/instance
    // Singleton annotation tells Dagger to provide only one instance of the class
    @Singleton
    @Provides
    NetworkService provideNetworkService(){
        return new NetworkService(application, "mykey");
    }

    @Singleton
    @Provides
    DatabaseService provideDatabaseService(){
        return new DatabaseService(application, "mydb", 1);
    }

}
