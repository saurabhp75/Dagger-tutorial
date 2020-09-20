package com.mindorks.bootcamp.learndagger.data.remote;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */

// Singleton annotation is required as we have removed the Provides methods
@Singleton
public class NetworkService {

    private Context context;
    private String apiKey;

    @Inject
    public NetworkService(Context context, @NetworkInfo String apiKey) {
        this.context = context;
        // do the initialisation here
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }
}
