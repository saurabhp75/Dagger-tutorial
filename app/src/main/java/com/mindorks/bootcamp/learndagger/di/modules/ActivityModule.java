package com.mindorks.bootcamp.learndagger.di.modules;

import android.app.Activity;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    MainViewModel provideMainViewModel(DatabaseService databaseService,
                                       NetworkService networkService) {
        return new MainViewModel(databaseService, networkService);
    }


// Don't create db and nw service manually here, reuse the one created in application class
//    @Provides
//    MainViewModel provideMainViewModel() {
//        return new MainViewModel(
//                new DatabaseService(activity.getApplication(), "mydb", 1),
//                new NetworkService(activity.getApplication(), "mykey"));
//    }

}
