package com.mindorks.bootcamp.learndagger.data.remote;

import android.content.Context;

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */
public class NetworkService {

    private Context context;
    private String apiKey;

    public NetworkService(Context context, String apiKey) {
        this.context = context;
        // do the initialisation here
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }
}
