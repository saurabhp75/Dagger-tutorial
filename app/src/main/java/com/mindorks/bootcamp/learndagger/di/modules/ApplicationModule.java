package com.mindorks.bootcamp.learndagger.di.modules;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseInfo;
import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo;

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

//    @ApplicationContext
    @Provides
    Context provideContext() {
        return application;
    }

    // DatabaseInfo annotation required as there are two methods to provide the String
    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "mydb";
    }

    @Provides
//    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }


    // NetworkInfo annotation required as there are two methods to provide the String
    @Provides
    @NetworkInfo
    String provideApiKey() {
        return "mykey";
    }


    // Provides annotation tells Dagger which method to call to provide the dependency/instance
    // Singleton annotation tells Dagger to provide only one instance of the class
    // Below methods are not needed as we are injecting them in the constructor
//    @Singleton
//    @Provides
//    NetworkService provideNetworkService(){
//        return new NetworkService(application, "mykey");
//    }
//
//    @Singleton
//    @Provides
//    DatabaseService provideDatabaseService(){
//        return new DatabaseService(application, "mydb", 1);
//    }
}
