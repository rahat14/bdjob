package com.syntexterror.bdjobsolution;

import android.app.Application;
import android.content.Intent;

public class Home extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, persistant_service.class));

    }
}
