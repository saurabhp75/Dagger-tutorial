package com.mindorks.bootcamp.learndagger.ui;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;

import javax.inject.Inject;

public class MainViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;

    // Using Inject here will tell Dagger to provide the instances of db and nw
    // Now we don't need @Provides annotation
    @Inject
    public MainViewModel(DatabaseService databaseService, NetworkService networkService) {
        this.databaseService = databaseService;
        this.networkService = networkService;
    }

    public String getSomeData() {
        return databaseService.getDummyData() + " : " + networkService.getDummyData();
    }
}
