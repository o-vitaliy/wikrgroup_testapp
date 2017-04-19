package com.wikrgroup.testapp;

import android.app.Application;

import com.wikrgroup.testapp.di.components.AppComponent;
import com.wikrgroup.testapp.di.components.DaggerAppComponent;
import com.wikrgroup.testapp.di.modules.AppModule;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class WikrApp extends Application {


    private AppComponent appComponent;

    public WikrApp() {
        super();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

}
