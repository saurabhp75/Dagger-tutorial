package com.mindorks.bootcamp.learndagger.ui;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;

public class MainViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;

    public MainViewModel(Context context) {
        networkService = new NetworkService(context);
        databaseService = new DatabaseService(context);
    }

    public String getSomeData() {
        return databaseService.getDummyData() + " : " + networkService.getDummyData();
    }
}
